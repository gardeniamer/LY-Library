package realize.user.register.entity;

public class returnCodeEntity {
    private int code;
    private String message;

    @Override
    public String toString() {
        return "returnCodeEntity{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public returnCodeEntity() {
    }

    public returnCodeEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
