package cn.people.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user/session")
    @ResponseBody
    public String session(HttpServletRequest request) {
        return request.getSession().getId();  
    }
    @RequestMapping("/user/index")
    public Object userIndex(HttpServletRequest request) {
        return "user/index";
    }

    
//    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/admin/index")
    @ResponseBody
    public Object adminIndex(HttpServletRequest request) {
        return "admin/index";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
