package vyass.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VyassEval {

    private HashMap<String, Tag> scopeTable = new HashMap<String, Tag>();
    private HashMap<String, Tag> oldTagTableReference;

    private LinkedList<HashMap<String, Tag>> scopeGlobal = new LinkedList<HashMap<String, Tag>>();

    private Stack<String> programStack = new Stack<String>();

    private int operatorIntCode = 0;
    private int operatorComparatorCode = 0;
    private int scope = 0;

    private String checkBlockStackValue = "";
    private String stackTopValue = "";

    private boolean operatorIntFlag = false;
    private boolean operatorComparatorFlag = false;
    private boolean flag = false;
    private boolean displayFlag = false;
    private boolean displayFlag2 = false;
    private boolean checkConditionFlag = false;
    private boolean loopScopeFlag = false;
    private boolean loopScopeExecutionFlag = false;
    private boolean blockExecutionFlag = false;
    private boolean returnTopValueFlag = false;

    private ArrayList<String> parameterList = new ArrayList<String>();


    public VyassEval(List<SingleToken> tokens, HashMap<String, Tag> scopeTableRef, LinkedList<HashMap<String, Tag>> scopeTableGlobalRed) {
        this.scopeGlobal = scopeTableGlobalRed;
        this.scopeTable = scopeTableRef;
        this.init(tokens);
    }


    public VyassEval(List<SingleToken> tokens) {
        this.init(tokens);
    }


    private void init(List<SingleToken> tokens) {
        int counter = 0;
        scopeGlobal.push(scopeTable);
        int i = 0;
        while(i < tokens.size()) {

            SingleToken t = tokens.get(i);

            if (blockExecutionFlag) {
                if (tokens.get(counter).type.toString().equals("BLOCKEND")) {
                    blockExecutionFlag = !blockExecutionFlag;
                }
                counter++;
                continue;
            }

            if (t.type.toString().equals("KEYWORD")){
                if (t.stringValue.equals("LOOP")) {
                    if (tokens.get(counter + 1).type.toString().equals("KEYWORD")) {
                        loopScopeFlag = true;
                    }
                } else {
                    evaluateKeyWord(t.stringValue);
                }
            }

            else if (t.type.toString().equals("METH")){
                List<SingleToken> newTokens = new ArrayList<SingleToken>();
                int methScope = 0;
                String name = "";
                boolean startMethBody = false;
                for (int j = i; j < tokens.size(); j++) {
                    if (j == i) {
                        name = tokens.get(j + 1).stringValue;
                    }
                    if (tokens.get(j).stringValue.equals("{")) {
                        methScope++;
                        startMethBody = true;
                    }
                    if (startMethBody) {
                        newTokens.add(tokens.get(j));
                    }
                    if (tokens.get(j).stringValue.equals("}")) {
                        methScope--;
                        if (methScope == 0) {
                            startMethBody = false;
                            i = j;
                            counter = j;
                            break;
                        }
                    }
                }
                insert(name, new Tag(newTokens, scope));
            }

            else if (t.type.toString().equals("METHODLOAD")){
                String methName = "";
                List<SingleToken> newTokensList = null;
                for (int j = i; j < tokens.size(); j++) {
                    if (j == i) {
                        methName = tokens.get(j + 1).stringValue;
                    }
                    if (j + 1 < tokens.size()) {
                        if (!(tokens.get(j + 1).type.toString().equals("IDENTIFIER") || tokens.get(j + 1).type.toString().equals("COMMA") || tokens.get(j + 1).type.toString().equals("INTEGER"))) {
                            i = j;
                            counter = j;
                            break;
                        }
                    }
                    if (j == tokens.size() - 1) {
                        i = j;
                        counter = j;
                        break;
                    }
                }

                for (HashMap<String, Tag> tempTagTable : scopeGlobal) {
                    Tag findTag = tempTagTable.get(methName);
                    if (findTag != null) {
                        newTokensList = findTag.getTagValueList();
                        break;
                    }
                }
                VyassEval st = new VyassEval(newTokensList, scopeTable, scopeGlobal);
                programStack.push(st.getReturnValue());
            }

            else if (t.type.toString().equals("IDENTIFIER")){
                programStack.push(t.stringValue);
                if (counter + 1 < tokens.size()) {
                    if (tokens.get(counter + 1).type.toString().equals("COMMA")) {
                        String stackTag = programStack.pop();
                        for (HashMap<String, Tag> tempTagTable : scopeGlobal) {
                            Tag findTag = tempTagTable.get(stackTag);
                            if (findTag != null) {
                                parameterList.add(findTag.getTagValue());
                                break;
                            }
                        }
                    }
                }
            }

            else if (t.type.toString().equals("INTEGER")){
                programStack.push(t.stringValue);
                if (counter + 1 < tokens.size()) {
                    if (tokens.get(counter + 1).type.toString().equals("COMMA")) {
                        parameterList.add(programStack.pop());
                    }
                }
            }

            else if (t.type.toString().equals("STRING")){
                programStack.push(t.stringValue);
                if (counter + 1 < tokens.size()) {
                    if (tokens.get(counter + 1).type.toString().equals("COMMA")) {
                        parameterList.add(programStack.pop());
                    }
                }
            }

            else if (t.type.toString().equals("BLOCKSTART")){
                if (loopScopeFlag) {
                    if (!loopScopeExecutionFlag) {
                        boolean foundLoopEnd = false;
                        while (!foundLoopEnd) {
                            if (tokens.get(counter).stringValue.equals("}")) {
                                foundLoopEnd = true;
                            } else {
                                counter++;
                            }
                        }
                        i = counter;
                    }
                }
                scope++;
                oldTagTableReference = scopeTable;
                scopeTable = new HashMap<String, Tag>();
                scopeGlobal.push(scopeTable);
            }

            else if (t.type.toString().equals("BLOCKEND")){
                scope--;
                scopeGlobal.pop();
                scopeTable = oldTagTableReference;
                if (checkConditionFlag) {
                    checkConditionFlag = false;
                }
                if (loopScopeExecutionFlag) {
                    boolean foundLoopStart = false;
                    while (!foundLoopStart) {
                        if (tokens.get(counter).stringValue.equals("LOOP")) {
                            foundLoopStart = true;
                        } else {
                            counter--;
                        }
                    }
                    i = counter;
                } else {
                    loopScopeFlag = false;
                }
            }


            if (flag && programStack.size() >= 2 && !(operatorComparatorFlag || operatorIntFlag)) {
                doSetOperation();
                flag = false;
            }
            if (displayFlag && programStack.size() >= 1) {
                printToConsole();
            }
            if (returnTopValueFlag && programStack.size() >= 1) {
                setReturnValue();
            }
            if (checkConditionFlag) {
                if (!operatorComparatorFlag) {
                    if (programStack.size() > 0) {
                        if (programStack.peek().equals("TRUE") || programStack.peek().equals("FALSE")) {
                            checkBlockStackValue = programStack.pop();
                        }
                    }
                }
                if (t.type.toString().equals("BOOLEAN")) {
                    if (t.stringValue.equals(checkBlockStackValue)) {
                        blockExecutionFlag = false;
                    } else {
                        blockExecutionFlag = true;
                    }
                }
            }
            if (operatorIntFlag) {
                if (counter + 1 < tokens.size()) {
                    if (tokens.get(counter + 1).type.toString().equals("KEYWORD") || tokens.get(counter + 1).type.toString().equals("BLOCKEND") || tokens.get(counter + 1).type.toString().equals("METHODLOAD")) {
                        doNumericOperation();
                        operatorIntFlag = false;
                    }
                } else {
                    doNumericOperation();
                    operatorIntFlag = false;
                }
            }
            if (operatorComparatorFlag) {
                if (counter + 1 < tokens.size()) {
                    if (tokens.get(counter + 1).type.toString().equals("KEYWORD") || tokens.get(counter + 1).type.toString().equals("BOOLEAN") || tokens.get(counter + 1).type.toString().equals("BLOCKSTART")) {
                        doCompOperation();
                        operatorIntFlag = false;
                    }
                } else {
                    doCompOperation();
                    operatorIntFlag = false;
                }
            }
            if (counter + 1 < tokens.size()) {
                if (tokens.get(counter + 1).stringValue.equals("PRINT")) {
                    displayFlag2 = true;
                } else {
                    displayFlag2 = false;
                }
            }
            counter++;

            i++;
        }


        if (displayFlag && programStack.size() >= 1) {
            printToConsole();
        }
        if (flag && programStack.size() >= 2) {
            doSetOperation();
            flag = false;
        }
    }


    private void insert(String scopeName, Tag scope) {
        scopeTable.put(scopeName, scope);
    }


    private void insertScoped(HashMap<String, Tag> scopedTagTable, String scopeName, Tag scope) {
        scopedTagTable.put(scopeName, scope);
    }


    private void setReturnValue() {
        String toReturn = "";
        String stackTop = programStack.pop();
        boolean scopeFound = false;
        for (HashMap<String, Tag> tempTagTable : scopeGlobal) {
            Tag findTag = tempTagTable.get(stackTop);
            if (findTag != null) {
                toReturn = findTag.getTagValue();
                scopeFound = true;
                break;
            }
        }
        if (!scopeFound) {
            toReturn = stackTop;
        }
        stackTopValue = toReturn;
        returnTopValueFlag = false;
    }


    public String getReturnValue() {
        return stackTopValue;
    }


    private void inputReader() {
        String userInput;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            userInput = br.readLine();
            programStack.push(userInput);
        } catch (IOException ioe) {
            System.out.println("IO error!");
        }
    }


    private void printToConsole() {
        if (!operatorIntFlag && !operatorComparatorFlag) {
            String toPrint = programStack.pop();
            boolean scopeFound = false;
            for (HashMap<String, Tag> tempscopeTable : scopeGlobal) {
                Tag findTag = tempscopeTable.get(toPrint);
                if (findTag != null) {
                    System.out.println(findTag.getTagValue());
                    scopeFound = true;
                    break;
                }
            }
            if (!scopeFound) {
                System.out.println(toPrint);
            }
            if (displayFlag2)
                displayFlag = true;
            else
                displayFlag = false;
        }
    }


    private void doSetOperation() {
        String value = programStack.pop();
        String name = programStack.pop();
        if (scope != 0) {
            boolean scopeFound = false;
            for (HashMap<String, Tag> tempTagTable : scopeGlobal) {
                Tag findTag = tempTagTable.get(name);
                if (findTag != null) {
                    insertScoped(tempTagTable, name, new Tag(value, findTag.getScopeValue()));
                    scopeFound = true;
                    break;
                }

            }
            if (!scopeFound) {
                insert(name, new Tag(value, scope));
            }
        } else {
            boolean scopeFound = false;
            for (HashMap<String, Tag> tempTagTable : scopeGlobal) {
                Tag findTag = tempTagTable.get(name);
                if (findTag != null) {
                    insertScoped(tempTagTable, name, new Tag(value, findTag.getScopeValue()));
                    scopeFound = true;
                    break;
                }
            }

            if (!scopeFound) {
                if (parameterList.size() == 0) {
                    insert(name, new Tag(value, scope));
                } else {
                    parameterList.add(value);
                    insert(name, new Tag(parameterList.toString(), scope));
                    parameterList.clear();
                }
            }
        }
    }


    private void doNumericOperation() {
        float result = 0;
        int count = 0;
        String value = programStack.pop();
        boolean scopeFound = false;
        for (HashMap<String, Tag> tempTagTable : scopeGlobal) {
            Tag findTag = tempTagTable.get(value);
            if (findTag != null) {
                parameterList.add(findTag.getTagValue());
                scopeFound = true;
                break;
            }
        }
        if (!scopeFound) {
            parameterList.add(value);
        }
        for (String s : parameterList) {
            if (count == 0) {
                result = Float.parseFloat(s);
                count++;
                continue;
            }
            switch (operatorIntCode) {
                case 1:
                    result = result + Float.parseFloat(s);
                    break;
                case 2:
                    result = result - Float.parseFloat(s);
                    break;
                case 3:
                    result = result * Float.parseFloat(s);
                    break;
                case 4:
                    result = result / Float.parseFloat(s);
                    break;
                case 5:
                    result = result % Float.parseFloat(s);
                    break;
            }
            count++;
        }
        programStack.push(Float.toString(result));
        operatorIntFlag = false;
        parameterList.clear();
    }


    private void doCompOperation() {
        String val = programStack.pop();
        boolean scopeFound = false;
        for (HashMap<String, Tag> tempTagTable : scopeGlobal) {
            Tag findTag = tempTagTable.get(val);
            if (findTag != null) {
                parameterList.add(findTag.getTagValue());
                scopeFound = true;
                break;
            }
        }
        if (!scopeFound) {
            parameterList.add(val);
        }
        boolean floatValue = false;
        String first = parameterList.get(parameterList.size() - 2);
        String second = parameterList.get(parameterList.size() - 1);
        float onef = 0;
        float twof = 0;
        if (isINT(first) && isINT(second)) {
            onef = Float.parseFloat(first);
            twof = Float.parseFloat(second);
            floatValue = true;
        }

        if (operatorComparatorCode == 1){
            if (floatValue) {
                if (onef < twof)
                    programStack.push("TRUE");
                else
                    programStack.push("FALSE");
            } else {
                System.out.println("Incomparable types");
            }

        }

        if (operatorComparatorCode == 2){
            if (floatValue) {
                if (onef > twof)
                    programStack.push("TRUE");
                else
                    programStack.push("FALSE");
            } else {
                System.out.println("Incomparable types");
            }

        }

        if (operatorComparatorCode == 3){
            if (floatValue) {
                if (onef >= twof)
                    programStack.push("TRUE");
                else
                    programStack.push("FALSE");
            } else {
                System.out.println("Incomparable types");
            }

        }

        if (operatorComparatorCode == 4){
            if (floatValue) {
                if (onef <= twof)
                    programStack.push("TRUE");
                else
                    programStack.push("FALSE");
            } else {
                System.out.println("Incomparable types");
            }

        }

        if (operatorComparatorCode == 5){
            if (floatValue) {
                if (onef == twof)
                    programStack.push("TRUE");
                else
                    programStack.push("FALSE");
            } else {
                System.out.println("Incomparable types");
            }

        }

        if (operatorComparatorCode == 6){
            if (floatValue) {
                if (onef != twof)
                    programStack.push("TRUE");
                else
                    programStack.push("FALSE");
            } else {
                System.out.println("Incomparable types");
            }

        }

        operatorComparatorFlag = false;
        parameterList.clear();
        if (loopScopeFlag) {
            if (programStack.pop().equals("TRUE")) {
                loopScopeExecutionFlag = true;
            } else {
                loopScopeExecutionFlag = false;
            }
        }
    }


    private static boolean isINT(String str) {
        try {
            Float d = Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    private void evaluateKeyWord(String val) {

        if(val.equals("ASSIGN")){
            flag = true;
        }
        else if(val.equals("INPUT")){
            inputReader();
        }
        else if(val.equals("DISPLAY")){
            displayFlag = true;
        }
        else if(val.equals("ADD")){
            operatorIntCode = 1;
            operatorIntFlag = true;
        }
        else if(val.equals("SUB")){
            operatorIntCode = 2;
            operatorIntFlag = true;
        }
        else if(val.equals("MUL")){
            operatorIntCode = 3;
            operatorIntFlag = true;
        }
        else if(val.equals("DIV")){
            operatorIntCode = 4;
            operatorIntFlag = true;
        }
        else if(val.equals("MOD")){
            operatorIntCode = 5;
            operatorIntFlag = true;
        }
        else if(val.equals("LESSTHAN")){
            operatorComparatorCode = 1;
            operatorComparatorFlag = true;
        }
        else if(val.equals("GREATERTHAN")){
            operatorComparatorCode = 2;
            operatorComparatorFlag = true;
        }
        else if(val.equals("GREATERTHANEQUALS")){
            operatorComparatorCode = 3;
            operatorComparatorFlag = true;
        }
        else if(val.equals("LESSTHANEQUALS")){
            operatorComparatorCode = 4;
            operatorComparatorFlag = true;
        }
        else if(val.equals("EQUALSTO")){
            operatorComparatorCode = 5;
            operatorComparatorFlag = true;
        }
        else if(val.equals("NOTEQUALS")){
            operatorComparatorCode = 6;
            operatorComparatorFlag = true;
        }
        else if(val.equals("IF")){
            checkConditionFlag = true;
        }
        else if(val.equals("TERNARY")){
            checkConditionFlag = true;
        }
        else if(val.equals("RETURN")){
            returnTopValueFlag = true;
        }
    }

}
