package Util.JDBCUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("JDBC.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void free(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection) throws SQLException {
        if (resultSet!=null){
            resultSet.close();
        }

        if (preparedStatement!=null){
            preparedStatement.close();
        }

        if(connection!=null){
            connection.close();
        }

    }

}

