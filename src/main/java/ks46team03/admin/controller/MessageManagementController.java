package ks46team03.admin.controller;

import ks46team03.admin.mapper.MessageManagementMapper;
import ks46team03.admin.service.MessageManagementService;
import ks46team03.dto.MessageManagement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MessageManagementController {
    private final MessageManagementService messageManagementService;
    private final MessageManagementMapper messageManagementMapper;
    public MessageManagementController(MessageManagementService messageManagementService, MessageManagementMapper messageManagementMapper){
        this.messageManagementService = messageManagementService;
        this.messageManagementMapper = messageManagementMapper;
    }
    /**
     * 상세메세지삭제화면 리다이렉트
     * @param messageManagementCode
     * @return
     */
    @PostMapping("/message/admin_removeMessageManagement")
    public String removeMessageManagement(String messageManagementCode) {

        messageManagementMapper.removeMessageManagementById(messageManagementCode);

        return "redirect:/admin/message/admin_messageManagementList";
    }

    /**
     * 상세메세지삭제화면
     * @param messageManagementCode
     * @param model
     * @return
     */
    @GetMapping("/message/admin_removeMessageManagement")
    public String removeMessageManagement(@RequestParam(name = "messageManagementCode") String messageManagementCode, Model model){
        model.addAttribute("title", "상세메세지삭제화면");
        model.addAttribute("messageManagementCode", messageManagementCode);

        return "/admin/message/admin_removeMessageManagement";
    }


    /**
     * 메세지상세목록조회
     * @param model
     * @return
     */
    @GetMapping("/message/admin_messageManagementList")
    public String getMessageManagementList(Model model) {
        List<MessageManagement> messageManagementList = messageManagementService.getMessageManagementList();
        model.addAttribute("title","메세지상세목록조회");
        model.addAttribute("messageManagementList",messageManagementList);
        return "/admin/message/admin_messageManagementList";

    }

}
