package Util.druidUtil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

public class druidUtil {
    public static void main(String[] args) throws Exception {
        //导入jar包
        //定义配置文件
        //加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/Webapp/web/WEB-INF/lib/druid-1.1.12.jar"));

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //获取数据库链接connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);


    }
}
