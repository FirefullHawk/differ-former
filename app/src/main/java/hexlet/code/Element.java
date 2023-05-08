package hexlet.code;

public final class Element {
    private final Status status;
    private final String name;
    private final Object contentFirstMap;
    private final Object contentSecondMap;

    public Element(Status status, String name, Object contentFirstMap, Object contentSecondMap) {
        this.status = status;
        this.name = name;
        this.contentFirstMap = contentFirstMap;
        this.contentSecondMap = contentSecondMap;
    }
    public Element(Status status, String name, Object contentFirstMap) {
        this.status = status;
        this.name = name;
        this.contentFirstMap = contentFirstMap;
        this.contentSecondMap = null;
    }
    public Status getStatus() {
        return this.status;
    }

    public String getName() {
        return this.name;
    }

    public Object getValueFirstMap() {
        return this.contentFirstMap;
    }

    public Object getValueSecondMap() {
        return this.contentSecondMap;
    }
}
