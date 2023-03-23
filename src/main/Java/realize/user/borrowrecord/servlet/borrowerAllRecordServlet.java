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

@WebServlet(name = "/borrowerAllRecordServlet",value = "/borrowerAllRecord-servlet")
public class borrowerAllRecordServlet extends HttpServlet {
    //展示所有用户借书记录(借阅和归还)

    private realize.user.borrowrecord.dao.borrowerRecordDao borrowerRecordDao = new borrowerRecordDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        BufferedReader br=request.getReader();
        StringBuilder builder=new StringBuilder();
        PrintWriter printWriter = response.getWriter();
        String line=null;
        while ((line=br.readLine())!=null){
            builder.append(line);
        }
        System.out.println(builder);
        borrowersEntity bs= JSON.parseObject(String.valueOf(builder), borrowersEntity.class);
        ArrayList<borrowersEntity> borrowersEntities=null;
        try {
            borrowersEntities=borrowerRecordDao.borrowerAllRecord();
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject();
        returnCodeEntity code = new returnCodeEntity(209,"展示所有成员借阅记录成功");
        jsonObject.put("data", borrowersEntities);
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
