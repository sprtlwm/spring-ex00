package org.zerock.controller.p05controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.p05controller.bean.Bean17;
import org.zerock.controller.p05controller.bean.Bean18;
import org.zerock.mapper.p05mapper.Mapper03;

import lombok.Setter;

@Controller
@RequestMapping("/cont12")
public class Controller12 {
	
	@Setter(onMethod_=@Autowired)
	private Mapper03 mapper;
	
	@RequestMapping("/met01")
	public void method01() {
		String customerName = "ironman";
		String contactName = "tony";
		
		int cnt = mapper.insertCustomer(customerName, contactName);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met02")
	public void method02() {
		String supplierName = "captain";
		String contactName = "steve";
		
		int cnt = mapper.insertSupplier(supplierName, contactName);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met03")
	public void method03() {
		// 2. request 분석/가공
		Bean17 bean = new Bean17();
		bean.setContactName("peter");
		bean.setCustomerName("spiderman");
		bean.setAddress("queens");
		bean.setCity("ny");
		bean.setPostalCode("2222");
		bean.setCountry("usa");
		
		// 3. business logic
		mapper.insertCustomer2(bean);
	}
	
	@RequestMapping("/met04")
	public void method04() {
		
		Bean18 bean = new Bean18();
		bean.setSupplierName("babi");
		bean.setContactName("LOL");
		bean.setAddress("denmark");
		bean.setCity("den");
		bean.setPostalCode("123777");
		bean.setCountry("E.U");
		bean.setPhone("076)2330-3123");
		
		mapper.insertSupplier2(bean);
	}
	
	@RequestMapping("/met05")
	public void method05() {
		
		Bean17 bean = new Bean17();
		bean.setContactName("LOL");
		bean.setCustomerName("duduodnuojag");
		bean.setAddress("ogn");
		bean.setCity("seoul");
		bean.setPostalCode("99975");
		bean.setCountry("korea");
		
		// 3. business logic
		System.out.println(bean.getId());
		
		mapper.insertCustomer3(bean);
		
		System.out.println(bean.getId());
	}
	
	@RequestMapping("/met06")
	public void method06() {
		
		Bean18 bean = new Bean18();
		bean.setSupplierName("babi");
		bean.setContactName("LOL");
		bean.setAddress("gato");
		bean.setCity("ny");
		bean.setPostalCode("123777");
		bean.setCountry("USA");
		bean.setPhone("089)1045-3123");
		
		System.out.println(bean.getId());
		
		mapper.insertSupplier3(bean);
		
		System.out.println(bean.getId());
	}
	
	@RequestMapping("/met07")
	public void method07() {
		
		Bean17 bean = new Bean17();
		bean.setId(102);
		bean.setContactName("LOL");
		bean.setCustomerName("champ");
		bean.setAddress("ogn");
		bean.setCity("seoul");
		bean.setPostalCode("99975");
		bean.setCountry("korea");
		
		int cnt = mapper.updateCustomer(bean);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met08")
	public void method08() {
		
		Bean18 bean = new Bean18();
		bean.setId(31);
		bean.setSupplierName("babi");
		bean.setContactName("LOL");
		bean.setAddress("ging");
		bean.setCity("ny");
		bean.setPostalCode("777777");
		bean.setCountry("JaUn");
		bean.setPhone("089)1045-3123");
		
		int cnt = mapper.updateSupplier(bean);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met09")
	public void method09(Integer id) {
		
		int cnt = mapper.deleteCustomer(id);
		
	}
	
	@RequestMapping("/met10")
	public void method10(Integer id) {
		
		int cnt = mapper.deleteSupplier(id);
	}
	
	
	
	
	
	
	
	
	
	
	
}






















