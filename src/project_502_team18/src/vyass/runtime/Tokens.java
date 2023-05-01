package vyass.runtime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokens {

    private List<SingleToken> tokens = new ArrayList<SingleToken>();
    private Pattern pttrn;
    private Matcher matcher;

    public Tokens(String interCode) {
        StringBuilder regex = new StringBuilder();
        for (TokenType t : TokenType.values()) {
            regex.append("|(?<").append(t.name()).append(">").append(t.pattern).append(")");
        }
        pttrn = Pattern.compile(regex.substring(1));
        try (BufferedReader br = new BufferedReader(new StringReader(interCode))) {
            String line;
            while ((line = br.readLine()) != null) {
                tokenize(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tokenize(String line) {
        matcher = pttrn.matcher(line);
        while (matcher.find()) {
            String tokenValue;
            for (TokenType tokentype : TokenType.values()) {
                if ((tokenValue = matcher.group(tokentype.name())) != null) {
                    tokens.add(new SingleToken(tokentype, tokenValue));
                    break;
                }
            }
        }
    }


    public List<SingleToken> getTokens() {
        return this.tokens;
    }
}


