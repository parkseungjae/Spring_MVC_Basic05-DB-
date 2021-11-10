package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;

	@Override
	public int userChk(String id, String pw) {
		MemberDTO dto = mapper.userChk(id);
		if (dto != null) {
			if (pw.equals(dto.getPw())) {
				return 0;
			}
		}
		return 1;
	}

	@Override
	public void memberInfo(Model model) {
		model.addAttribute("memberList", mapper.memberInfo());
	}

	@Override
	public void info(Model model, String id) {
		model.addAttribute("info", mapper.userChk(id));
	}

	@Override
	public int register(MemberDTO dto) {
		int result = 0;
		String msg = "";
		//사용자가 알 수 없는 오류 표시 대체
		try {
			result = mapper.register(dto);
			msg = "회원가입에 성공했습니다";

		} catch (Exception e) {
			msg = "동일한 아이디가 존재합니다";
			//개발자 콘솔 확인
			e.printStackTrace();
		}
		return result;
	}

}
