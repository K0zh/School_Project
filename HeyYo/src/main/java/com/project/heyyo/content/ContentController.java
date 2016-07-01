package com.project.heyyo.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
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
	public String viewWriteForm(HttpSession session) {
		if(session.getAttribute("id") == "" || session.getAttribute("id") == null) {
			System.out.println("�α����� �ʿ��� ���� �Դϴ�.");
			return "redirect:main.do";
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
		String[] location_result = location.replace("(", "").replace(")", "").split(",");
		content.setLat(location_result[0]);
		content.setLng(location_result[1]);
		
		System.out.println("����" + content.getLat());
		System.out.println("�浵" + content.getLng());
		

		// ������ ��ǥ �缳��
		System.out.println("id: " + content.getId());
		System.out.println("SDAY" + content.getS_day());
		contentDao.insertTalentData(content);

		return "redirect:main.do";
	}

	// ��û ���� �󼼺���
	@RequestMapping(value = "detail.con")
	public ModelAndView viewDetail(@RequestParam(value = "num") int num,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Content content = contentDao.getContentByNum(num);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("num", num);
		List<Matching> lists = matchingDao.selectMatchingByNum(map);

		mav.addObject("content", content);
		mav.addObject("matchingList", lists);

		mav.setViewName("ContentDetailView");

		return mav;
	}

	@RequestMapping(value = "matching.con")
	public String doActionMatching(
			@ModelAttribute("Matching") @Valid Matching matching,
			BindingResult bindingResult) {

		int num = matching.getM_num();
		matchingDao.insertRequestMatching(matching);

		return "redirect:detail.con?num=" + num;

	}

	// ��û �����ϱ�
	@RequestMapping(value = "deny.con")
	public String doActionDeny(@RequestParam(value = "id") int id,
			@RequestParam(value = "num") int num) {
		matchingDao.deleteRequest(id);
		return "redirect:detail.con?num=" + num;
	}

	
	// ��û �����ϱ�
	@RequestMapping(value = "agree.con", method = RequestMethod.POST)
	public ModelAndView doActionAgree(
			@RequestParam(value = "id_able") int id_able,
			@RequestParam(value = "id_need") int id_need) {
		System.out.println(id_able);
		System.out.println(id_need);

		ModelAndView mav = new ModelAndView();

		Member responseMember = memberDao.selectMemberById(id_able);
		Member requestMember = memberDao.selectMemberById(id_need);
		
		mav.addObject("responseMember", responseMember);
		mav.addObject("requestMember", requestMember);
		mav.setViewName("matching/MatchingDetail");

		return mav;
	}
}
