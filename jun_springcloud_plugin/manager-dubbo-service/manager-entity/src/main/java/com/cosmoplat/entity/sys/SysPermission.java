package com.cosmoplat.entity.sys;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限菜单
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Data
public class SysPermission implements Serializable {


    @TableId
    private String id;

    @NotBlank(message = "菜单权限名称不能为空")
    private String name;

    private String perms;

    private String url;

    private String icon;

    private String target;

    @NotNull(message = "所属菜单不能为空")
    private String pid;

    private Integer orderNum;

    @NotNull(message = "菜单权限类型不能为空")
    private Integer type;

    @TableField(fill = FieldFill.INSERT)
    private Integer unableFlag;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String createId;

    private String updateId;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    @TableField(exist = false)
    private String pidName;

}