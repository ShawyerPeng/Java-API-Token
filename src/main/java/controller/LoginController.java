package controller;

import filter.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = "/user/register")
    @ResponseBody
    public String register(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        System.out.println(userName + " " + userPass);
        return "ok";
    }

    @RequestMapping(value = "/user/login")
    @ResponseBody
    public Map<String, Object> login(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        System.out.println(userName + " " + userPass);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        String token = JwtUtil.generToken("Shawyer", null, null);
        data.put("token", token);
        map.put("data", data);
        map.put("statusCode", "200");
        map.put("message", "登陆成功");
        return map;
    }

    @RequestMapping("/other")
    @ResponseBody
    public String other() {
        return "访问成功！除login和register外，其他请求都需要在请求头或访问参数中传递Token！";
    }
}
