package com.funtl.my.shop.web.api.service;

import com.funtl.my.shop.domain.TbUser;

/**
 * 会员管理
 * <p>Title: TbUserService</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/6 9:12
 */
public interface TbUserService {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);

    /**
     *
     * 功能描述: 通过用户名查找TbUser
     *
     * @param:  username
     * @return: TbUser
     * @auther: werson
     * @date:
     */
    TbUser findTbUserByUsername(String username);

    /**
     *
     * 功能描述:保存TbUser
     *
     * @param: user
     * @return:
     * @auther: werson
     * @date:
     */
    void save(TbUser user);
}
