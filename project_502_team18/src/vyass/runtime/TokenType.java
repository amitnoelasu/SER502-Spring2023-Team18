package vyass.runtime;

public enum TokenType {
    BLOCKSTART("\\{"),
    BLOCKEND("\\}"),
    COMMA(","),
    STRING("\"(\\.|[^\"])*\""),
    INTEGER("(\\+|-)?\\d+(\\.\\d+)?"),
    BOOLEAN("TRUE|FALSE"),
    METH("METH"),
    METHODLOAD("LOAD"),
    KEYWORD("[A-Z][A-Z]*"),
    IDENTIFIER("[a-z_][A-Za-z0-9]*"),
    LT("<");

    public final String pattern;


    private TokenType(String pattern) {
        this.pattern = pattern;
    }
}
