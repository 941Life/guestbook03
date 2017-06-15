package com.jx372.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jx372.guestbook.dao.GuestbookDao;
import com.jx372.guestbook.vo.GuestbookVO;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<GuestbookVO> list = guestbookDao.getList();
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(
			@PathVariable ("no")
			int no,Model model){
			model.addAttribute("no",no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping("delete")
	public String delete(
			@ModelAttribute GuestbookVO vo){
		guestbookDao.delete(vo);
		return "/WEB-INF/views/index.jsp";
		
	}
	
}
