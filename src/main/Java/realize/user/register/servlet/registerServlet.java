package realize.user.register.servlet;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import realize.user.register.dao.registerDao;
import realize.user.register.entity.registerEntity;
import realize.user.register.entity.returnCodeEntity;
import realize.user.register.service.registerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "/registerServlet" , value = "/registe-servlet")
public class registerServlet extends HttpServlet {

    registerService registersv;

    {
        try {
            registersv = new registerService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    registerDao registerdao = new registerDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");



        PrintWriter printWriter = response.getWriter();
        BufferedReader bufferedReader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line= bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder);

        //向前端传输数据,采用JSON格式
        registerEntity register = JSON.parseObject(String.valueOf(stringBuilder), registerEntity.class);
        //判断是否注册成功
        try {
            if(!registersv.registerTest(register.getName())){
                registerdao.userRegister(register.getName(),register.getDirection(),register.getPhoneNumber(),register.getEmail(),register.getPassword());
                returnCodeEntity code = new returnCodeEntity(201,"注册成功");
                String json = JSONObject.toJSONString(code);
                printWriter.println(json);


            }else {
                returnCodeEntity code = new returnCodeEntity(-1,"用户已存在");
                String json = JSONObject.toJSONString(code);
                printWriter.println(json);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
