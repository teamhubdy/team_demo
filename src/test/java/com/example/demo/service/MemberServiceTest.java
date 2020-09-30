package com.example.demo.service;

import com.example.demo.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void join(){
        //given
        Member member = new Member(); 
        member.setName("hello");
        //when
        memberService.join(member);
        //then
        Member findMember = memberService.findOne(member.getId()).get();
        Assertions.assertEquals(member, findMember);
        System.out.println("join test");
    }

    @Test
    void findMembers(){
        
    }

    @Test
    void findOne(){

    }
}
