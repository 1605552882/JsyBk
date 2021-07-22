package com.jsy.java.authman.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jsy.java.authman.model.RegisterUser;





public interface RegisterUserService extends IService<RegisterUser> {
    Page<RegisterUser> selectRegisterUserList(Page<RegisterUser> page);
}
