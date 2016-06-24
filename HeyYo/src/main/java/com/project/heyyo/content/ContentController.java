package com.project.heyyo.content;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.heyyo.content.model.Content;
import com.project.heyyo.content.model.ContentDao;

@Controller
public class ContentController {

	@Autowired
	@Qualifier("myContentDao")
	private ContentDao contentDao;

	@RequestMapping(value = "infowindow.con")
	public String viewInfoWindow() {
		System.out.println("ContentController doActionInfo ����");
		return "InfoWindow";
	}

	@RequestMapping(value = "write.con", method = RequestMethod.GET)
	public String viewWriteForm() {
		return "ContentWriteForm";
	}

	@RequestMapping(value = "write.con", method = RequestMethod.POST)
	public String doActionWrite(
			@ModelAttribute("Content") @Valid Content content,
			BindingResult bindingResult) {
		
		contentDao.insertNeedData(content);
		
		
		return "redirect:need.do";
	}

	@RequestMapping(value = "detail.con")
	public ModelAndView viewDetail(@RequestParam(value = "id") int id) {
		ModelAndView mav = new ModelAndView();
		System.out.println("id : " + id);
		Content content;
		content = contentDao.getContentById(id);
		mav.addObject("content", content);
		mav.setViewName("ContentDetailView");
		return mav;
	}
}
