package vyass.compiler;

import vyass.compiler.gener.VyassLexer;
import vyass.compiler.gener.VyassParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class vyassCompiler {
    private CustomVyassListener listener;

    public vyassCompiler(String filename) throws Exception {
        CharStream input = CharStreams.fromFileName(filename);
        VyassLexer lexer = new VyassLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        VyassParser parser = new VyassParser(tokens);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        filename = filename.substring(0, filename.length() - 5);
        listener = new CustomVyassListener(filename);
        walker.walk(listener, tree);
    }

    public String getInterCode() {
        return listener.getIntermediateCodeBuilder();
    }
}