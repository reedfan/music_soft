/*
package com.ustc.reed.interceptor;


import com.ustc.reed.common.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * Created by nowcoder on 2016/7/3.
 *//*

@Component
public class PassportInterceptor implements HandlerInterceptor {

//    @Autowired
//    private UserService userService;
//
//
//    @Autowired
//    private HostHolder hostHolder;
//
//    @Autowired
//    private RedisConfig redisConfig;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ticket = null;
        if (httpServletRequest.getCookies() != null) {
            for (Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals("ticket")) {
                    ticket = cookie.getValue();
                    break;
                }
            }
        }

//        if (ticket != null) {
//            LoginTicket loginTicket = userService.selectLoginTicketByticket(ticket);
//            if (loginTicket == null || loginTicket.getExpired().before(new Date()) || loginTicket.getStatus() != 0) {
//                return true;
//            }
        Integer userId = (Integer)redisConfig.get(ticket);

        if( userId!= null){

            TbUser user = userService.selectUserById(userId);
            hostHolder.setUser(user);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && hostHolder.getUser() != null) {
            modelAndView.addObject("user", hostHolder.getUser());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        hostHolder.clear();
    }
}
*/
