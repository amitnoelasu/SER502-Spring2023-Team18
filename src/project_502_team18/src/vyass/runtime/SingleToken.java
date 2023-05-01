package vyass.runtime;

public class SingleToken {
    TokenType type;
    String stringValue;

    public SingleToken(TokenType type, String token) {
        this.type = type;
        this.stringValue = token;
    }
}
