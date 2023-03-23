package realize.user.register.entity;

public class registerEntity {
   //注册时候需要的信息
   private String name;
   private String period;
   private String direction;
   private String student_ID;
   private String email;
   private String password;

   public registerEntity() {
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

   public registerEntity(String name, String period, String direction, String student_ID, String email, String password) {
      this.name = name;
      this.period = period;
      this.direction = direction;
      this.student_ID = student_ID;
      this.email = email;
      this.password = password;
   }

   @Override
   public String toString() {
      return "registerEntity{" +
              "name='" + name + '\'' +
              ", period='" + period + '\'' +
              ", direction='" + direction + '\'' +
              ", student_ID='" + student_ID + '\'' +
              ", email='" + email + '\'' +
              ", password='" + password + '\'' +
              '}';
   }
}
