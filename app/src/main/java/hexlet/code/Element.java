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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setValueSecondMap(Object value) {
        this.contentSecondMap = value;
    }

    public void setValueFirstMap(Object value) {
        this.contentFirstMap = value;
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
