package com.tjulab.adminsystem;

import com.tjulab.adminsystem.bean.User;
import com.tjulab.adminsystem.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class AdminSystemApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    // @Transactional // 测试完成后，自动回滚
    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from data_chain", Long.class);
        log.info("记录总数：{}", aLong);
    }

    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用户信息：{}", user);
    }

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello", "world");
        String hello = operations.get("hello");
        System.out.println(hello);
        System.out.println(redisConnectionFactory.getClass());
    }

}
