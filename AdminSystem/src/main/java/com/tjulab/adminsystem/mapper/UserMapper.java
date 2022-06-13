package com.tjulab.adminsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjulab.adminsystem.bean.User;

/**
 * MyBatis-plus
 *
 * BaseMapper<User>中的"User"要跟数据库中被操作的表名一致，如果不一致，则应该在User类中使用@TableName注解指定
 */
public interface UserMapper extends BaseMapper<User> {
}
