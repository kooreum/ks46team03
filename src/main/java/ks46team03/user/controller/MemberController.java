package ks46team03.user.controller;
//로그인 회원 불일치시 알람창 > 등록된 회원 정보가 없습니다' 를
// 등록된 정보가 없거나 아이디 패스워드를 확인해주세요 로 변경했습니다.

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.service.UserMemberService;
import ks46team03.dto.Member;
import ks46team03.dto.MemberLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;


@Controller("userMemberController")
@RequestMapping("/user/member")
public class MemberController {
    private static final Logger
            log = LoggerFactory.getLogger(MemberController.class);
    private final UserMemberService userMemberService;
    private final UserMemberMapper userMemberMapper;

    public MemberController(UserMemberService userMemberService, UserMemberMapper userMemberMapper) {
        this.userMemberService = userMemberService;
        this.userMemberMapper = userMemberMapper;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session
            ,@CookieValue(value="loginKeepId", required = false) Cookie cookie
            ,HttpServletResponse response) {
        if(cookie != null) {
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        session.invalidate();
        return "redirect:/user/index";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "memberId") String memberId
            , @RequestParam(name = "memberPw") String memberPw
            , HttpSession session
            , RedirectAttributes reAttr
            , HttpServletResponse response) {
        String redirect = "redirect:/user/member/login";
        Map<String, Object> loginResultMap = userMemberService.loginCheck(memberId, memberPw);
        boolean loginCheck = (boolean) loginResultMap.get("loginCheck");
        if(loginCheck) {
            Member memberInfo = (Member) loginResultMap.get("memberInfo");
            String memberName = memberInfo.getMemberName();
            String levelNum = memberInfo.getLevelNum();
            session.setAttribute("SID",     memberId);
            session.setAttribute("SLEVEL",  levelNum);
            session.setAttribute("SNAME",   memberName);

            // if(하루동안 유지하는 체크박스 value yes)
            Cookie cookie = new Cookie("loginKeepId", memberId);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24); //60초 * 60분 * 24 하루
            response.addCookie(cookie);

            redirect = "redirect:/";
        }else {
            reAttr.addAttribute("result", "등록된 정보가 없거나 아이디 패스워드를 확인해주세요");
        }

        return redirect;
    }

    @GetMapping("/login")
    public String userLogin(Model model
                            ,@RequestParam(name = "result", required = false) String result) {
        model.addAttribute("title", "로그인");
        if(result != null) model.addAttribute("result", result);

        return "/user/member/user_login";
    }

    @PostMapping("/addMember")
    public String addMember(Member member) {
        //log.info("화면에서 전달받은 데이터 : {}", member);
        userMemberService.addMember(member);
        return "redirect:/user/member/login";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public boolean idCheck(@RequestParam(name = "memberId") String memberId) {
        boolean checked = true;
        //아이디 중복체크
        checked = userMemberMapper.idCheck(memberId);

        return checked;
    }
//수정
    @PostMapping("/nickCheck")
    @ResponseBody
    public boolean nickCheck(@RequestParam(name = "memberNickname") String memberNickname) {
        boolean checked1 = true;
        //닉네임 중복체크
        checked1 = userMemberMapper.nickCheck(memberNickname);

        return checked1;
    }

    @GetMapping("/addMember")
    public String addMember(Model model) {

        List<MemberLevel> memberLevelList = userMemberService.getMemberLevelList();

        model.addAttribute("title", "회원가입");
        model.addAttribute("memberLevelList", memberLevelList);

        return "/user/member/user_addMember";
    }

    @PostMapping("/modifyMember")
    public String modifyMember(Member member) {
        userMemberMapper.modifyMember(member);

        return "redirect:/user/index";
    }

    @GetMapping("/modifyMember")
    public String modifyMember(@RequestParam(name="memberId") String memberId, Model model) {
        Member memberInfo = userMemberService.getMemberInfoById(memberId);
        List<MemberLevel> memberLevelList = userMemberService.getMemberLevelList();
        model.addAttribute("title", "회원수정");
        model.addAttribute("memberLevelList", memberLevelList);
        model.addAttribute("memberInfo", memberInfo);

        return "/user/member/user_modifyMember";
    }

    @GetMapping("/memberList")
    public String getMemberList(Model model
                                ,@RequestParam(name="searchKey", required = false) String searchKey
                                ,@RequestParam(name="searchValue", required = false) String searchValue) {
        List<Member> memberList = userMemberService.getMemberList(searchKey, searchValue);
        model.addAttribute("title", "회원목록조회");
        model.addAttribute("memberList", memberList);

        return "/user/member/user_memberList";
    }

    @PostMapping("removeMember")
    public String removeMember(@RequestParam(name = "memberId") String memberId
            ,@RequestParam(name = "memberPw") String memberPw) {
        String redirectURI = "redirect:/user/member/user_removeMember?memberId=" + memberId;
        //비밀번호 확인
        Member member = userMemberService.getMemberInfoById(memberId);
        if(member != null) {
            String checkPw = member.getMemberPw();
            if(checkPw.equals(memberPw)) {
                //서비스 호출
                userMemberService.removeMember(memberId);
                redirectURI = "redirect:/user/member/memberList";
            }
        }
        return redirectURI;
    }

    /**
     * 회원탈퇴화면
     * @param memberId
     * @param model
     * @return
     */
    @GetMapping("/removeMember")
    public String removeMember(@RequestParam(name = "memberId") String memberId, Model model){
        model.addAttribute("title", "회원탈퇴");
        model.addAttribute("memberId", memberId);

        return "/user/member/user_removeMember";
    }
}
