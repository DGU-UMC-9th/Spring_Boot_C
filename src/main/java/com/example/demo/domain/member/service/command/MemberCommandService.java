package com.example.demo.domain.member.service.command;

import com.example.demo.domain.member.dto.req.MemberReqDTO;
import com.example.demo.domain.member.dto.res.MemberResDTO;

public interface MemberCommandService {

    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    );
}
