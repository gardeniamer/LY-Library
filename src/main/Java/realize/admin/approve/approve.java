package realize.admin.approve;

import com.alibaba.fastjson.JSONObject;
import realize.admin.dao.Books;
import realize.admin.dao.code;
import realize.admin.utils.DBUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/approve")
public class approve extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Integer> list = new ArrayList<>();
        Books books = new Books();
        Connection conn = null;
        JSONObject jsonObject = new JSONObject();
        String borrowerName = req.getParameter("name");
        int isExamined = Integer.parseInt(req.getParameter("isExamined"));
        String bookname = req.getParameter("bookname");
        try {
            conn = DBUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement pstm = null;

        PreparedStatement pstm1 = null;

        PreparedStatement pstm2 = null;

        PreparedStatement pstm3 = null;

        PreparedStatement pstm4 = null;

        ResultSet rs = null;

        ResultSet rs1 = null;

        PrintWriter printWriter = resp.getWriter();

        String sql_query = "SELECT number FROM library.books WHERE bookname = ?";//查找图书数量 用于判断是否小于等于0

        String sql = "UPDATE library.books SET number=number-1 WHERE bookname=?";//根据bookname修改图书数量 借出去一本就减一

        String sql_isExamined1 = "UPDATE library.borrowers SET examined='已审批' , approved='通过' WHERE book=? AND name=?";//已审批 审批通过

        String sql_isExamined2 = "UPDATE library.borrowers SET examined='已审批' , approved='不通过' WHERE book=? AND name=?";//已审批 审批未通过

        try {

            pstm = conn.prepareStatement(sql_query);

            pstm.setString(1, bookname);

            rs = pstm.executeQuery();

            while (rs.next()) {

                int booknumbers = rs.getInt("number");

                books.setNumber(String.valueOf(booknumbers));

                list.add(booknumbers);

            }

            DBUtils.releaseConnection(null, pstm, rs);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        jsonObject.put("num", list);

        System.out.println(jsonObject.toJSONString());

        printWriter.write(jsonObject.toJSONString());//查找所借阅书的数量

        if (isExamined == 1 && list.get(0) > 0) {//同意审批且剩余书的数量大于0

            try {
                pstm1 = conn.prepareStatement(sql);

                pstm2 = conn.prepareStatement(sql_isExamined1);

                pstm1.setString(1, bookname);

                pstm2.setString(1,bookname);

                pstm2.setString(2,borrowerName);

                pstm1.executeUpdate();

                pstm2.executeUpdate();

                DBUtils.releaseConnection(conn, pstm1, null);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            //DBUtils.releaseConnection(conn, pstm2, null);


            code co = new code(207, "success loan");


            jsonObject.put("information", co);

            System.out.println(jsonObject.toJSONString());

            printWriter.write(jsonObject.toJSONString());


        } else if (isExamined == 1 && list.get(0) <= 0) {//同意审批但所借书的数量小于或者等于0

            try {
                pstm3 = conn.prepareStatement(sql_isExamined2);

                pstm3.setString(1, bookname);

                pstm3.setString(2,borrowerName);

                pstm3.executeUpdate();

                DBUtils.releaseConnection(conn, pstm3, rs1);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            code co = new code(-7, "not enough books left");

            jsonObject.put("information", co);

            System.out.println(jsonObject.toJSONString());

            printWriter.write(jsonObject.toJSONString());

        } else if (isExamined == 0) {//审批不通过

            try {
                pstm4 = conn.prepareStatement(sql_isExamined2);

                pstm4.setString(1, bookname);

                pstm4.setString(2,borrowerName);

                pstm4.executeUpdate();

                DBUtils.releaseConnection(conn, pstm4, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
                code co = new code(-8, "fail to approve");
            jsonObject.put("information", co);
            System.out.println(jsonObject.toJSONString());
            printWriter.write(jsonObject.toJSONString());
        }
    }
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
