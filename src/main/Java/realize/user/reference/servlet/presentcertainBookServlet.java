package realize.user.reference.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import realize.user.reference.dao.referenceDao;
import realize.user.reference.entity.booksEntity;
import realize.user.register.entity.returnCodeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "/presentcertainBookServlet",value = "/presentcertainBook-servlet")
public class presentcertainBookServlet extends HttpServlet {
    private referenceDao referenceDao = new referenceDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line=reader.readLine())!=null){
            sb.append(line);
        }
        System.out.println(sb);
        booksEntity booksEntity = JSON.parseObject(String.valueOf(sb),realize.user.reference.entity.booksEntity.class);
        String bookName = booksEntity.getBookname();
        System.out.println(bookName);
        ArrayList<booksEntity> booksEntities = null;
        try {
            booksEntities = referenceDao.presentcertainBook(bookName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(booksEntities);
        String jsonString = JSON.toJSONString(booksEntities);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(jsonString);
        returnCodeEntity code = new returnCodeEntity(205,"按照书名展示书籍成功");
        String json = JSONObject.toJSONString(code);
        printWriter.println(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
