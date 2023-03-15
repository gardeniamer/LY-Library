package realize.user.login.service;

import Util.JDBCUtil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginService {
    //写关于数据库的一些操作
    //接收从数据库中获取的数据
    private String phoneNumber1 = null;
    private String email1 = null;
    private String password1 = null;

    //为了与数据库建立连接
    Connection connection;

    {
        try {
            connection = JDBCUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean LoginTest(String phoneNumber, String email, String password) throws Exception {
        String loginsql = "SELECT * FROM library.users WHERE phoneNumber = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(loginsql);
            ps.setString(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                phoneNumber1 = rs.getString("phoneNumber");
                password1 = rs.getString("password");
                email1 = rs.getString("email");
                if ((phoneNumber.equals(phoneNumber1)||email.equals(email1)) && password.equals(password1)) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
