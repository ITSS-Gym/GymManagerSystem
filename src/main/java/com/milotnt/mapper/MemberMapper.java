package com.milotnt.mapper;

import com.milotnt.pojo.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    // Query member information
    List<Member> findAll();

    // Add member information
    Boolean insertMember(Member member);

    // Modify member information according to member account
    Boolean updateMemberByMemberAccount(Member member);

    // Query member account password
    Member selectByAccountAndPassword(Member member);

    // Delete member information based on member account
    Boolean deleteByMemberAccount(Integer memberAccount);

    // Query the number of members
    Integer selectTotalCount();

    // Query members according to member account number
    List<Member> selectByMemberAccount(Integer memberAccount);

}