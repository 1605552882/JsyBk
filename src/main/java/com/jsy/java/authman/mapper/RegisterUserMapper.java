package com.jsy.java.authman.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jsy.java.authman.model.RegisterUser;
import java.util.List;



public interface RegisterUserMapper extends BaseMapper<RegisterUser> {
    List<RegisterUser> selectRegisterUserList(Page page);
}
