package realize.user.register.dao;

import Util.JDBCUtil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class registerDao {
    //用于执行用户的注册,关于用户注册的sql语句
    //public void userRegister(Statement statement, String name, String direction, String phoneNumber, String email, String password) throws Exception {
    public void userRegister( String name, String direction, String phoneNumber, String email, String password) throws Exception {
        Connection connection = JDBCUtil.getConnection();
        String sql = "INSERT INTO library.users (name,direction,phoneNumber,email,password) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,direction);
        preparedStatement.setString(3,phoneNumber);
        preparedStatement.setString(4,email);
        preparedStatement.setString(5,password);
        int count = preparedStatement.executeUpdate();
        System.out.println(count);
        preparedStatement.close();
    }
}
