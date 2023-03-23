package realize.admin.service;

import com.alibaba.fastjson.JSON;
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
@WebServlet("/update")
public class update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject jsonObject = new JSONObject();

        String writer = req.getParameter("writer");

        String publishing_house = req.getParameter("publishing_house");

        String number = req.getParameter("number");

        String classification = req.getParameter("classification");

        String introduction = req.getParameter("introduction");

        String updateBookname = req.getParameter("updateBookname");

        Connection conn = null;

        try {

            conn = DBUtils.getConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        PreparedStatement pstm = null;

        PrintWriter printWriter = resp.getWriter();

        String sql = "update library.books set writer=?,publishing_house=?,number=?,classification=?,introduction=? where bookname=?";

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setString(1,writer);

            pstm.setString(2,publishing_house);

            pstm.setString(3,number);

            pstm.setString(4,classification);

            pstm.setString(5,introduction);

            pstm.setString(6,updateBookname);

            pstm.executeUpdate();

            DBUtils.releaseConnection(conn,pstm,null);

        } catch (SQLException e) {

            e.printStackTrace();

        }


        resp.setContentType("text/json;charset=UTF-8");

        code co = new code(206,"successful response");

        String s = JSON.toJSONString(co);

        jsonObject.put("information",co);

        System.out.println(jsonObject.toJSONString());

        printWriter.write(jsonObject.toJSONString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);

    }

}
