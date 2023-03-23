package realize.user.login.service;

import Util.JDBCUtil.JDBCUtil;

import java.sql.*;

public class loginService {
    //写关于数据库的一些操作
    //接收从数据库中获取的数据
    private String name2 = null;

    //为了与数据库建立连接
    Connection connection;

    {
        try {
            connection = JDBCUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String LoginTest1(String student_ID, String password) throws SQLException {
        String loginsql = "SELECT * FROM library.users WHERE student_ID = ? and password = ?";
        PreparedStatement ps = connection.prepareStatement(loginsql);
        ps.setString(1,student_ID);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            name2 = rs.getString("name");
        }
        return name2;
    }

    public boolean LoginTest(String phoneNumber, String password) throws Exception {
        String loginsql1 = "select * from library.users where student_ID=? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(loginsql1);
        preparedStatement.setInt(1, Integer.parseInt(phoneNumber));
        preparedStatement.setInt(2, Integer.parseInt(password));
        ResultSet resultSet = preparedStatement.executeQuery();
        Boolean result = resultSet.next();
        System.out.println("result :"+result);
        return result;
    }

}
