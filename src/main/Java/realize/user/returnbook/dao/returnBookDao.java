package realize.user.returnbook.dao;

import Util.JDBCUtil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class returnBookDao {
    //用户还书功能
    //略有问题.无法归还
    public int returnBook(String userName,String bookName,String ActualReturn_Date) throws Exception{
        Connection connection = JDBCUtil.getConnection();
        String sql = "update library.borrowers set returned = '已归还'where name=? ";
        //where library.borrowers.name = '" + userName + "'and library.borrowers.book=' + bookName + '
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,userName);
        //修改图书的状态为申请归还中
        int count = statement.executeUpdate();
        statement.close();
        return count;
    }

}
