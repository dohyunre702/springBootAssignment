package com.lion.springboot.api.controller;

import com.lion.springboot.api.domain.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    /*
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
    */
    //without param
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
    //PathVariable (variable = return variable)
    @GetMapping(value = "/variable1/{variable1}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }
    //PathVariable2 (variable != return variable)
    @GetMapping(value = "/variable2/{variable2}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //RequestParam
    @GetMapping("/request1")
    public String getRequestParam1 (
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization)
    {
        return name + " " + email + " " + organization;
    }

    //Map 객체로 받기
    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //DTO로 받기
    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
