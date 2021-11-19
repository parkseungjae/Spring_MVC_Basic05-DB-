package com.care.root.mybatis.board;

import java.util.List;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardMapper {
	public List<BoardDTO> selectAllBoardList();

	public int writeSave(BoardDTO dto);
	
	public BoardDTO contentView(int writeNo);
	
	public void upHit(int writeNo);
	
	public int delete(int writeNo);
	
	public int modify(BoardDTO dto);
	
	public int addReply(BoardRepDTO dto);
	
	public List<BoardRepDTO> getRepList(int write_group);
}
