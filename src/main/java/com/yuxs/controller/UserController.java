package com.yuxs.controller;

import ch.qos.logback.core.util.StringUtil;
import com.auth0.jwt.JWT;
import com.yuxs.pojo.Result;
import com.yuxs.pojo.User;
import com.yuxs.service.UserService;
import com.yuxs.utils.JwtUtil;
import com.yuxs.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    //@Pattern(regexp = "^\\s{5,16}$")  @Pattern(regexp = "^\\s{5,16}$")
    public Result register(String username,  String password){
            //查询用户
            User u = userService.findByUserName(username);
            if(u==null){
                userService.register(username,password);
                return Result.success();
            }else {
                return Result.error("用户名存在！");
            }
    }
    @PostMapping("/login")
    //@Pattern(regexp = "^\\s{5,16}$") @Pattern(regexp = "^\\s{5,16}$")
    public Result<String> login(String username,  String password){
        //根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        //判断用户是否存在
        if(loginUser==null){
            return Result.error("用户名错误");
        }
        //判断密码是否正确 ，password中的对象是加密的
        if(password.equals(loginUser.getPassword())){
            //登录成功
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }else {
            return Result.error("密码错误！");
        }
    }
    @GetMapping("/userInfo")
//    @RequestHeader(name = "Authorization") String token
    public Result<User> userInfo(){
        //根据用户名查询用户
//        Map<String,Object> map =  JwtUtil.parseToken(token);
//        String username =(String) map.get("username");
        Map<String,Object> map = ThreadLocalUtil.get();
        String username =(String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success();

    }
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少参数！");
        }
        //原密码是否正确
        //调用userservice根据用户名拿到密码，和olsped对比
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);

        if(!loginUser.getPassword().equals(oldPwd)){
            return Result.error("原密码不正确！");
        }
        if (!rePwd.equals(newPwd)){
            return Result.error("密码不一样！");
        }

        userService.updatePwd(newPwd);
        return Result.success();
        //调用server密码更新
    }
}
