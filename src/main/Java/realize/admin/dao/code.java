package realize.admin.dao;

public class code {
    private int code;
    private String message;

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

    public code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public code(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "code{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
