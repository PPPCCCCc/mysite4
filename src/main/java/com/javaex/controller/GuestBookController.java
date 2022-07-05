/*
 * package com.javaex.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.ModelAttribute; import org.springframework.web.bind.annotation.RequestMapping; import org.springframework.web.bind.annotation.RequestMethod; import org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.javaex.service.GuestBookService; import com.javaex.vo.GuestBookVo;
 * 
 * @Controller
 * 
 * @RequestMapping(value = "/guestbook") public class GuestBookController {
 * 
 * @Autowired private GuestBookService guestbookservice;
 * 
 * // 리스트
 * 
 * @RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST }) public String addList(Model model) { System.out.println("addList"); List<GuestBookVo> guestList = guestbookservice.getList();
 * 
 * model.addAttribute("guestList", guestList);
 * 
 * return "guestbook/addList"; }
 * 
 * // 등록
 * 
 * @RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST }) public String add(@ModelAttribute GuestBookVo guestbookVo) { System.out.println("write"); guestbookservice.insert(guestbookVo);
 * 
 * return "redirect:/guestbook/addList"; }
 * 
 * // 삭제폼
 * 
 * @RequestMapping(value = "/deleteform", method = { RequestMethod.GET, RequestMethod.POST }) public String deleteForm(@RequestParam("no") int no) { System.out.println(" deleteForm");
 * 
 * return "guestbook/deleteForm"; }
 * 
 * // 삭제
 * 
 * @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST }) public String delete(@ModelAttribute GuestBookVo guestbookVo) { System.out.println("delete"); guestbookservice.delete(guestbookVo);
 * 
 * return "redirect:/guestbook/addList"; }
 * 
 * }
 */