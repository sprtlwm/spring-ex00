package org.zerock.mapper.project1;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.project1.MemberVO;

public interface MemberMapper {

	public int insert(MemberVO member);
	
	public MemberVO select(String id);
	
	public int update(MemberVO member);
	
	public int delete(String id);
	
	public List<MemberVO> list(); //

	public List<MemberVO> listPage(@Param("from") Integer from, @Param("items") Integer numberPerPage); // page 처리

	public Integer getCountRows();
	
}

