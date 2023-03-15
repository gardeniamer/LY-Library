package realize.user.login.entity;

public class loginEntity {
    //登录时候需要的信息
    //放置一个个实体，及其相应的set、get方法,如果想要对数据库进行一些操作（比如说读取）的话，就要先写entity层。
    private String phoneNumber;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "loginEntity{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public loginEntity() {
    }

    public loginEntity(String phoneNumber, String email, String password) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
