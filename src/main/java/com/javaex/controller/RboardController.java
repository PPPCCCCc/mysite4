package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVo;
import com.javaex.vo.UserVo;

@Controller
public class RboardController {

	@Autowired
	private RboardService rBoardService;

	@RequestMapping(value = "/rboard/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("rboard list test");

		model.addAttribute("rBoardList", rBoardService.list());
		return "rboard/list";
	}

	// 게시글등록폼
	@RequestMapping(value = "/rboard/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm(HttpSession session) {
		System.out.println("writeForm");
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		return "rboard/writeForm";
	}

	// 글쓰기
	@RequestMapping(value = "/rboard/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute RboardVo rBoardVo, HttpSession session) {
		System.out.println("write");

		int no = ((UserVo) session.getAttribute("authUser")).getNo();
		rBoardVo.setUserNo(no);
		rBoardService.write(rBoardVo);

		return "redirect:/rboard/list";
	}

	// 글 읽기 조회수
	@RequestMapping(value = "/rboard/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("read");

		RboardVo rBoardVo = rBoardService.read(no);
		model.addAttribute("rBoardVo", rBoardVo);

		return "rboard/read";
	}

	// 삭제
	@RequestMapping(value = "/rboard/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("delete");

		int count = rBoardService.delete(no);

		return "redirect:/rboard/list";
	}

	// 글수정폼
	@RequestMapping(value = "/rboard/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam("no") int no, Model model) {
		System.out.println("modifyForm");
		RboardVo rBoardVo = rBoardService.modifyForm(no);

		model.addAttribute("rBoardVo", rBoardVo);
		return "rboard/modifyForm";
	}

	// 글수정
	@RequestMapping(value = "/rboard/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute RboardVo rBoardVo) {
		System.out.println("modify");
		
		rBoardService.modify(rBoardVo);

		return "redirect:/rboard/list";
	}

	// 댓글폼
	@RequestMapping(value = "/rboard/commentForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeReplyForm(@ModelAttribute RboardVo rBoardVo, Model model) {
		System.out.println("coometform");

		model.addAttribute("rBoardVo", rBoardVo);
		
		return "rboard/commentForm";
	}

	// 댓글쓰기
	@RequestMapping(value = "/rboard/comment", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeReply(@ModelAttribute RboardVo rBoardVo) {
		System.out.println("comment");

		rBoardService.comment(rBoardVo);
		return "redirect:/rboard/list";
	}

}
