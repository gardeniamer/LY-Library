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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        /*PrintWriter out = response.getWriter();
        InputStreamReader is = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        int read = is.read();
        while (read!=-1){
            sb.append((char)read);
            read = is.read();
        }
        //Json转化
        Object json = JSON.parse(sb.toString());
        loginEntity loginEntity = JSON.parseObject(String.valueOf(json),loginEntity.class);
        System.out.println(loginEntity);
        String phoneNumber = String.valueOf(loginEntity.getPhoneNumber());
        String email = String.valueOf(loginEntity.getEmail());
        String password = String.valueOf(loginEntity.getPassword());
        loginService ls = new loginService();
        try {
            if (phoneNumber.equals("admin")&&password.equals("admin")){
                HttpSession session = request.getSession();
                session.setAttribute("user",loginEntity);
                //设置响应
                response.getWriter().write("管理员登陆成功");
            }
            else if (ls.LoginTest(phoneNumber,email,password)){
                HttpSession session = request.getSession();
                session.setAttribute("user",loginEntity);
                //设置响应
                response.getWriter().write("用户登陆成功");
            }else {
                response.getWriter().write("登录失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/


        //数据读取
        PrintWriter printWriter = response.getWriter();
        BufferedReader bufferedReader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line= bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder);
        loginEntity login = JSON.parseObject(String.valueOf(stringBuilder), loginEntity.class);
        System.out.println(login);

        //判断能否登陆成功
        if (login.getPhoneNumber().equals("admin")&&login.getPassword().equals("admin")){
            returnCodeEntity code = new returnCodeEntity(202,"管理员登陆成功");
            String json = JSONObject.toJSONString(code);
            printWriter.println(json);
        }else {
            try {
                loginService loginsv = new loginService();
                if (loginsv.LoginTest(login.getPhoneNumber(),login.getEmail(),login.getPassword())){
                    returnCodeEntity code = new returnCodeEntity(203,"用户登陆成功");
                    String json = JSONObject.toJSONString(code);
                    printWriter.println(json);

                }else {
                    returnCodeEntity code = new returnCodeEntity(-2,"用户不存在或者用户名密码错误");
                    String json = JSONObject.toJSONString(code);
                    printWriter.println(json);
                }
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
