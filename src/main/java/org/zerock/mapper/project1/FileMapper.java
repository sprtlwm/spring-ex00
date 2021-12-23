package org.zerock.mapper.project1;

import org.apache.ibatis.annotations.Param;

public interface FileMapper {

	int insert(@Param("boardId") Integer boardId, @Param("fileName") String fileName);

	String[] selectNamesByBoardId(Integer boardId);

	void delete(@Param("boardId") Integer boardId, @Param("fileName") String fileName);

	void deleteByBoardId(@Param("boardId") Integer boardId);

}
