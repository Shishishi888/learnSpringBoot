package com.tjulab.adminsystem.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user_tbl") // 指定表名
public class User {
    /**
     * 以下不是数据库user表中的字段
     */
    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String passWord;


    /**
     * 以下是数据库的字段
     */
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
