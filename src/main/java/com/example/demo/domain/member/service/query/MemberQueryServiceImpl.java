package com.example.demo.domain.member.service.query;

import com.example.demo.domain.member.exception.MemberException;
import com.example.demo.domain.member.exception.code.MemberErrorCode;
import com.example.demo.domain.test.exception.TestException;
import com.example.demo.domain.test.exception.code.TestErrorCode;

public class MemberQueryServiceImpl implements MemberQueryService {
    @Override
    public void checkFlag(Long flag) {
        if(flag==1){
            throw new MemberException(MemberErrorCode.NOT_FOUND);
        }
    }
}
