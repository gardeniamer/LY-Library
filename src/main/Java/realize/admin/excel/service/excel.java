package realize.admin.excel.service;


import Util.JDBCUtil.JDBCUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class excel {
    @Test
    public void export() throws Exception{
        //声明需要导出的数据库，focus为数据库名称
        String dbName = "library";
        //声明book

        HSSFWorkbook book = new HSSFWorkbook();
        //获取Connection,获取db的元数据
        //获得数据库连接,跟你项目本身的数据库连接进行自身的操作
        Connection con = JDBCUtil.getConnection();
        //声明statemen
        Statement st = con.createStatement();
        //st.execute("use "+dbName);
        DatabaseMetaData dmd = con.getMetaData();
        //获取数据库有多少表
        ResultSet rs = dmd.getTables(dbName,dbName,null,new String[]{"TABLE"});
        //获取所有表名　－　就是一个sheet
        List<String> tables = new ArrayList<String>();
        while(rs.next()){
            String tableName = rs.getString("TABLE_NAME");
            tables.add(tableName);
        }
        //此时的tables=>[表名, 表名, 表名]
        //循环访问依次表名
        for(String tableName:tables){
            //声明book中的各个表
            HSSFSheet sheet = book.createSheet(tableName);
            //声明sql
            String sql = "select * from "+dbName+"."+tableName;
            //查询数据
            rs = st.executeQuery(sql);
            //根据查询的结果，分析结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取这个查询有多少行
            int cols = rsmd.getColumnCount();
            //获取所有列名
            //创建第一行
            HSSFRow row = sheet.createRow(0);
            for(int i=0;i<cols;i++){
                String colName = rsmd.getColumnName(i+1);
                //创建一个新的列
                HSSFCell cell = row.createCell(i);
                //写入列名
                cell.setCellValue(colName);
            }
            //遍历数据
            int index = 1;
            while(rs.next()){
                row = sheet.createRow(index++);
                //声明列
                for(int i=0;i<cols;i++){
                    String val = rs.getString(i+1);
                    //声明列
                    HSSFCell cel = row.createCell(i);
                    //放数据
                    cel.setCellValue(val);
                }
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("d:/" + dbName + ".xls");
        book.write(fileOutputStream);
        fileOutputStream.close();
        con.close();
        book.close();
    }

}
