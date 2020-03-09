package com.supervision.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supervision.entity.Record;
import com.supervision.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;



// http://localhost:8080/supervision/login


@org.springframework.stereotype.Controller
@RequestMapping("/supervision") 
public class Controller {

    @Autowired
    Service service;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";     // /WEB-INF/jsp/login.jsp
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (service.findUserByNameWithPassword(name, password)) {
            service.insertRecord(name);

            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION_name", name);

            return "redirect:content";
        } else {
            return "login";
        }
    }


    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String content(@RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo, ModelMap map) {
        // 每页显示记录数
        Integer pageSize = 10;

        // 分页查询
        PageHelper.startPage(pageNo, pageSize);
        List<Record> recordList = service.getRecordList();
        PageInfo<Record> pageInfo = new PageInfo<Record>(recordList);

        // 加到map
        map.addAttribute("pageInfo", pageInfo);
        return "content";
    }


    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String toPassword() {
        return "password";
    }


    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String password(@RequestParam("name") String name,
                           @RequestParam("password") String password,
                           @RequestParam("new_password") String new_password,
                           @RequestParam("new_password_again") String new_password_again) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!(name.equals("") || password.equals("") || new_password.equals("") || new_password_again.equals(""))) {
            if (service.findUserByNameWithPassword(name, password)) {
                if (new_password.equals(new_password_again)) {
                    if (service.ModifyPassword(name, password, new_password)) {
                        return "login";
                    }
                    return "password";
                }
                return "password";
            }
            return "password";
        }
        return "password";
    }
}