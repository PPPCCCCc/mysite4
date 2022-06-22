package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestBookService {

	@Autowired
	private GuestBookDao guestDao;

	// 리스트
	public List<GuestBookVo> list() {
		System.out.println("gbsv.list");
		List<GuestBookVo> guestList = guestDao.guestbookList();

		return guestList;
	}
	
	// 등록
	public int insert(GuestBookVo guestbookVo) {
		System.out.println("gbsv.insert");
		int count = guestDao.guestbookinsert(guestbookVo);

		return count;
	}
	
	// 삭제
	public int delete(GuestBookVo guestbookVo) {
		System.out.println("gbsv.delete");
		int count = guestDao.guestbookdelete(guestbookVo);

		return count;
	}
}