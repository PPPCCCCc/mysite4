package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RboardDao;
import com.javaex.vo.RboardVo;

@Service
public class RboardService {

	@Autowired
	private RboardDao rBoardDao;

	public List<RboardVo> list() {
		System.out.println("service list");
		
		List<RboardVo> rbList = rBoardDao.rBoardList();

		return rbList;
	}

	// 글쓰기
	public int write(RboardVo rBoardVo) {
		System.out.println("rbSV.boardInsert");

		int count = rBoardDao.rboardwrite(rBoardVo);

		return count;
	}

	// 게시물 읽기
	public RboardVo read(int no) {
		System.out.println("rbSV.boardread");
		
		RboardVo rBoardVo = rBoardDao.rboardRead(no);
		int count = rBoardDao.rboardHit(no);

		return rBoardVo;
	}

	// 삭제
	public int delete(int no) {
		System.out.println("rbSV.delete");
		
		int count = rBoardDao.rboardDelete(no);

		return count;
	}

	// 수정
	public int modify(RboardVo rBoardVo) {
		System.out.println("rbSV.modify");
		
		int count = rBoardDao.rboardModify(rBoardVo);

		return count;

	}

	// 수정폼
	public RboardVo modifyForm(int no) {
		System.out.println("rbSV.modifyform");

		return rBoardDao.rboardModifyFrom(no);

	}

	public RboardVo commentForm(int no) {
		System.out.println("rbSV.commentform");

		return rBoardDao.rboardcommentFrom(no);

	}

	public int comment(RboardVo rBoardVo) {
		System.out.println("bSV.comment");

		int count = rBoardDao.rboardcomment(rBoardVo);

		return count;
	}
	public int update(RboardVo rBoardVo) {
		System.out.println("rbSV.modify");
		
		int count = rBoardDao.updateOrderNo(rBoardVo);

		return count;

	}
}
