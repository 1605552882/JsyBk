package com.jsy.java.authman.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jsy.java.authman.mapper.RegisterUserMapper;
import com.jsy.java.authman.model.RegisterUser;
import com.jsy.java.authman.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserServiceImpl extends ServiceImpl<RegisterUserMapper, RegisterUser> implements RegisterUserService {

    @Autowired
    private RegisterUserMapper registerUserMapper;


    @Override
    public Page<RegisterUser> selectRegisterUserList(Page<RegisterUser> page) {
        page.setRecords(registerUserMapper.selectRegisterUserList(page));
        return page;
    }
}
