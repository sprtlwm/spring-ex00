package org.zerock.controller.p03controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.p03controller.bean.Bean02;

@Controller
@RequestMapping("/cont07")
public class Controller07 {

	@RequestMapping("/met01")
	public String method01(RedirectAttributes rttr) {
		System.out.println("cont07 met01 실행");
		
		rttr.addAttribute("name", "donald");
		rttr.addAttribute("address","ny");
		
		return "redirect:/cont07/met02";
	}
	
	@RequestMapping("/met02")
	public void method02() {
		System.out.println("cont07 met02 실행");
	}
	
	@RequestMapping("/met03")
	public String method03(RedirectAttributes rdtr) {
		System.out.println("cont07 met03 실행");
		
		rdtr.addAttribute("id", 99);
		rdtr.addAttribute("city","seoul");
		rdtr.addAttribute("country","korea");
		
		return "redirect:/cont07/met04";
	}
	
	
	@RequestMapping("/met05")
	public String method05(HttpSession session) {
		session. setAttribute("name", "trump");
		
		return "redirect:/cont07/met06";
	}
	
	@RequestMapping("/met06")
	public void method06(HttpSession session) {
		System.out.println("cont07 met06 실행");
		System.out.println(session.getAttribute("name"));
	}
	
	@RequestMapping("/met07")
	public String method07(RedirectAttributes rttr) {
		rttr.addFlashAttribute("address", "USA");
	
		return"redirect:/cont07/met08";
	}
	
	@RequestMapping("/met08")
	public void method08(Model model) {
		System.out.println(model.asMap().get("address"));
	}
	
	@RequestMapping("/met09")
	public String method09(RedirectAttributes rdat) {
		
		Bean02 bean = new Bean02();
		bean.setAddress("seoul");
		bean.setCity("gangnam");
		
		rdat.addFlashAttribute("bean",bean);
		
		return "redirect:/cont07/met10";
	}
	
	@RequestMapping("/met10")
	public void method10() {
	
	}
}
























