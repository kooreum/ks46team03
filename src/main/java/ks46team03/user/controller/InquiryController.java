package ks46team03.user.controller;


import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Inquiry;
import ks46team03.dto.Member;
import ks46team03.user.mapper.UserInquiryMapper;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.service.UserInquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class InquiryController {

	private final UserInquiryService userInquiryService;
	private final UserMemberMapper userMemberMapper;
	private final UserInquiryMapper userInquiryMapper;

	private static final Logger log = LoggerFactory.getLogger(InquiryController.class);

	public InquiryController(UserInquiryService userInquiryService, UserMemberMapper userMemberMapper, UserInquiryMapper userInquiryMapper){
		this.userInquiryService = userInquiryService;
		this.userMemberMapper = userMemberMapper;
		this.userInquiryMapper = userInquiryMapper;
	}
	@GetMapping("/inquiryContent")
	public String inquiryContent(@RequestParam("inquiryBoardCode") String inquiryBoardCode, Model model, HttpSession session) {
		Inquiry inquiry = userInquiryService.getInquiryInfoByCode(inquiryBoardCode);
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("title","문의글 내용");

		// 세션에서 로그인한 사용자 ID를 가져옴
		String userId = (String) session.getAttribute("SID");

		// 글쓴이와 로그인한 사용자 ID가 같을 경우, 수정 및 삭제 버튼을 보이도록 설정
		if (inquiry.getMemberId().equals(userId)) {
			model.addAttribute("isOwner", true);
		} else {
			model.addAttribute("isOwner", false);
		}

		return "user/board/user_inquiryContent";
	}

	/*@GetMapping("/inquiryContent")
	public String inquiryContent(@RequestParam("inquiryBoardCode") String inquiryBoardCode, Model model) {
		Inquiry inquiry = userInquiryService.getInquiryInfoByCode(inquiryBoardCode);
		model.addAttribute("inquiry", inquiry);
		model.addAttribute("title","문의글 내용");
		return "user/board/user_inquiryContent";
	}*/


	@GetMapping("/inquiryList") //noticeList 복사함
	public String getInquiryList(Model model ,String searchKey, String searchValue
			, HttpSession session
			, @RequestParam(name="msg", required = false) String msg) {
		String memberLevel = (String) session.getAttribute("SLEVEL");

		Map<String, Object> paramMap = null;
		if(memberLevel != null && "2".equals(memberLevel)) {
			String sellerId = (String)session.getAttribute("SID");

			paramMap = new HashMap<String, Object>();
			paramMap.put("searchKey", "g_seller_id");
			paramMap.put("searchValue", sellerId);
		}
		log.info("msg={}", msg);
		List<Inquiry> inquiryList = userInquiryService.getInquiryList(paramMap, searchKey, searchValue);
		model.addAttribute("title", "신고사항");
		model.addAttribute("inquiryList", inquiryList);
		if(msg != null) model.addAttribute("msg", msg);

		return "user/board/user_inquiryList";
	}

	@GetMapping("/addInquiry")
	public String addInquiry(Model model){
		model.addAttribute("title", "문의사항");
		model.addAttribute("inquiryTypeList", userInquiryMapper.getInquiryTypeList());
		return "user/board/user_addInquiry";
	}

	@PostMapping("/addInquiry")
	public String addInquiry(Inquiry inquiry) {
		userInquiryService.addInquiry(inquiry);
		return "redirect:/user/inquiryList";
	}

	@GetMapping("/removeInquiry")
	public String removeInquiry(Model model, @RequestParam(name="inquiryBoardCode") String inquiryBoardCode){
		model.addAttribute("title", "문의 삭제");
		model.addAttribute("inquiryBoardCode", inquiryBoardCode);
		return "user/board/user_removeInquiry";
	}

	@PostMapping("/removeInquiry")
	public String removeInquiry(@RequestParam(name="inquiryBoardCode") String inquiryBoardCode
			,@RequestParam(name="memberId") String memberId
			,@RequestParam(name="memberPw") String memberPw
			,HttpSession session
			,RedirectAttributes reAttr) {
		String memberLevel = (String) session.getAttribute("SLEVEL");
		boolean isDelete = true;
		String msg = "";
		if(memberLevel != null && "2".equals(memberLevel)) {
			isDelete = userInquiryMapper.isPosterByInquiryBoardCode(memberId, inquiryBoardCode);
		}

		Member member = userMemberMapper.getMemberInfoById(memberId);
		if(member != null) {
			String checkPw = member.getMemberPw();
			if(!checkPw.equals(memberPw)) isDelete = false;
		}
		if(isDelete) {
			userInquiryService.removeInquiry(inquiryBoardCode);
			msg = "문의코드: "+ inquiryBoardCode + " 가 삭제되었습니다.";
		}else {
			msg = "문의코드: "+ inquiryBoardCode + " 를 삭제할 수 없습니다.";
		}
		reAttr.addAttribute("msg", msg);

		return "redirect:/user/inquiryList";
	}
	@GetMapping("/modifyInquiry")
	public String modifyInquiry(Model model
								,@RequestParam(name="inquiryBoardCode") String inquiryBoardCode){

		Inquiry inquiryInfo = userInquiryService.getInquiryInfoByCode(inquiryBoardCode);

		log.info("{}",inquiryInfo);

		model.addAttribute("title","문의수정");
		model.addAttribute("inquiryInfo", inquiryInfo);

		return "user/board/user_modifyInquiry";
	}
	@PostMapping("/modifyInquiry")
	public String modifyInquiry(Inquiry inquiry) {
		userInquiryService.modifyInquiry(inquiry);
		return "redirect:/user/inquiryList";
	}


}
