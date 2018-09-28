package com.funtl.my.shop.web.ui.controller;

import com.funtl.my.shop.web.ui.api.UsersApi;
import com.funtl.my.shop.web.ui.dto.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 注册控制器
 * <p>Title: RegisterController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/5 12:34
 */
@Controller
public class RegisterController {

    /**
     * 跳转注册页
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }


    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    public String doRegister(String password,String username,String phone) throws Exception{
        TbUser user=new TbUser();
        user.setUsername(username);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setPhone(phone);
        TbUser tbUser=UsersApi.register(user);
        if (tbUser!=null){
            return "redirect:/login";
        }else {
            return "register";
        }
    }

    @RequestMapping(value = "findTbUser", method = RequestMethod.POST)
    public void findTbUser(String username, HttpServletResponse resp) throws Exception{
        TbUser user=new TbUser();
        user.setUsername(username);
        TbUser tbUser=UsersApi.findTbUserByUsername(user);
        PrintWriter writer=resp.getWriter();
        if (tbUser!=null){
            writer.print("false");
        }else {
            writer.print("true");
        }
    }

}
