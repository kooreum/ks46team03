package ks46team03.admin.controller;


import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Inquiry;
import ks46team03.dto.Member;
import ks46team03.user.mapper.UserInquiryMapper;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.service.UserInquiryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("adminInquiryController")
@RequestMapping("/admin")
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

	@GetMapping("/inquiryList") //noticeList 복사함
	public String getInquiryList(Model model,String searchKey,String searchValue
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
		List<Inquiry> inquiryList = userInquiryService.getInquiryList(paramMap, searchKey,searchValue );
		model.addAttribute("title", "신고사항");
		model.addAttribute("inquiryList", inquiryList);
		if(msg != null) model.addAttribute("msg", msg);

		return "admin/board/admin_inquiryList";
	}

	@GetMapping("/addInquiry")
	public String addInquiry(Model model){
		model.addAttribute("title", "문의사항");
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

	/**
	 * 선택한 문의 삭제
	 * @param
	 * @return
	 */
	@PostMapping("/removeCheckedInquiry")
	@ResponseBody
	public List<String> removeCheckedInquiry(@RequestParam(value="valueArr[]") List<String> valueArr) {

		log.info("valueArr: {}", valueArr);
		userInquiryService.removeCheckedInquiry(valueArr);

		return valueArr;
	}


}
