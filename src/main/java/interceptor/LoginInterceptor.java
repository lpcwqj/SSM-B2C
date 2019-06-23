package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lin
 * @Date 2019/6/17
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if(requestURI.contains("admin")){
            if (!requestURI.contains("login")){
                String username = (String) request.getSession().getAttribute("adminname");
                if (username==null){
                    response.sendRedirect(request.getContextPath()+"/jsp/admin/login.jsp");
                    return false;
                }
            }
        }
        else if (!requestURI.contains("/user/login")){
            Object email = request.getSession().getAttribute("email");
            if (email==null){
                response.sendRedirect(request.getContextPath()+"/jsp/before/login.jsp");
                return false;
            }
            return true;
        }
        return true;
    }
}
