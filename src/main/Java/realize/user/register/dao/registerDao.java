package realize.user.register.dao;

import Util.JDBCUtil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class registerDao {
    //用于执行用户的注册,关于用户注册的sql语句
    public void userRegister( String name,String period, String direction, String student_ID, String email, String password) throws Exception {
        Connection connection = JDBCUtil.getConnection();
        String sql = "INSERT INTO library.users (name,period,direction,student_ID,email,password) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,period);
        preparedStatement.setString(3,direction);
        preparedStatement.setString(4,student_ID);
        preparedStatement.setString(5,email);
        preparedStatement.setString(6,password);
        int count = preparedStatement.executeUpdate();
        System.out.println(count);
        preparedStatement.close();
    }
}
