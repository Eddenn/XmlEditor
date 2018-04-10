package app.panel;

public enum ActionType {
    DETAIL(HTTPMethod.GET,"/resume"),
    ADD(HTTPMethod.POST,"/insert"),
    DELETE(HTTPMethod.DELETE,"/delete"),
    MODIFY(HTTPMethod.PUT,"/update"),
    HELP(HTTPMethod.GET,"/help"),
    HOME(HTTPMethod.GET,"/"),
    RESUME(HTTPMethod.GET,"/resume");

    private HTTPMethod method;
    private String path;

    ActionType(HTTPMethod method, String path) {
        this.method = method;
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public HTTPMethod getMethod() {
        return method;
    }
}
