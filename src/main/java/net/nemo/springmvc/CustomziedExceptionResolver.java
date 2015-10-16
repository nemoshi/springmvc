package net.nemo.springmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tonyshi on 15/10/16.
 */
public class CustomziedExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ResponseBody body = ((HandlerMethod)handler).getMethodAnnotation(ResponseBody.class);
        if(body == null) {
            return super.doResolveException(request, response, handler, ex);
        }
        else{
            ModelAndView mv = new ModelAndView();

            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control","no-cache, must-revalidate");
            try {
                response.getWriter().write("{\"error_message\":\"" + ex.getMessage() + "\"}");
            }catch(IOException e){
                e.printStackTrace();
            }

            return mv;
        }
    }
}
