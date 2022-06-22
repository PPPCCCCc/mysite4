package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트
	public List<GuestBookVo> guestbookList() {
		System.out.println("gbdao.list");
		List<GuestBookVo> getGuestList = sqlSession.selectList("guestbook.guestBookList");

		return getGuestList;
	}

	// 등록
	public int guestbookinsert(GuestBookVo guestbookVo) {
		System.out.println("gbdao.insert");

		int count =  sqlSession.insert("guestbook.guestBookInsert", guestbookVo);
		return count;
	}

	// 삭제
	public int guestbookdelete(GuestBookVo guestbookVo) {
		System.out.println("gbdao.delete");

		int count = sqlSession.delete("guestbook.guestBookDelete", guestbookVo);

		return count;
	}
}
