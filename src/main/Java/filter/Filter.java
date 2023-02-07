package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//过滤器
@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {

    //2.doFilter()过滤方法 主要是对request和response进行一些处理，然后交给下一个过滤器或Servlet处理
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 不使用*，自动适配跨域域名，避免携带Cookie时失效
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        // 自适应所有自定义头
        String headers = request.getHeader("Access-Control-Request-Headers");
        response.setHeader("Access-Control-Allow-Headers", headers);
        response.setHeader("Access-Control-Expose-Headers", headers);
        // 允许跨域的请求方法类型
        response.setHeader("Access-Control-Allow-Methods", "*");
        // 预检命令（OPTIONS）缓存时间，单位：秒
        response.setHeader("Access-Control-Max-Age", "3600");
        // 明确许可客户端发送Cookie，不允许删除字段即可
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //参数 request, response 为web 容器或 Filter 链的上一个 Filter 传递过来的请求和相应对象；参数 chain 代表当前 Filter 链的对象。
        chain.doFilter(request, response);
        //添加一个给后台的反馈
        System.out.println("过滤器已执行");
    }


    //3.init()初始化方法  接收一个FilterConfig类型的参数 该参数是对Filter的一些配置
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

     //1.destroy() 销毁时调用
    @Override
    public void destroy() {
    }
}
