package com.shop.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {
	//member service 가 user details service 를 구현함
	private final MemberRepository memberRepo;	//생성자 주입 DI 방식 - 객체
	
	//회원 가입 (저장)
	public Member saveMember(Member member) {
		validateDuplicateMember(member);	// 중복 체크 메서드 호출
		return memberRepo.save(member);
	}
	
	//이메일 중복 체크 메소드
	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepo.findByEmail(member.getEmail());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	//로그인 할 유저의 email을 파라미터로 전달함 - username 을 email로 변경해줌
	//user 객체를 생성하기 위해 생성자로 회원의 이메일, 비밀번호, role을 파라미터로 넘겨줌
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepo.findByEmail(email);
		if(member == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return User.builder()
				.username(member.getEmail())
				.password(member.getPassword())
				.roles(member.getRole().toString())
				.build();
	}
}
