package realize.user.login.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import realize.user.login.entity.loginEntity;
import realize.user.login.service.loginService;
import realize.user.register.entity.returnCodeEntity;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "/loginServlet" , value = "/login-servlet")
public class loginServlet extends HttpServlet {
    //负责登录
    //字段 student_ID password
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        BufferedReader bufferedReader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        //InputStreamReader is = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);
        String line;
        while ((line= bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder);


        loginEntity login = JSON.parseObject(String.valueOf(stringBuilder), loginEntity.class);
        System.out.println(login);

        //判断能否登陆成功
        if (login.getStudent_ID().equals("admin")&&login.getPassword().equals("admin")){
//            Cookie phoneNumber1 = new Cookie("phoneNumber", "admin");
//            Cookie password1 = new Cookie("password", "admin");
//            phoneNumber1.setMaxAge(60);
//            password1.setMaxAge(60);
//            response.addCookie(phoneNumber1);
//            response.addCookie(password1);
            returnCodeEntity code = new returnCodeEntity(202,"管理员登陆成功");
            JSONObject jsonObject = new JSONObject();
            String admin = "管理员";
            jsonObject.put("data",admin);
            jsonObject.put("information",code);
            printWriter.write(jsonObject.toJSONString());
            System.out.println(jsonObject.toJSONString());
            //request.getRequestDispatcher("MainServlet").forward(request,response);
        }else {
            try {
                loginService loginsv = new loginService();
                if (loginsv.LoginTest(login.getStudent_ID(),login.getPassword())){
//                    Cookie phoneNumber1 = new Cookie("phoneNumber", login.getPhoneNumber());
//                    Cookie password1 = new Cookie("password", login.getPassword());
//                    phoneNumber1.setMaxAge(60);
//                    password1.setMaxAge(60);
//                    response.addCookie(phoneNumber1);
//                    response.addCookie(password1);
                    returnCodeEntity code = new returnCodeEntity(203,"用户登陆成功");
                    JSONObject jsonObject = new JSONObject();
                    String name = loginsv.LoginTest1(login.getStudent_ID(),login.getPassword());
                    jsonObject.put("data",name);
                    jsonObject.put("information",code);
                    System.out.println(jsonObject.toJSONString());
                    printWriter.write(jsonObject.toJSONString());
                    //request.getRequestDispatcher("MainServlet").forward(request,response);
                    response.getWriter().write("登录成功");

                }else {
                    returnCodeEntity code = new returnCodeEntity(-2,"用户不存在或者用户名密码错误");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("data",code);
                    printWriter.write(jsonObject.toJSONString());
                    response.getWriter().write("登陆失败");
                }
//                HttpSession session = request.getSession();
//                session.setAttribute("phoneNumber",login);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }








    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
