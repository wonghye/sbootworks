package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.shop.constant.Role;
import com.shop.dto.MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="member_id")
	private Long id;
	
	private String name;
	
	//중복 체크
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String address;
	
	//문자형으로 출력
	@Enumerated(EnumType.STRING)
	private Role role;
	
	//회원 생성 메소드
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		//비밀번호 암호화
		String password = passwordEncoder.encode(memberFormDto.getPassword());
		member.setPassword(password);
		member.setAddress(memberFormDto.getAddress());
		member.setRole(Role.USER);
		
		return member;
	}
}
