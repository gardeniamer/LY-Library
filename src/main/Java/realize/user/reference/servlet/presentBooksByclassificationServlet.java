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

@WebServlet(name = "/presentBooksByclassificationServlet",value = "/presentBooksByclassification-servlet")
//实现通过指定类别查看书籍
//字段:classification
public class presentBooksByclassificationServlet extends HttpServlet {
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
        String classification = booksEntity.getClassification();
        System.out.println(classification);
        ArrayList<booksEntity> booksEntities = null;
        try {
            booksEntities = referenceDao.presentBooksByclassification(classification);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject();
        returnCodeEntity code = new returnCodeEntity(204,"按照类别展示书籍成功");
        jsonObject.put("data", booksEntities);
        jsonObject.put("information", code);
        System.out.println(jsonObject.toJSONString());
        response.setContentType("text/json;charset=UTF-8");
        printWriter.write(jsonObject.toJSONString());




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
