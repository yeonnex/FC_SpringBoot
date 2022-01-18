package com.example.hellofastcampus.Controller;

import com.example.hellofastcampus.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Map;

@RestController
@RequestMapping(("/api/get"))
public class GetApiController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping(path="/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println(name);
        return name;
    }

    // https://www.google.com/
    // search?q=오렌지
    // &oq=오렌지
    // &aqs=chrome..69i57j46i433i512j46i131i199i433i465i512j46i175i199i512l2j0i512l4.931j0j4
    // &sourceid=chrome
    // &ie=UTF-8

    // ?key=value&key2=value

    // http://localhost:8080/api/get/query-param?name=seoyeon&email=syhoneyjam@naver.com
    @GetMapping("/query-param")
    public String queryParam(@RequestParam String name, @RequestParam String email){
        return name+email;
    }

    @GetMapping("/query-param2")
    public String queryParam2(@RequestParam Map<String, String> map){
        StringBuilder sb = new StringBuilder();
        map.forEach((k,v) -> {
            System.out.println(k + v);
            sb.append(k + "=" + v);
        });
        return sb.toString();
    }

    @GetMapping("/query-param3")
    public String queryParam3(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}
