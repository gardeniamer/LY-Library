package realize.user.reference.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import realize.user.reference.dao.referenceDao;
import realize.user.reference.entity.booksEntity;
import realize.user.register.entity.returnCodeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "/presentAllBooksServlet",value = "/presentAllBooks-servlet")
public class presentAllBooksServlet extends HttpServlet {

    private referenceDao rf = new referenceDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        ArrayList<booksEntity> booksEntities;
        try {
            booksEntities = rf.presentAllBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String jsonString = JSON.toJSONString(booksEntities);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(jsonString);
        returnCodeEntity code = new returnCodeEntity(203,"展示书籍成功");
        String json = JSONObject.toJSONString(code);
        printWriter.println(json);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
