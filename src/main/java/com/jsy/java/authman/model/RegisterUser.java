package com.jsy.java.authman.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("register_user")
public class RegisterUser implements Serializable {

    private static final  long serialVersionUID=1L;
    @TableId(value = "register_id", type = IdType.AUTO)
    private Integer registerId;

    private String registerUserName;

    private String registerEmail;

    private String registerPhone;


}
