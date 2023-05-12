package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Inquiry;
import ks46team03.dto.Member;
import ks46team03.dto.Notice;
import ks46team03.dto.Report;
import ks46team03.user.mapper.UserNoticeMapper;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.service.UserNoticeService;
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
public class NoticeController {

	private final UserNoticeService userNoticeService;
	private final UserMemberMapper userMemberMapper;
	private final UserNoticeMapper userNoticeMapper;

	public NoticeController(UserNoticeService userNoticeService, UserMemberMapper userMemberMapper, UserNoticeMapper userNoticeMapper){
		this.userNoticeService = userNoticeService;
		this.userMemberMapper = userMemberMapper;
		this.userNoticeMapper = userNoticeMapper;
	}

	@GetMapping("/noticeContent")
	public String inquiryContent(@RequestParam("noticeBoardCode") String noticeBoardCode, Model model) {
		Notice notice = userNoticeService.getNoticeInfoByCode(noticeBoardCode);
		model.addAttribute("notice", notice);
		model.addAttribute("title","공지글 내용");
		return "user/board/user_noticeContent";
	}

	@GetMapping("/noticeList") //GoodsList에서 가져옴
	public String getNoticeList(Model model ,String searchKey,String searchValue
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

		List<Notice> noticeList = userNoticeService.getNoticeList(paramMap, searchKey,searchValue );
		model.addAttribute("title", "공지사항");
		model.addAttribute("noticeList", noticeList);
		if(msg != null) model.addAttribute("msg", msg);

		return "user/board/user_noticeList";
	}
	@GetMapping("/addNotice")
	public String addNotice(Model model){
		model.addAttribute("title","공지게시판");
		return "user/board/user_addNotice";
	}
	@PostMapping("/addNotice")
	public String addNotice(Notice notice){
		userNoticeService.addNotice(notice);
		return "redirect:/user/noticeList";
	}
	@GetMapping("/removeNotice")
	public String removeNotice(Model model, @RequestParam(name="noticeBoardCode") String noticeBoardCode){
		model.addAttribute("title","공지 삭제");
		model.addAttribute("noticeBoardCode", noticeBoardCode);
		return "user/board/user_removeNotice";
	}
	@PostMapping("/removeNotice")
	public String removeInquiry(@RequestParam(name="noticeBoardCode") String noticeBoardCode
			, @RequestParam(name="memberId") String memberId
			, @RequestParam(name="memberPw") String memberPw
			, HttpSession session
			, RedirectAttributes reAttr) {
		String memberLevel = (String) session.getAttribute("SLEVEL");
		boolean isDelete = true;
		String msg = "";
		if(memberLevel != null && "2".equals(memberLevel)) {
			isDelete = userNoticeMapper.isPosterByNoticeCode(memberId, noticeBoardCode);
		}

		Member member = userMemberMapper.getMemberInfoById(memberId);
		if(member != null) {
			String checkPw = member.getMemberPw();
			if(!checkPw.equals(memberPw)) isDelete = false;
		}
		if(isDelete) {
			userNoticeService.removeNotice(noticeBoardCode);
			msg = "공지 코드: "+ noticeBoardCode + " 가 삭제되었습니다.";
		}else {
			msg = "공지 코드: "+ noticeBoardCode + " 를 삭제할 수 없습니다.";
		}
		reAttr.addAttribute("msg", msg);

		return "redirect:/user/noticeList";
	}

	@GetMapping("/modifyNotice")
	public String modifyNotice(Model model
			,@RequestParam(name="noticeBoardCode") String noticeBoardCode){
		Notice noticeInfo = userNoticeService.getNoticeInfoByCode(noticeBoardCode);

		model.addAttribute("title","공지수정");
		model.addAttribute("noticeInfo", noticeInfo);

		return "user/board/user_modifyNotice";
	}
	@PostMapping("/modifyNotice")
	public String modifyNotice(Notice notice){
		userNoticeService.modifyNotice(notice);
		return "redirect:/user/noticeList";
	}




}
