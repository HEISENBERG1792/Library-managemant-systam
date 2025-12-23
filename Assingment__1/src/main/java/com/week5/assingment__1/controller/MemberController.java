package com.week5.assingment__1.controller;

import com.week5.assingment__1.model.Member;
import com.week5.assingment__1.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class MemberController {
    @Autowired
    private MemberService memberService;
    @PostMapping("/api/member")
    public Member registerNewMember(@Valid @RequestBody Member member){
        return memberService.registerMember(member);
    }
    @GetMapping("/api/member")
    public List<Member>getAllMember(){
        return memberService.getAllMember();
    }
    @GetMapping("/api/member/{id}")
    public Optional<Member>getMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }
}
