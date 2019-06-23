package com.itheima.web;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author 王磊
 * @Date 2019/6/14/014
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/all")
    public String findAll(HttpServletRequest request) {
        List<User> users = userService.findAll();
        request.setAttribute("list", users);
        return "list";
    }

    @RequestMapping(path = "/login")
    public String login(HttpSession session, Model model, User user, String verifycode) {
        String session_check = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (session_check != null) {
            if (verifycode != null && !"".equals(verifycode)) {
                if (verifycode.equalsIgnoreCase(session_check)) {
                    user= userService.login(user);
                    if (user == null) {
                        model.addAttribute("login_msg", "用户名或者密码错误");
                        return "login";
                    } else {
                        session.setAttribute("userLogin",user);
                        return "index";
                    }
                } else {
                    model.addAttribute("login_msg", "验证码错误");
                }
            } else {
                model.addAttribute("login_msg", "验证码不能为空");
            }
        } else {
            model.addAttribute("login_msg", "验证码错误");
        }
        return "login";

    }

    @RequestMapping("/addUser")
    public String add(User user) {
        userService.addUser(user);
        return "redirect:/user/all";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.deleteUser(id);
        return "redirect:/user/all";
    }

    @RequestMapping("/selectUserById")
    public String selectUserById(String id, HttpServletRequest request) {
        User user = userService.findUserById(id);
           request.setAttribute("user", user);
        return "update";
    }

    @RequestMapping("/update")
    public String update(User user) {
        userService.updateUser(user);
        return "redirect:/user/all";
    }
    @RequestMapping("/deleteByIds")
    public String deleteByIds(String[] uid) {
        userService.delSelectedUser(uid);
        return  "redirect:/user/all";
    }
}


/*
@Autowired
    private UserService userService;

    @RequestMapping(path = "/",method= RequestMethod.GET)
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("list", users);
        return "list";
    }

    @RequestMapping(path = "/user/{user}",method=RequestMethod.GET)
    public String login(HttpSession session, Model model, @PathVariable("user")User user, String verifycode) {
        String session_check = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (session_check != null && session_check.length() > 0) {
            if (verifycode != null && !"".equals(verifycode)) {
                if (verifycode.equalsIgnoreCase(session_check)) {
                    user = userService.login(user);
                    if (user == null) {
                        model.addAttribute("login_msg", "用户名或者密码错误");
                        return "login";
                    } else {
                        return "index";
                    }
                } else {
                    model.addAttribute("login_msg", "验证码错误");
                }
            } else {
                model.addAttribute("login_msg", "验证码不能为空");
            }
        } else {
            model.addAttribute("login_msg", "验证码错误");
        }
        return "login";
    }

    @RequestMapping(path = "/user/{user}",method=RequestMethod.POST)
    public String add(@PathVariable("user")User user) {
        userService.addUser(user);
        return "redirect:/user/all";
    }

    @RequestMapping(path = "/user/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id")Integer id) {
        userService.deleteUser(id);
        return "redirect:/user/all";
    }

    @RequestMapping(path = "/user/{id}",method=RequestMethod.GET)
    public String selectUserById(@PathVariable("id")String id, HttpServletRequest request) {
        User user = userService.findUserById(id);
        request.setAttribute("user", user);
        return "update";
    }

    @RequestMapping(path = "/user/{user}",method=RequestMethod.PUT)
    public String update(@PathVariable("user")User user) {
        userService.updateUser(user);
        return "redirect:/user/all";
    }
 */