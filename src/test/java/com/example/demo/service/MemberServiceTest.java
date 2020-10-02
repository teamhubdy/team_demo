package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach(){
        memberRepository=new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

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
    void 중복회원가입(){
        // given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        Assertions.assertEquals("invalid member name!", e.getMessage());
        
        // then

    }

    @Test
    void findMembers(){
        
    }

    @Test
    void findOne(){

    }
}
