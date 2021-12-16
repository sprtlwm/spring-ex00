package org.zerock.domain.project1;

import lombok.Data;

@Data
public class PageInfoVO {

	private Integer lastPage; // 마지막 페이지 번호
	private Integer countRows; // 총 레코드 수
	private Integer currentPage; // 현재 페이지 번호
	private Integer leftPageNumber; // 페이지네이션 가장 왼쪽 번호
	private Integer rightPageNumber; // 페이지네이션 가장 오른쪽 번호

}
