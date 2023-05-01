package vyass.compiler;

public class Pair<T, T1> {
    private T mKey;
    private T1 mValue;

    public Pair(T key, T1 value) {
        this.mKey = key;
        this.mValue = value;
    }

    public T key() {
        return mKey;
    }

    public void setKey(T key) {
        this.mKey = key;
    }

    public T1 value() {
        return mValue;
    }

    public void setValue(T1 value) {
        this.mValue = value;
    }
}
