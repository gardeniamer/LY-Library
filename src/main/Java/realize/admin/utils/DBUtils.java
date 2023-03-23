package realize.admin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static Properties properties ;
    private static Connection connection = null;
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    static { //静态初始化器
        properties = new Properties();
        ClassLoader classLoader = DBUtils.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("JDBC.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取数据库的连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    //用于关闭数据库的连接对象
    public static void releaseConnection(Connection conn, PreparedStatement pstm, ResultSet rs) throws SQLException {
        if (rs!=null)
            rs.close();
        if (pstm!=null)
            pstm.close();
        if (conn!=null)
            conn.close();


    }
}