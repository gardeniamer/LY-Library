package realize.user.reference.dao;

import Util.JDBCUtil.JDBCUtil;
import realize.user.reference.entity.booksEntity;

import java.sql.*;
import java.util.ArrayList;

public class referenceDao {
    private booksEntity books;

    public referenceDao() {
    }

    public referenceDao(booksEntity books) {
        this.books = books;
    }

    //展示所有书籍,即内容展示
    public ArrayList<booksEntity> presentAllBooks() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from library.books";
        ResultSet resultSet = statement.executeQuery(sql);
        //定义书籍类的集合 , 最后返回该集合
        ArrayList<booksEntity> booksEntities = new ArrayList<>();
        while(resultSet.next()){
            booksEntity booksEntity = new booksEntity();
            booksEntity.getBookname();
            booksEntity.getWriter();
            booksEntity.getPublishing_house();
            booksEntity.getNumber();
            booksEntity.getClassification();
            booksEntity.getIntroduction();
            booksEntities.add(booksEntity);

        }
        System.out.println(booksEntities);
        System.out.println("已执行展示书籍");
        resultSet.close();
        statement.close();
        return booksEntities;
    }

    //分类展示
    public ArrayList<booksEntity> presentBooksByclassification(String classification) throws Exception{
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from library.books where classification = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,classification);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<booksEntity> booksEntities = new ArrayList<>();
        while (rs.next()) {
            booksEntity booksEntity=new booksEntity();
            booksEntity.setBookname(rs.getNString("bookName"));
            booksEntity.setWriter(rs.getString("writer"));
            booksEntity.setPublishing_house(rs.getString("Publishing_house"));
            booksEntity.setNumber(rs.getString("number"));
            booksEntity.setClassification(rs.getString("classification"));
            booksEntity.setIntroduction(rs.getString("introduction"));
            booksEntities.add(booksEntity);
            System.out.println(booksEntities);
        }

        System.out.println(booksEntities);
        System.out.println("已执行分类展示书籍");
        rs.close();
        pstmt.close();
        return booksEntities;
    }

    //关键字搜索展示
    public ArrayList<booksEntity> presentcertainBook(String bookName) throws Exception{
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from library.books where bookname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,bookName);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<booksEntity> booksEntities = new ArrayList<>();
        while (rs.next()) {
            booksEntity booksEntity=new booksEntity();
            booksEntity.setBookname(rs.getNString("bookName"));
            booksEntity.setWriter(rs.getString("writer"));
            booksEntity.setPublishing_house(rs.getString("Publishing_house"));
            booksEntity.setNumber(rs.getString("number"));
            booksEntity.setClassification(rs.getString("classification"));
            booksEntity.setIntroduction(rs.getString("introduction"));
            booksEntities.add(booksEntity);
            System.out.println(booksEntities);
        }

        System.out.println(booksEntities);
        System.out.println("已执行关键字搜索展示");
        rs.close();
        pstmt.close();
        return booksEntities;
    }
}
