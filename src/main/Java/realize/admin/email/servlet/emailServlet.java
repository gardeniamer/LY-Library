package realize.admin.email.servlet;
import com.alibaba.fastjson.JSONObject;
import realize.admin.email.service.MailUtils;
import realize.user.register.entity.returnCodeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/emailServlet",value = "/email-servlet")
public class emailServlet extends HttpServlet {
    //实现逾期发送邮件功能
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        BufferedReader br=request.getReader();
        StringBuilder builder=new StringBuilder();
        //  String params= br.readLine();
        String line=null;
        while ((line=br.readLine())!=null){
            builder.append(line);
        }
        System.out.println(builder);
        try {



            MailUtils.sendMail("2250625121@qq.com"," 您借阅的已近还书日期 , 请及时归还 !\n" +
                    "  感谢您使用凌云图书管理系统 !\n" +
                    " 自动邮件,无需回复 !","凌云图书管理系统逾期归还提醒");
            System.out.println("发送成功");
            returnCodeEntity code = new returnCodeEntity(208,"邮件发送成功!");
            String json = JSONObject.toJSONString(code);
            printWriter.println(json);
            response.getWriter().write("邮件发送成功");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
