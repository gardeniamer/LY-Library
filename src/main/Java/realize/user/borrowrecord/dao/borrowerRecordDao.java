package realize.user.borrowrecord.dao;

import Util.JDBCUtil.JDBCUtil;
import realize.user.borrowbook.entity.borrowersEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class borrowerRecordDao {
    //查看某个成员的借书记录,需要传入名字
    //字段:name
    public ArrayList<borrowersEntity> borrowerCertainRecord(String userName) throws Exception{
        ArrayList<borrowersEntity> borrowersEntities = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from library.borrowers where name=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,userName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            borrowersEntity bs = new borrowersEntity();
            bs.setName(rs.getString("name"));
            bs.setBook(rs.getString("book"));
            bs.setExamined(rs.getString("examined"));
            bs.setApproved(rs.getString("approved"));
            bs.setBorrow_Date(rs.getString("Borrow_Date"));
            bs.setReturned(rs.getString("returned"));
            bs.setReturn_Date(rs.getString("Return_Date"));
            bs.setActualReturn_Date(rs.getString("ActualReturn_Date"));

            borrowersEntities.add(bs);
        }
        System.out.println(borrowersEntities);
        rs.close();
        pstmt.close();
        return borrowersEntities;
    }

    //查看所有借书记录
    public ArrayList<borrowersEntity> borrowerAllRecord() throws Exception{
        ArrayList<borrowersEntity> borrowersEntities = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from library.borrowers";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            borrowersEntity bs = new borrowersEntity();
            bs.setName(rs.getString("name"));
            bs.setBook(rs.getString("book"));
            bs.setExamined(rs.getString("examined"));
            bs.setApproved(rs.getString("approved"));
            bs.setBorrow_Date(rs.getString("Borrow_Date"));
            bs.setReturned(rs.getString("returned"));
            bs.setReturn_Date(rs.getString("Return_Date"));
            bs.setActualReturn_Date(rs.getString("ActualReturn_Date"));
            borrowersEntities.add(bs);
        }
        System.out.println(borrowersEntities);
        rs.close();
        pstmt.close();
        return borrowersEntities;
    }


    //查看所有借书记录
    public ArrayList<borrowersEntity> borrowerUnreturnedRecord() throws Exception{
        ArrayList<borrowersEntity> borrowersEntities = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from library.borrowers where returned ='未归还'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            borrowersEntity bs = new borrowersEntity();
            bs.setName(rs.getString("name"));
            bs.setBook(rs.getString("book"));
            bs.setExamined(rs.getString("examined"));
            bs.setApproved(rs.getString("approved"));
            bs.setBorrow_Date(rs.getString("Borrow_Date"));
            bs.setReturned(rs.getString("returned"));
            bs.setReturn_Date(rs.getString("Return_Date"));
            bs.setActualReturn_Date(rs.getString("ActualReturn_Date"));
            borrowersEntities.add(bs);
        }
        System.out.println(borrowersEntities);
        rs.close();
        pstmt.close();
        return borrowersEntities;
    }
}
