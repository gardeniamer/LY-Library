package realize.user.showUser.dao;

import Util.JDBCUtil.JDBCUtil;
import realize.user.register.entity.registerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class showUserDao {
    public ArrayList<registerEntity> showUser(String userName) throws Exception {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from library.users where users.name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();
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
            System.out.println(registerEntities);

        }
        System.out.println(registerEntities);
        System.out.println("已展示用户自身信息");
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return registerEntities;
    }
}
