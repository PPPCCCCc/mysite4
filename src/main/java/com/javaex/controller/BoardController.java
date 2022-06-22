package com.javaex.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardservice;

	// 리스트 
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("list test");
		
		List<BoardVo> boardList = boardservice.boardList();
		model.addAttribute("boardList", boardList);

		return "board/list";
	}

	// 게시글등록폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm(HttpSession session) {
		System.out.println("writeForm");
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		return "board/writeForm";
	}

	// 글쓰기
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo, HttpSession session) {
		System.out.println("write");
		
		int no = ((UserVo) session.getAttribute("authUser")).getNo();
		boardVo.setUserNo(no);
		boardservice.boardwrite(boardVo);

		return "redirect:/board/list";
	}

	// 글 읽기 조회수
	@RequestMapping(value = "/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("read");
		
		BoardVo boardVo = boardservice.boardRead(no);
		model.addAttribute("boardVo", boardVo);
		
		return "board/read";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("delete");
		
		int count = boardservice.delete(no);

		return "redirect:/board/list";
	}
	//글수정폼
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam("no") int no, Model model) {
		System.out.println("modifyForm");
		BoardVo boardVo = boardservice.boardRead(no);
		
		model.addAttribute("boardVo",boardVo);
		return "board/modifyForm";
	}
	//글수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST }) 
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("modify");
		boardservice.boardModify(boardVo);
		
		return "redirect:/board/list";
	}
}
