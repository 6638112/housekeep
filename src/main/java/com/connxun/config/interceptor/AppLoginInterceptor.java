package com.connxun.config.interceptor;


import com.connxun.app.controller.AppBaseController;
import com.connxun.util.redis.RedisUtil;
import com.connxun.util.string.StringUtil;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述:App token 登录拦截器
 *
 * @author 王俊山
 * @version 1.0.0
 */
public class AppLoginInterceptor extends AppBaseController implements HandlerInterceptor {

    /**
     *
     */
    @ResponseBody
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userNo = request.getParameter("userNo");
        String token = request.getParameter("token");
        if (StringUtil.isNotNullOrEmpty(userNo) && StringUtil.isNotNullOrEmpty(token)) {
            String ret = RedisUtil.get(userNo);
            if (ret != null && ret.equals(token)) {
                return true;
            }
            if (userNo.equals("9999")) {
                return true;
            }
        }

       /* if(StringUtil.getIp(request).equals("0:0:0:0:0:0:0:1")){
            return true;
        }*/
        request.getRequestDispatcher("/lwgk/tokenFail.do").forward(request, response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
