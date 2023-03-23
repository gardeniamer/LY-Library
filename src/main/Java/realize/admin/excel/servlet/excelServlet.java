package realize.admin.excel.servlet;

import com.alibaba.fastjson.JSONObject;
import realize.admin.excel.service.excel;
import realize.user.register.entity.returnCodeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/excelServlet",value = "/excel-servlet")
public class excelServlet extends HttpServlet {
    private excel excel = new excel();
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
        try {
            excel.export();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("成功执行导出excel文件");
        response.getWriter().write("成功导出数据为excel文件");
        returnCodeEntity code = new returnCodeEntity(206,"成功导出数据为excel文件");
        String json = JSONObject.toJSONString(code);
        response.setContentType("text/json;charset=UTF-8");
        printWriter.println(json);
        reader.close();
        printWriter.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
