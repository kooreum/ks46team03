package ks46team03.admin.controller;

import ks46team03.admin.mapper.MessageMapper;
import ks46team03.admin.service.MessageService;
import ks46team03.dto.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/message")
public class MessageController {
    private final MessageService messageService;
    private  final MessageMapper messageMapper;

    public MessageController(MessageService messageService, MessageMapper messageMapper){
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    /**
     * 메세지삭제화면 리다이렉트
     * @param messageCode
     * @return
     */
    @PostMapping("/removeMessage")
    public String removeMessage(String messageCode) {

        messageMapper.removeMessageById(messageCode);

        return "redirect:/admin/message/messageList";
    }

    /**
     * 메세지삭제화면
     * @param messageCode
     * @param model
     * @return
     */
    @GetMapping("/removeMessage")
    public String removeMessage(@RequestParam(name = "messageCode") String messageCode, Model model){
        model.addAttribute("title", "메세지삭제화면");
        model.addAttribute("messageCode", messageCode);

        return "/admin/message/admin_removeMessage";
    }



    /**
     * 메세지정보 수정화면 리다이렉트
     * @param message
     * @return
     */
    @PostMapping("/modifyMessage")
    public String modifyMessage(Message message) {
        messageMapper.modifyMessage(message);

        return "redirect:/admin/message/messageList";
    }

    /**
     * 메세지수정화면
     * @param messageCode
     * @param model
     * @return
     */
    @GetMapping("/modifyMessage")
    public String modifyMessage(@RequestParam(name="messageCode") String messageCode, Model model) {
        Message messageInfo = messageService.getMessageInfoById(messageCode);
        List<Message> messageList = messageService.getMessageList();
        model.addAttribute("title", "메세지수정화면");
        model.addAttribute("messageList", messageList);
        model.addAttribute("messageInfo", messageInfo);

        return "admin/message/admin_modifyMessage";
    }


    /**
     * 메세지등록화면 리다이렉트
     * @param message
     * @return
     */
    @PostMapping("/addMessage")
    public String addMessage(Message message) {
        messageService.addMessage(message);
        return "redirect:/admin/message/messageList";
    }


    /**
     * 메세지등록화면
     * @param model
     * @return
     */
    @GetMapping("/addMessage")
    public String addMessage(Model model) {

        List<Message> messageList = messageService.getMessageList();

        model.addAttribute("title", "메세지등록화면");
        model.addAttribute("messageList", messageList);

        return "admin/message/admin_addMessage";
    }


    /**
     * 메세지목록조회
     * @param model
     * @return
     */
    @GetMapping("/messageList")
        public String getMessageList(Model model) {
            List<Message> messageList = messageService.getMessageList();
            model.addAttribute("title","메세지목록조회");
            model.addAttribute("messageList",messageList);
            return "admin/message/admin_messageList";

        }


}
