package com.yuxs.service.impl;

import com.yuxs.mapper.UserMapper;
import com.yuxs.pojo.User;
import com.yuxs.service.UserService;
import com.yuxs.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        //密码加密
        //添加
        userMapper.add(username,password);
    }
    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id =  (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        //传入加密的密码（Md5Util.getMd）
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id =  (Integer) map.get("id");
        userMapper.updatePwd(newPwd ,id);
    }
}
