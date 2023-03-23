package realize.admin.showUsers.dao;

import Util.JDBCUtil.JDBCUtil;
import realize.user.reference.entity.booksEntity;
import realize.user.register.entity.registerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class showUserDao {
    public ArrayList<registerEntity> presentAllUsers() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from library.users";
        ResultSet resultSet = statement.executeQuery(sql);
        //定义书籍类的集合 , 最后返回该集合
        ArrayList<registerEntity> registerEntities = new ArrayList<>();
        while(resultSet.next()){
            registerEntity registerEntity = new registerEntity();
            registerEntity.setName(resultSet.getString("name"));
            registerEntity.setPassword(resultSet.getString("password"));
            registerEntity.setPeriod(resultSet.getString("period"));
            registerEntity.setEmail(resultSet.getString("email"));
            registerEntity.setStudent_ID(resultSet.getString("student_ID"));
            registerEntity.setDirection(resultSet.getString("direction"));
            registerEntities.add(registerEntity);

        }
        System.out.println(registerEntities);
        System.out.println("已展示所有用户信息");
        resultSet.close();
        statement.close();
        return registerEntities;
    }
}
