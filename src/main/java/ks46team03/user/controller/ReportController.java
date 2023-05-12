package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Inquiry;
import ks46team03.dto.Member;
import ks46team03.dto.Report;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.mapper.UserReportMapper;
import ks46team03.user.service.UserReportService;
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
public class ReportController {

	private final UserReportService userReportService;
	private final UserMemberMapper userMemberMapper;
	private final UserReportMapper userReportMapper;

	public ReportController(UserReportService userReportService, UserMemberMapper userMemberMapper, UserReportMapper userReportMapper){
		this.userReportService = userReportService;
		this.userMemberMapper = userMemberMapper;
		this.userReportMapper = userReportMapper;
	}
	@GetMapping("/reportContent")
	public String reportContent(@RequestParam("reportBoardCode") String reportBoardCode, Model model, HttpSession session) {
		Report report = userReportService.getReportInfoByCode(reportBoardCode);
		model.addAttribute("report", report);
		model.addAttribute("title","신고 내용");

		// 세션에서 로그인한 사용자 ID를 가져옴
		String userId = (String) session.getAttribute("SID");

		// 글쓴이와 로그인한 사용자 ID가 같을 경우, 수정 및 삭제 버튼을 보이도록 설정
		if (report.getMemberId().equals(userId)) {
			model.addAttribute("isOwner", true);
		} else {
			model.addAttribute("isOwner", false);
		}
		return "user/board/user_reportContent";
	}

	@GetMapping("/reportList") //noticeList 복사함
	public String getReportList(Model model ,String searchKey,String searchValue
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

		List<Report> reportList = userReportService.getReportList(paramMap, searchKey,searchValue);
		model.addAttribute("title", "신고사항");
		model.addAttribute("reportList", reportList);
		if(msg != null) model.addAttribute("msg", msg);

		return "user/board/user_reportList";
	}

	@GetMapping("/addReport")
	public String addReport(Model model){
		model.addAttribute("title", "신고게시판");
		model.addAttribute("reportTypeList",userReportMapper.getReportTypeList());
		return "user/board/user_addReport";
	}

	@PostMapping("/addReport")
	public String addReport(Report report){
		userReportService.addReport(report);
		return "redirect:/user/reportList";
	}

	@GetMapping("/removeReport")
	public String removeInquiry(Model model, @RequestParam(name="reportBoardCode") String reportBoardCode){
		model.addAttribute("title", "신고 삭제");
		model.addAttribute("reportBoardCode", reportBoardCode);
		return "user/board/user_removeReport";
	}

	@PostMapping("/removeReport")
	public String removeInquiry(@RequestParam(name="reportBoardCode") String reportBoardCode
			, @RequestParam(name="memberId") String memberId
			, @RequestParam(name="memberPw") String memberPw
			, HttpSession session
			, RedirectAttributes reAttr) {
		String memberLevel = (String) session.getAttribute("SLEVEL");
		boolean isDelete = true;
		String msg = "";
		if(memberLevel != null && "2".equals(memberLevel)) {
			isDelete = userReportMapper.isPosterByReportBoardCode(memberId, reportBoardCode);
		}

		Member member = userMemberMapper.getMemberInfoById(memberId);
		if(member != null) {
			String checkPw = member.getMemberPw();
			if(!checkPw.equals(memberPw)) isDelete = false;
		}
		if(isDelete) {
			userReportService.removeReport(reportBoardCode);
			msg = "신고코드: "+ reportBoardCode + " 가 삭제되었습니다.";
		}else {
			msg = "신고코드: "+ reportBoardCode + " 를 삭제할 수 없습니다.";
		}
		reAttr.addAttribute("msg", msg);

		return "redirect:/user/reportList";
	}

	@GetMapping("/modifyReport")
	public String modifyReport(Model model
                                ,@RequestParam(name="reportBoardCode") String reportBoardCode){
		Report reportInfo = userReportService.getReportInfoByCode(reportBoardCode);

		model.addAttribute("title","신고수정");
		model.addAttribute("reportInfo", reportInfo);

		return "user/board/user_modifyReport";
	}
	@PostMapping("/modifyReport")
	public String modifyReport(Report report){
		userReportService.modifyReport(report);
		return "redirect:/user/reportList";
	}
}
