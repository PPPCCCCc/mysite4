package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServie;
	
	// 로그인폼
	@RequestMapping(value = "/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("loginForm");

		return "user/loginForm";
	}

	// 로그인
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("login");
		UserVo authUser = userServie.login(userVo);
		
		//세션저장
		if(authUser != null) {//로그인 성공
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		}else {           //로그인실패
			System.out.println("로그인 실패");
			return "redirect:/loginForm?result=fail";
		}
	}
		
		//로그아웃
		@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
		public String logout( HttpSession session) {
			session.removeAttribute("authUser");
			session.invalidate();
			
			return "redirect:/main";
		}

	// 회원가입폼
	@RequestMapping(value = "/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("joinForm");

		return "user/joinForm";
	}

	// 회원가입
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("join");
		userServie.join(userVo); 
		return "user/joinOk";
	}
	
	// 회원수정폼
		@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
		public String modifyForm(Model model, HttpSession session) {
			System.out.println("jmodifyForm");
			int no = ((UserVo)session.getAttribute("authUser")).getNo();
			
			UserVo userVo = userServie.modifyForm(no);
			
			model.addAttribute("userVo",userVo);
			
			return "user/modifyForm";
		}
		// 회원수정
		@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
		public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
			System.out.println("modify");
			int no = ((UserVo)session.getAttribute("authUser")).getNo();
			userVo.setNo(no);
			userServie.modify(userVo);
			
			((UserVo)session.getAttribute("authUser")).setName(userVo.getName());
			return "user/main";
		}
}

