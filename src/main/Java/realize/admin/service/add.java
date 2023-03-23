package realize.admin.service;


import com.alibaba.fastjson.JSONObject;
import realize.admin.dao.code;
import realize.admin.utils.DBUtils;

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

@WebServlet("/add")
public class add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<String> book = new ArrayList<>();
        Connection conn = null;
        JSONObject jsonObject = new JSONObject();
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        String bookname=req.getParameter("bookname");
        String writer = req.getParameter("writer");
        String publishing_house = req.getParameter("publishing_house");
        String number = req.getParameter("number");
        String classification = req.getParameter("classification");
        String introduction = req.getParameter("introduction");
        String sql_query = "SELECT * FROM library.books WHERE bookname=?";
        PreparedStatement pstm = null;
        PreparedStatement pstm1;
        String sql = "insert into library.books(bookname,writer,publishing_house,number,classification,introduction) values(?,?,?,?,?,?)";
        try {
            pstm1=conn.prepareStatement(sql_query);
            pstm1.setString(1,bookname);
            rs = pstm1.executeQuery();
            while(rs.next()){
                book.add(rs.getString("bookname"));
            }
            DBUtils.releaseConnection(null,pstm1,null);


            jsonObject.put("data",book);

            System.out.println(jsonObject.toJSONString());

            printWriter.write(jsonObject.toJSONString());





                try {
                    assert conn != null;
                    pstm = conn.prepareStatement(sql);
                    pstm.setString(1, bookname);
                    pstm.setString(2, writer);
                    pstm.setString(3, publishing_house);
                    pstm.setString(4, number);
                    pstm.setString(5, classification);
                    pstm.setString(6, introduction);
                    pstm.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        DBUtils.releaseConnection(conn,pstm,null);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                resp.setContentType("text/json;charset=UTF-8");
                code co = new code(203, "successful response");
                jsonObject.put("information", co);
                System.out.println(jsonObject.toJSONString());
                printWriter.write(jsonObject.toJSONString());



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
