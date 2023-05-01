package vyass;

import vyass.compiler.vyassCompiler;
import vyass.runtime.VyassEval;
import vyass.runtime.Tokens;

public class vyass {
    public static void main(String args[]) throws Exception {
        if(args.length < 1) {
            throw new RuntimeException("Pass the path to file as argument.");
        }
        vyassCompiler compiler = new vyassCompiler(args[0]);
        new VyassEval(new Tokens(compiler.getInterCode()).getTokens());
    }
}



