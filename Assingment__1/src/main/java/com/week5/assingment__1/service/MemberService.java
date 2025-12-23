package com.week5.assingment__1.service;

import com.week5.assingment__1.model.Member;
import com.week5.assingment__1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
   @Autowired
   private MemberRepository memberRepository;

    public Member registerMember(Member member){
        Optional<Member> existmember=memberRepository.findByEmail(member.getEmail());
        if(existmember.isPresent())throw new RuntimeException("Email"+member.getEmail()+" exists!!");
        member.setMembershipDate(LocalDate.now());
        return memberRepository.save(member);
    }
    public List<Member>getAllMember(){
        return memberRepository.findAll();
    }
    public Optional<Member> getMemberById(Long id){
        return memberRepository.findById(id);
    }
}
