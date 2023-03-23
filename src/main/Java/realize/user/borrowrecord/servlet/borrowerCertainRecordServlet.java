package realize.user.borrowrecord.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import realize.user.borrowbook.entity.borrowersEntity;
import realize.user.borrowrecord.dao.borrowerRecordDao;
import realize.user.register.entity.returnCodeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "/borrowerCertainRecordServlet",value = "/borrowerCertainRecord-servlet")
public class borrowerCertainRecordServlet extends HttpServlet {
    //通过输入具体成员名字展示该成员借书内容
    private borrowerRecordDao borrowerRecordDao = new borrowerRecordDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        BufferedReader br=request.getReader();
        StringBuilder builder=new StringBuilder();
        String line=null;
        while ((line=br.readLine())!=null){
            builder.append(line);
        }
        System.out.println(builder);
        borrowersEntity bs= JSON.parseObject(String.valueOf(builder), borrowersEntity.class);
        String userName= bs.getName();
        ArrayList<borrowersEntity> borrowersEntities=null;
        try {
            borrowersEntities=borrowerRecordDao.borrowerCertainRecord(userName);
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject();
        returnCodeEntity code = new returnCodeEntity(210,"展示特定成员借阅记录成功");
        jsonObject.put("data",borrowersEntities);
        jsonObject.put("information",code);
        System.out.println(jsonObject.toJSONString());
        response.setContentType("text/json;charset=UTF-8");
        printWriter.println(jsonObject.toJSONString());


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
