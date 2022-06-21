package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	// 회원가입
	public int join(UserVo userVo) {

		int count = userDao.userInsert(userVo);

		return count;
	}

	// 로그인
	public UserVo login(UserVo userVo) {
		System.out.println("userSV. login");
		UserVo authUser = userDao.userLogin(userVo);

		return authUser;
	}

	// 회원수정

	public UserVo modifyForm(int no) {
		System.out.println("userSV.modifyForm");
		UserVo userVo = userDao.userInfo(no);

		return userVo;
	}
	
	//회원수정
	public int modify(UserVo userVo) {
		System.out.println("userSV.modify");
		
		int count = userDao.update(userVo);
		
		return count;
	}
}
