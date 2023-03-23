package realize.user.login.entity;

public class loginEntity {
    //登录时候需要的信息
    //放置一个个实体，及其相应的set、get方法,如果想要对数据库进行一些操作（比如说读取）的话，就要先写entity层。
    private String student_ID;
    private String email;
    private String password;

    public loginEntity(String student_ID, String email, String password) {
        this.student_ID = student_ID;
        this.email = email;
        this.password = password;
    }

    public loginEntity() {
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "loginEntity{" +
                "student_ID='" + student_ID + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
