package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestBookService {

	@Autowired
	private GuestBookDao guestbookDao;
	
	//전체리스트 가져오기
	public List<GuestBookVo> getGuestList(){
		System.out.println("GuestBookService>getGuestList()");
		
		List<GuestBookVo> guestbookList = guestbookDao.selectList();
		
		return guestbookList;
	}
	
	
	//방명록 저장(ajax)
	public GuestBookVo addGuest(GuestBookVo guestbookVo) {
		System.out.println("GuestBookService>addGuest()");
		
		
		//저장
		System.out.println("전-->" + guestbookVo);
		int count = guestbookDao.insertGuest(guestbookVo);
		System.out.println("후-->" + guestbookVo);
		
		int no =guestbookVo.getNo();
		
		//방금저장한 1개의 데이터를 가져온다
		GuestBookVo gVo = guestbookDao.getGuest(no);
		
		return gVo;
	}
	//방명록 삭제
		public String removeGuest(GuestBookVo guestbookVo) {
			System.out.println("GuestBookService>removeGuest()");
			
			String state;
			
			int count = guestbookDao.guestDelete(guestbookVo);
			
			if(count>0) {
				state = "succeess";
			}else {
				state = "fail";
			}
			
			return state;
		}
	/*
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
	*/
}