package org.zerock.mapper.p05mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Mapper02 {
	
	public String getLastNameById(Integer id);

	public String getCustomerNameById(Integer id);

	public List<String> getPrductNamesByCategory(String category);

	List<String> getProductNamesByCategoryAndPrice(@Param("category") String category, @Param("price") Double price);

	public List<String> getSupplierNamesByCityAndCountry(@Param("city")String city, @Param("country") String country);

	
}









