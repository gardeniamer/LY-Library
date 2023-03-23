package realize.user.borrowbook.dao;

import Util.JDBCUtil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class borrowBookDao {
    public int borrowBook(String name, String book, String Borrow_Date, String Return_Date) throws Exception{
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into library.borrowers(name,book,examined,approved,Borrow_Date,Return_Date) values(?,?,'未审批','暂定',?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,book);
        pstmt.setString(3,Borrow_Date);
        pstmt.setString(4,Return_Date);
        int count = pstmt.executeUpdate();
        System.out.println("成功发送借书申请,影响行数:"+count+"行");
//        //以下方法可以作为成功借书后减书的操作
//        if (count>0){
//            String sql2 = "update library.books set number=number-1 where bookname=?";
//            PreparedStatement stmt = conn.prepareStatement(sql2);
//            stmt.setString(1,book);
//            count = stmt.executeUpdate(sql2);
//            stmt.close();
//        }
        pstmt.close();
        conn.close();
        return count;
    }
}

