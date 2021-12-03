package org.zerock.controller.p01controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cont03")
public class Controller03 {

	@RequestMapping("/met01")
	public void method01(HttpServletRequest request) {
		System.out.println("메소드01");
		
		//2.request 분석/가공
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr);
		
		//3.
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("/met02")
	public void method02(String name, int age) {
		System.out.println("메소드02");
		System.out.println(name);
		System.out.println(age);
	}
	
//	@RequestMapping("/met03")
//	public void method03(HttpServletRequest request) {
//		
//		String address = request.getParameter("address");
//		String idStr = request.getParameter("id");
//		int id = Integer.parseInt(idStr);
//		
//		System.out.println(address);
//		System.out.println(id);
//		
//	}
	
	@RequestMapping("/met03")
	public void method03(String address, Integer id) {
		
		System.out.println(address);
		System.out.println(id);
	
	}
	
	@RequestMapping("/met04")
	public void method04(@RequestParam("name") String contactName) {
		System.out.println(contactName);
		
	}
	
	@RequestMapping("/met05")
	public void method05(@RequestParam("country")String c,@RequestParam("height") Integer h) {
		System.out.println(c);
		System.out.println(h);
	}
	
	
	
	
	
	
	
}