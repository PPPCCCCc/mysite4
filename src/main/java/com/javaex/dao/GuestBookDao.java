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

	// 전체리스트 가져오기
	public List<GuestBookVo> selectList() {
		System.out.println("GuestbookDao>selectList()");

		List<GuestBookVo> guestbookList = sqlSession.selectList("guestbook.selectList");

		return guestbookList;

	}

	// 방명록 저장(ajax)
	public int insertGuest(GuestBookVo guestbookVo) {
		System.out.println("GuestbookDao>insertGuest()");

		int count = sqlSession.insert("guestbook.insertSelectKey", guestbookVo);

		return count;
	}

	// 방명록 저장후 등록한 데이타 가져오기(ajax)
	public GuestBookVo getGuest(int no) {
		System.out.println("GuestbookDao>getGuest()");

		GuestBookVo guestbookVo = sqlSession.selectOne("guestbook.getGuest", no);

		return guestbookVo;
	}
	//방명록 삭제
		public int guestDelete(GuestBookVo guestbookVo) {
			System.out.println("GuestbookDao>guestDelete()");
			
			return sqlSession.delete("guestbook.delete", guestbookVo);
		}

	/*
	 * // 리스트 public List<GuestBookVo> guestbookList() { System.out.println("gbdao.list"); List<GuestBookVo> getGuestList = sqlSession.selectList("guestbook.guestBookList");
	 * 
	 * return getGuestList; }
	 * 
	 * // 등록 public int guestbookinsert(GuestBookVo guestbookVo) { System.out.println("gbdao.insert");
	 * 
	 * int count = sqlSession.insert("guestbook.guestBookInsert", guestbookVo); return count; }
	 * 
	 * // 삭제 public int guestbookdelete(GuestBookVo guestbookVo) { System.out.println("gbdao.delete");
	 * 
	 * int count = sqlSession.delete("guestbook.guestBookDelete", guestbookVo);
	 * 
	 * return count; }
	 */
}
