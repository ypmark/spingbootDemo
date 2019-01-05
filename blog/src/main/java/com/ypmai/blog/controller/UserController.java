package com.ypmai.blog.controller;

import com.ypmai.blog.domain.User;
import com.ypmai.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public ModelAndView getUsers(Model model){
        //userRepository.saveOrUpdateUser(new User("abc", "abc@"));
        model.addAttribute("usersList", userRepository.listUsers());
        model.addAttribute("title", "user management");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping("/{id}")
    public ModelAndView getUserById(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        return new ModelAndView("users/view", "userModel", model);
    }

    @GetMapping("/form")
    public ModelAndView createOrModForm(Model model){
        model.addAttribute("user", new User());
        return new ModelAndView("users/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView postUser(User user, Model model){
        userRepository.saveOrUpdateUser(user);
        model.addAttribute("userList", userRepository.listUsers());
        model.addAttribute("title", "user management");
        /**
         * Created by MaiYuPing on 2018/12/27
         * @Description: post方法重定向，这里使用redirect后面的参数是指路由，方法GET，并非是指某个HTML文件路径，这是个坑
         */
        return new ModelAndView("redirect:users", "userModel", model);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id, Model model){
        userRepository.deleteUser(id);
        model.addAttribute("usersList", userRepository.listUsers());
        model.addAttribute("title", "user management");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        return new ModelAndView("users/form", "userModel", model);
    }
}
