package realize.admin.service;

import com.alibaba.fastjson.JSONObject;
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
import java.sql.SQLException;

@WebServlet("/delete")
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
        Connection conn = null;
        JSONObject jsonObject = new JSONObject();
        try {
            conn = DBUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String bookname = req.getParameter("bookname");
        String sql = "delete from library.books where bookname = ?";
        PreparedStatement pstm = null;
        PrintWriter printWriter = resp.getWriter();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,bookname);
            pstm.executeUpdate();
            DBUtils.releaseConnection(conn,pstm, pstm.getResultSet());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.setContentType("text/json;charset=UTF-8");
        code co = new code(205,"successful response");
        jsonObject.put("information",co);
        System.out.println(jsonObject.toJSONString());
        printWriter.write(jsonObject.toJSONString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
