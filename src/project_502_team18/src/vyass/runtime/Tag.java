package vyass.runtime;

import java.util.List;

public class Tag {
    private String TagValue;
    private int tagScope;
    private List<SingleToken> tagValueList;


    Tag(String tagVal, int tagScope) {
        this.TagValue = tagVal;
        this.tagScope = tagScope;
    }


    Tag(List<SingleToken> tagValue, int tagScope) {
        this.tagValueList = tagValue;
        this.tagScope = tagScope;
    }


    public String getTagValue() {
        return this.TagValue;
    }


    public List<SingleToken> getTagValueList() {
        return this.tagValueList;
    }


    public int getScopeValue() {
        return this.tagScope;
    }


    @Override
    public String toString() {
        String scopeAndValue = "In the scope : "+this.tagScope+", Tag Value is : "+this.TagValue+" | Tag Value is : "+this.tagValueList;
        return scopeAndValue;
    }
}
