package org.zerock.controller.p02controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.HttpHeadersReturnValueHandler;

@Controller
@RequestMapping("/cont05")
public class Controller05 {
	//request handler method return values
		
	@RequestMapping("/met01")
	public String method01(HttpServletRequest request) {
		//2.
		
		//3.
		
		//4.
		
		//5.
		
		return "view01";
	}
	
	@RequestMapping("/met02")
	public String method02 () {
		
		return "view02";
	}
	
	@RequestMapping("/met03")
	public String method03() {
		return "cont05/view03";
	}
	
	@RequestMapping("/met04")
	public String method04() {
		return "/cont05/view04";
	}
	
	//redirect
	
	@RequestMapping("/met05")
	public String method05() {
		
		/*servlet 사용 시*/
//		String location = request.getContextPath() + "/path";
//		response.sendRedirect(location);
		
		/*spring mvc 사용 시*/
		return "redirect:/cont05/met04";
	}
	
	@RequestMapping("/met06")
	public String method06() {
		return "redirect:/cont05/met04";
		
	}
	
	@RequestMapping("/met7")
	public String method07() {
		
		return null;
	}
	
	@RequestMapping("/met08")
	public void method08() {
		
	}
	
	@RequestMapping("/met09")
	public void method09() {
		
	}
}
