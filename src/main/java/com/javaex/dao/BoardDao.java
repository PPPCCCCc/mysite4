package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<BoardVo> boardList() {
		System.out.println("boardDao.list");
		List<BoardVo> count = sqlSession.selectList("board.boardList");
		
		return count;
	}

	// 글쓰기
	public int boardwrite(BoardVo boardVo) {
		System.out.println("boardDao.Insert");
		int count = sqlSession.insert("board.boardwrite", boardVo);

		return count;
	}
	
	//게시물읽기
	public BoardVo  boardRead(int no) {
		System.out.println("boardDao.read");
		BoardVo boardVo = sqlSession.selectOne("board.boardRead", no);
		
		return boardVo;
	}
	
	//조회수
	public int boardHit(int no) {
		//System.out.println("boardDao.Hit");
		int count = sqlSession.update("board.boardHit", no);
		
		return count;
	}

	// 삭제
	public int boardDelete(int no) {
		System.out.println("boardDao.delete");
		int count = sqlSession.delete("board.boardDelete", no);
		
		return count;
	}
	
	//수정
	public int boardModify(BoardVo boardVo) {
		System.out.println("boardDao.modify");
		int count = sqlSession.update("board.boardModify", boardVo);
		
		return count;
	}
}
