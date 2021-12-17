package org.zerock.service.project1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.project1.MemberVO;
import org.zerock.domain.project1.PageInfoVO;
import org.zerock.mapper.project1.MemberMapper;

import lombok.Setter;

@Service
public class MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;

	public MemberVO read(String id) {
		return mapper.select(id);
	}

	public boolean register(MemberVO member) {

		try {
			return mapper.insert(member) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean modify(MemberVO member) {
		return mapper.update(member) == 1;
	}

	public boolean remove(String id) {
		return mapper.delete(id) == 1;
	}

	public List<MemberVO> getList() {
		return mapper.list();
	}

	public List<MemberVO> getList(Integer page, Integer numberPerPage) {
		Integer from = (page - 1) * numberPerPage;

		return mapper.listPage(from, numberPerPage);
	}

	public PageInfoVO getPageInfo(Integer page, Integer numberPerPage) {
		Integer countRows = mapper.getCountRows(); // 총 레코드 수
		Integer lastPage = (countRows - 1) / numberPerPage + 1; // 마지막 페이지 번호
		Integer leftPageNumber = page - 5; // 가장 왼쪽 페이지 번호
		leftPageNumber = Math.max(1, leftPageNumber);

		Integer rightPageNumber = leftPageNumber + 9; // 가장 오른쪽 페이지 번호
		rightPageNumber = Math.min(rightPageNumber, lastPage);

		Boolean hasNextButton = page != lastPage; // 다음 페이지 버튼 존재 유무
		Boolean hasPrevButton = page != 1; // 이전 페이지 버튼 존재 유무

		PageInfoVO pageInfo = new PageInfoVO();

		pageInfo.setLastPage(lastPage);
		pageInfo.setCurrentPage(page);
		pageInfo.setCountRows(countRows);
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		pageInfo.setHasNextButton(hasNextButton);
		pageInfo.setHasPrevButton(hasPrevButton);

		return pageInfo;
	}

	public boolean hasId(String id) {

		MemberVO member = mapper.select(id);

		return member != null;

	}

	public boolean hasNic(String nickName) {

		MemberVO member = mapper.select(nickName);

		return member != null;

	}
}
