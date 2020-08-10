/*package com.wipro.digital.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor{
	@Override
	   public boolean preHandle (
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	      log.debug("Request Packet is :"+IOUtils.toString(request.getReader()));
	      return true;
	   }
	   @Override
	   public void postHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception {
		  // log.debug("Response Packet is :"+response.getWriter().toString());
		   
	   }
	   
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, Exception exception) throws Exception {
		   //log.debug("Response Packet afterCompletion is :"+response.getWriter().toString());
	   }
}*/
