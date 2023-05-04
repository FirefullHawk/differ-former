package hexlet.code;

public class Element {
    private Status status;
    private final String name;
    private Object contentFirstMap;
    private Object contentSecondMap;

    Element(Status status, String name, Object contentFirstMap, Object contentSecondMap) {
        this.status = status;
        this.name = name;
        this.contentFirstMap = contentFirstMap;
        this.contentSecondMap = contentSecondMap;
    }
    Element(Status status, String name, Object contentFirstMap) {
        this.status = status;
        this.name = name;
        this.contentFirstMap = contentFirstMap;
        this.contentSecondMap = null;
    }
    Element() {
        this.status = null;
        this.name = null;
        this.contentFirstMap = null;
        this.contentSecondMap = null;
    }

    public final void setStatus(Status status) {
        this.status = status;
    }

    public final void setValueSecondMap(Object value) {
        this.contentSecondMap = value;
    }

    public final void setValueFirstMap(Object value) {
        this.contentFirstMap = value;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValueFirstMap() {
        return this.contentFirstMap;
    }

    public final Object getValueSecondMap() {
        return this.contentSecondMap;
    }
}
