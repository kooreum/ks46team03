package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Inquiry;
import ks46team03.dto.Report;
import ks46team03.user.mapper.UserInquiryMapper;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.mapper.UserReportMapper;
import ks46team03.user.service.UserInquiryService;
import ks46team03.user.service.UserReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class InquiryController {

	private final UserInquiryService userInquiryService;
	private final UserMemberMapper userMemberMapper;
	private final UserInquiryMapper userInquiryMapper;

	public InquiryController(UserInquiryService userInquiryService, UserMemberMapper userMemberMapper, UserInquiryMapper userInquiryMapper){
		this.userInquiryService = userInquiryService;
		this.userMemberMapper = userMemberMapper;
		this.userInquiryMapper = userInquiryMapper;
	}

	@GetMapping("/inquiryList") //noticeList 복사함
	public String getInquiryList(Model model
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

		List<Inquiry> inquiryList = userInquiryService.getInquiryList(paramMap);
		model.addAttribute("title", "신고사항");
		model.addAttribute("inquiryList", inquiryList);
		if(msg != null) model.addAttribute("msg", msg);

		return "user/board/user_inquiryList";
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


}
