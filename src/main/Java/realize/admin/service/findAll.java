package realize.admin.service;

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

@WebServlet("/findAll")
public class findAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Books> list= new ArrayList<>();

        Connection conn = null;

        try {

            conn = DBUtils.getConnection();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        PreparedStatement pstm = null;

        ResultSet rs = null;

        PrintWriter printWriter = resp.getWriter();

        String sql = "select * from library.books";

        try {

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();

            while (rs.next()){

                String bookname = rs.getString(1);

                String writer = rs.getString(2);

                String publishing_house = rs.getString(3);

                String number = rs.getString(4);

                String classification = rs.getString(5);

                String introduction = rs.getString(6);

                Books books = new Books(bookname,writer,publishing_house,number,classification,introduction);

                list.add(books);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                DBUtils.releaseConnection(conn,pstm,rs);

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

        code co = new code(204,"successful response");

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("data",list);

        jsonObject.put("information",co);

        resp.setContentType("text/json;charset=UTF-8");

        System.out.println(jsonObject.toJSONString());

        printWriter.write(jsonObject.toJSONString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);

    }

}