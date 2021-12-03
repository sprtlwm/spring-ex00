package org.zerock.controller.p01controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cont1")
public class Controller01 {
	
	//"cont1"
	@RequestMapping("")
	public void method00() {
		System.out.println("메소드00 실행");
	}
	
	//"cont1/met01"
	@RequestMapping("/met01")
	public void method01() {
		System.out.println("메소드01 일함");
	}
		
	//"cont1/met02"	
	@RequestMapping("/met02")
	public void method02() {
		System.out.println("메소드2 일함");
	}
	
	//"cont1/met03", "cont1/met04" 로 요청이 왔을때
	@RequestMapping({"/met03","/met04"})
	public void method03() {
		System.out.println("메소드03 일함");
	}
	
	//"cont1/met05","cont1/met06" 으로 요청시 일하는 메소드 method05 작성
	@RequestMapping({"/met05","/met06"})
	public void method05() {
		System.out.println("메소드05 일함");
	}
}
