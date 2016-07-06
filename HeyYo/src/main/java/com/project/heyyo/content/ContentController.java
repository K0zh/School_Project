package com.project.heyyo.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.heyyo.content.matching.Matching;
import com.project.heyyo.content.matching.MatchingDao;
import com.project.heyyo.content.model.Content;
import com.project.heyyo.content.model.ContentDao;
import com.project.heyyo.member.model.Member;
import com.project.heyyo.member.model.MemberDao;

@Controller
public class ContentController {

	@Autowired
	@Qualifier("myMemberDao")
	private MemberDao memberDao;

	@Autowired
	@Qualifier("myContentDao")
	private ContentDao contentDao;

	@Autowired
	@Qualifier("myMatchingDao")
	private MatchingDao matchingDao;

	@RequestMapping(value = "infowindow.con")
	public String viewInfoWindow() {
		return "InfoWindow";
	}

	// ��û�ϱ� �� �̵�
	@RequestMapping(value = "write.con", method = RequestMethod.GET)
	public String viewWriteForm(HttpSession session, ModelMap model) {
		
		if (session.getAttribute("loginfo") == "" || session.getAttribute("loginfo") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "main.do");
			return "redirect";
		}

		return "ContentWriteForm";
	}

	// ��û�ϱ� ������ ���
	@RequestMapping(value = "write.con", method = RequestMethod.POST)
	public String doActionWrite(
			@ModelAttribute("Content") @Valid Content content,
			BindingResult bindingResult) {
		
		// ���� ��ǥ ����
		String location = content.getLocation();
		String[] location_result = location.replace("(", "").replace(")", "")
				.split(",");
		content.setLat(location_result[0]);
		content.setLng(location_result[1]);
		
		// ������ ��ǥ �缳��
		contentDao.insertTalentData(content);

		return "redirect:main.do";
	}

	// ��û ���� �󼼺���
	@RequestMapping(value = "detail.con")
	public ModelAndView viewDetail(@RequestParam(value = "num") int num,
			@RequestParam(value = "id") int id,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Content content = contentDao.getContentByNum(num);
		Member member = memberDao.selectMemberById(id);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("num", num);
		List<Matching> lists = matchingDao.selectMatchingByNum(map);
		mav.addObject("content", content);
		mav.addObject("member", member);
		mav.addObject("matchingList", lists);

		mav.setViewName("ContentDetailView");

		return mav;
	}

	@RequestMapping(value = "matching.con")
	public String doActionMatching(
			@ModelAttribute("Matching") @Valid Matching matching,
			BindingResult bindingResult) {

		int num = matching.getM_num();
		int id = matching.getM_id();
		matchingDao.insertRequestMatching(matching);

		return "redirect:detail.con?num=" + num + "&id="+id;

	}

	// ��û �����ϱ�
	@RequestMapping(value = "deny.con")
	public String doActionDeny(@RequestParam(value = "m_id") int m_id,
			@RequestParam(value = "id") int id,
			@RequestParam(value = "num") int num) {
		System.out.println("deny 들어옴");
		matchingDao.deleteRequest(m_id);
		return "redirect:detail.con?num="+num+"&id="+id;
	}

	// ��û �����ϱ�
	@RequestMapping(value = "agree.con", method = RequestMethod.POST)
	public ModelAndView doActionAgree(
			@RequestParam(value = "id_able") int id_able,
			@RequestParam(value = "id_need") int id_need) {

		ModelAndView mav = new ModelAndView();

		Member responseMember = memberDao.selectMemberById(id_able);
		Member requestMember = memberDao.selectMemberById(id_need);

		mav.addObject("responseMember", responseMember);
		mav.addObject("requestMember", requestMember);
		mav.setViewName("matching/MatchingDetail");

		return mav;
	}
}
