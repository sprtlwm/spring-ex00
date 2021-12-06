package org.zerock.controller.p01controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.p01controller.bean.Bean06;
import org.zerock.controller.p01controller.bean.Bean07;
import org.zerock.controller.p01controller.bean.Bean08;
import org.zerock.controller.p01controller.bean.Bean01;
import org.zerock.controller.p01controller.bean.Bean02;
import org.zerock.controller.p01controller.bean.Bean03;
import org.zerock.controller.p01controller.bean.Bean04;
import org.zerock.controller.p01controller.bean.Bean05;

@Controller
@RequestMapping("/cont04")
public class Controller04 {

	@RequestMapping("/met01")
	public void method01(String name, String city) {
		System.out.println(name);
		System.out.println(city);
	}
	
	@RequestMapping("/met02")
	public void method02(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		Bean01 bean = new Bean01();
		bean.setName(name);
		bean.setCity(city);
		
		System.out.println(bean);
	}
	
	@RequestMapping("/met03")
	public void method03(Bean01 bean) {
		System.out.println(bean);
	}
	
	@RequestMapping("met/04")
	public void method04(Bean02 bean) {
		
		System.out.println(bean);
	}
	
	@RequestMapping("met05")
	public void method05(Bean03 bean) {
		System.out.println(bean);
	}
	
	@RequestMapping("/met06")
	public void method06(Bean04 bean) {
		System.out.println(bean);
	}
	
	@RequestMapping("/met07")
	public void method07(@RequestParam("tel")ArrayList<String> tel) {
		System.out.println(tel);
	}
	
	@RequestMapping("/met08")
	public void method08(Bean05 bean) {
		System.out.println(bean);
	}
	
	@RequestMapping("/met09")
	public void method09(Bean06 bean) {
	System.out.println(bean);
	}
	
	@RequestMapping("/met10")
	public void method10(@RequestParam("date") 
//	@DateTimeFormat(pattern = "yyyy-mm-dd") 
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate date) {
		System.out.println(date);
	}
	
	@RequestMapping("/met11")
	public void method11(@RequestParam("dateTime") 
	@DateTimeFormat(iso = ISO.DATE_TIME)
	LocalDateTime dateTime) {
		System.out.println(dateTime);
	}
	
	@RequestMapping("/met12")
	public void method12(Bean07 bean) {
		System.out.println(bean);
	}
	
	@RequestMapping("/met13")
	public void method13(Bean08 bean) {
		System.out.println(bean);
	}
}









