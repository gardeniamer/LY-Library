package realize.user.register.entity;

public class User {
   private String name;
   private String period;
   private String direction;
   private String phoneNumber;
   private String email;
   private String password;

   public User() {
   }

   public User(String name, String period, String direction, String phoneNumber, String email, String password) {
      this.name = name;
      this.period = period;
      this.direction = direction;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPeriod() {
      return period;
   }

   public void setPeriod(String period) {
      this.period = period;
   }

   public String getDirection() {
      return direction;
   }

   public void setDirection(String direction) {
      this.direction = direction;
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

   @Override
   public String toString() {
      return "User{" +
              "name='" + name + '\'' +
              ", period='" + period + '\'' +
              ", direction='" + direction + '\'' +
              ", phoneNumber='" + phoneNumber + '\'' +
              ", email='" + email + '\'' +
              ", password='" + password + '\'' +
              '}';
   }
}
