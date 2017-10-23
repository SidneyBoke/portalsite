package com.jyj.portal.controller;

import com.jyj.portal.model.User;
import com.jyj.portal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by jiangyijie on 2017/9/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("msg", "testmodel");
        return "showUser";
    }

    @RequestMapping("/showUserList")
    public ModelAndView showUserList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.getAllUsers();
        mv.addObject("users", userList);
        mv.setViewName("showUserList");
        return mv;
    }
}
