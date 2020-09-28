package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

public class MemberService {
    
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){

        memberRepository.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("invalid member name!");
        });
        
        memberRepository.save(member);
        return member.getId();
    }


    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }
}
