package realize.admin.showUsers.servlet;

import com.alibaba.fastjson.JSONObject;
import realize.admin.showUsers.dao.showUserDao;
import realize.user.register.entity.registerEntity;
import realize.user.register.entity.returnCodeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "/showUsersServlet",value = "/showUsers-servlet")
public class showUsersServlet extends HttpServlet {
    //展示所有用户
    private realize.admin.showUsers.dao.showUserDao showUserDao = new showUserDao();
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
        ArrayList<registerEntity> registerEntities = null;
        try {
            registerEntities = showUserDao.presentAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject();
        returnCodeEntity code = new returnCodeEntity(226,"展示所有用户成功");
        jsonObject.put("data", registerEntities);
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
