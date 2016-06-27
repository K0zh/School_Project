package com.project.heyyo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.heyyo.content.model.Content;
import com.project.heyyo.content.model.ContentDao;

@Controller
public class MainController {
	
	
	@Autowired
	@Qualifier("myContentDao")
	private ContentDao contentDao;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "home.do")
	public String home2() {
		return "index";
	}
	
	@RequestMapping(value="need.do")
	public ModelAndView doActionGet() {
		ModelAndView mav = new ModelAndView();
		
		List<Content> contentLists = contentDao.getAllContent();
		
		mav.addObject( "contentLists", contentLists );
		mav.setViewName("Main");
		
		return mav;
	}
	
	@RequestMapping(value="test.do")
	public String Test() {
		return "test";
	}
}
