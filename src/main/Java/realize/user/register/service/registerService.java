package realize.user.register.service;

import Util.JDBCUtil.JDBCUtil;

import java.sql.*;

public class registerService {
    //查找用户表中是否有要注册的用户,如果有,注册就失败,没有,就注册成功
    Connection connection = JDBCUtil.getConnection();
    Statement statement = connection.createStatement();

    public registerService() throws SQLException {
    }

    public boolean registerTest(String name) throws Exception {
        String sql = "SELECT * FROM library.users WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet rs = preparedStatement.executeQuery();
        String name1;
        while (rs.next()){
            name1 = rs.getString("name");
            if (name.equals(name1)){
                return true;
            }
        }

        return false;
    }


}
