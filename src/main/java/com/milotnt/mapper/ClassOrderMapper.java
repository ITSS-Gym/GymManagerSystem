package com.milotnt.mapper;

import com.milotnt.pojo.ClassOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassOrderMapper {

    // Query all registration form information
    List<ClassOrder> findAll();

    // Add registration information
    Boolean insertClassOrder(ClassOrder classOrder);

    // Query the personal registration schedule according to the member account
    List<ClassOrder> selectClassOrderByMemberAccount(Integer memberAccount);

    // Delete a reserved class
    Boolean deleteByClassOrderId(Integer classOrderId);

    // Check if the member is enrolled in the course
    ClassOrder selectMemberByClassIdAndMemberAccount(Integer classId, Integer memberAccount);

    // Query all registered members according to the course id
    List<ClassOrder> selectMemberOrderList(Integer classId);

    Boolean updateStatusByOrderId(Integer classOrderId);

    Boolean deleteOrderByOrderId(Integer classOrderId);
}
