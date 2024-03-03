package sweStart.project.domain;


public class ValidationErrorResponse {
    private String field;
    private String defaultMessage;

    public ValidationErrorResponse(String field, String defaultMessage) {
        this.field = field;
        this.defaultMessage = defaultMessage;
    }

    public String getField() {
        return field;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
