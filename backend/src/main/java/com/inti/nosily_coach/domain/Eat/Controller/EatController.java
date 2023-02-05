package com.inti.nosily_coach.domain.Eat.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class EatController {
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() { // 목록을 보여주는 메서드
        return "/api/list"; // /api/list URL 반환하기
    }
}
