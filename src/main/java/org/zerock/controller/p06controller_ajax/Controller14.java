package org.zerock.controller.p06controller_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cont14")
public class Controller14 {

		@RequestMapping("/met01")
		@ResponseBody
		public String method01(@RequestParam("name") String name ) {
			System.out.println("cont14 met01 실행");
			System.out.println(name);
			
			return "hello";
		}
		
		@RequestMapping("/met02")
		@ResponseBody
		public String method02(@RequestParam("city") String city) {
			System.out.println(city);
			
			return "korea";
		}
		
		@RequestMapping("/met03")
		@ResponseBody
		public String method03(String city, String name) {
			System.out.println(city);
			System.out.println(name);
			
			return "byebye";
		}
		
		@RequestMapping("/met04")
		@ResponseBody
		public String method04(String data1) {
			System.out.println(data1);
			
			return "hello";
		}
		
		@RequestMapping("/met05")
		@ResponseBody
		public String method05(String data1, String data2) {
				System.out.println(data1);
				System.out.println(data2);
				
				return "byebye";
		}
		
}
