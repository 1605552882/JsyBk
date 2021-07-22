package com.jsy.java.authman.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jsy.java.authman.common.Result;
import com.jsy.java.authman.common.ResultUtil;
import com.jsy.java.authman.model.RegisterUser;
import com.jsy.java.authman.service.RegisterUserService;
import com.jsy.java.authman.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/registerUser")
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @Autowired
    private SysUserService sysUserService;



    @PostMapping("list")
    @ResponseBody
    public Result<IPage<RegisterUser>> list(@RequestParam(value = "username", required = false) String username,
                                            @RequestParam(value = "deptId", required = false) Integer deptId,
                                            @RequestParam(defaultValue = "1") Integer pageNo,
                                            @RequestParam(defaultValue = "10") Integer pageSize) {
        QueryWrapper<RegisterUser> queryWrapper = new QueryWrapper<>();
        Page<RegisterUser> page = new Page<>(pageNo,pageSize);
        IPage<RegisterUser> result = registerUserService.selectRegisterUserList(page);
        // 设置总记录数
        result.setTotal(registerUserService.count(queryWrapper));


        return ResultUtil.ok(result);
    }
}
