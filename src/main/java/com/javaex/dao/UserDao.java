package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int userInsert(UserVo userVo) {
		System.out.println("userdao > insertt");
		int count = sqlSession.insert("user.insert", userVo);
		return count;
	}
	//로그인
		public UserVo userLogin(UserVo userVo) {
			System.out.println("login");
			
			UserVo authUser = sqlSession.selectOne("user.login" ,userVo);
			return authUser;
		}
		
		//회원수정
		public UserVo userInfo(int no) {
			System.out.println("dao> update");
			
			UserVo userVo = sqlSession.selectOne("user.userInfo", no);
			
			return userVo;
		}
		
		//회원수정
		public int update(UserVo userVo) {
			int count = sqlSession.update("user.update",userVo);
			
			return count;
		}
}
