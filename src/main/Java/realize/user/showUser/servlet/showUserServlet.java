package realize.user.showUser.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import realize.user.register.entity.registerEntity;
import realize.user.register.entity.returnCodeEntity;
import realize.user.showUser.dao.showUserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "/showUserServlet",value = "/showUser-servlet")
public class showUserServlet extends HttpServlet {
    //用户查看自己的信息(用户端)
    //字段:
    private showUserDao showUserDao = new showUserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        BufferedReader br=request.getReader();
        PrintWriter printWriter = response.getWriter();
        // String params= br.readLine();
        StringBuilder builder=new StringBuilder();
        String line=null;
        while ((line=br.readLine())!=null){
            builder.append(line);
        }
        System.out.println(builder);
        registerEntity userInformation= JSON.parseObject(String.valueOf(builder), registerEntity.class);
        String userName= userInformation.getName();
        System.out.println(userName);
        ArrayList<registerEntity> userInformationArrayList=null;
        try {
            userInformationArrayList=showUserDao.showUser(userName);
        }  catch (Exception e) {
            System.out.println(e);
        }
        JSONObject jsonObject = new JSONObject();
        returnCodeEntity code = new returnCodeEntity(222,"展示用户信息成功");
        jsonObject.put("data", userInformationArrayList);
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
