package realize.user.borrowbook.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import realize.user.borrowbook.dao.borrowBookDao;
import realize.user.borrowbook.entity.borrowersEntity;
import realize.user.register.entity.returnCodeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "/borrowBookServlet",value = "/borrowBook-servlet")
public class borrowBookServlet extends HttpServlet {
    //实现借书的功能
    //无需向前端发送集合数据
    //字段 name book Borrow_Date Return_Date
    private borrowBookDao bw = new borrowBookDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        BufferedReader br=request.getReader();
        StringBuilder builder=new StringBuilder();
        PrintWriter printWriter = response.getWriter();
        //  String params= br.readLine();
        String line=null;
        while ((line=br.readLine())!=null){
            builder.append(line);
        }
        System.out.println(builder);
        borrowersEntity bs= JSON.parseObject(String.valueOf(builder),borrowersEntity.class);
        String userName= bs.getName();//借阅人
        String bookName= bs.getBook();//要借的书
        String date1 = bs.getBorrow_Date();//借书时间
        String date2 = bs.getReturn_Date();//还书时间
        int count;
        try {
            count=bw.borrowBook(userName,bookName,date1,date2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
        JSONObject jsonObject = new JSONObject();
        returnCodeEntity code = new returnCodeEntity(220,"申请借阅成功");
        jsonObject.put("information",code);
        response.setContentType("text/json;charset=UTF-8");
        //响应成功标识
        printWriter.write(jsonObject.toJSONString());
        System.out.println(jsonObject.toJSONString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
