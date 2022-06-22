package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	// 리스트
	public List<BoardVo> boardList() {
		System.out.println("bSV.boardList");
		List<BoardVo> boardList = boardDao.boardList();

		return boardList;
	}
	//글쓰기
	public int boardwrite(BoardVo boardVo) {
		System.out.println("bSV.boardInsert");
		
		int count = boardDao.boardwrite(boardVo);
		
		return count;
	}
	//게시물 읽기
	public BoardVo boardRead(int no ) {
		System.out.println("bSV.boardread");
		BoardVo boardVo = boardDao.boardRead(no);
		int count = boardDao.boardHit(no);
		
		
		return boardVo;
	}
	//삭제
	public int delete(int no) {
		System.out.println("bSV.delete");
		int count = boardDao. boardDelete(no);
		
		return count;
	}
	//수정
	public  int boardModify(BoardVo boardVo) {
		System.out.println("bSV.delete");
		int count = boardDao.boardModify(boardVo);
		
		return count;
		
	}
	

}
