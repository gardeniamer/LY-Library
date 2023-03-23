package realize.user.returnbook.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import realize.user.borrowbook.entity.borrowersEntity;
import realize.user.register.entity.returnCodeEntity;
import realize.user.returnbook.dao.returnBookDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/returnBookServlet",value = "/returnBook-servlet")
public class returnBookServlet extends HttpServlet {
    //实现还书功能
    //字段名:userName bookName
    private returnBookDao rb = new returnBookDao();
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
        String userName= bs.getName();
        String bookName= bs.getBook();
        String ActualReturn_Date = bs.getActualReturn_Date();
        int count;
        try {
            count=rb.returnBook(userName,bookName,ActualReturn_Date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
        response.setContentType("text/json;charset=UTF-8");
        JSONObject jsonObject = new JSONObject();
        //响应成功标识
        if (count==0){
            returnCodeEntity code2 = new returnCodeEntity(-4,"申请归还失败");
            jsonObject.put("information2",code2);
            System.out.println(jsonObject.toJSONString());
            printWriter.write(jsonObject.toJSONString());
        }else{
            returnCodeEntity code1 = new returnCodeEntity(221,"申请归还成功");
            jsonObject.put("information1",code1);
            System.out.println(jsonObject.toJSONString());
            printWriter.write(jsonObject.toJSONString());

        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
