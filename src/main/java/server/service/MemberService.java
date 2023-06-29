package server.service;

import server.pojo.Member;

import java.util.List;

public interface MemberService {

    // Query member information
    List<Member> findAll();

    // Add member information
    Boolean insertMember(Member member);

    // Modify member information according to member account
    Boolean updateMemberByMemberAccount(Member member);

    // Query member account password (login)
    Member userLogin(Member member);
    //Member selectByAccountAndPassword(Member member);

    // Delete member information based on member account
    Boolean deleteByMemberAccount(String memberAccount);

    // Query the number of members
    Integer selectTotalCount();

    // Query members according to member account number
    List<Member> selectByMemberAccount(String memberAccount);

}
