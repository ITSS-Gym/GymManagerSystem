package com.milotnt.service.impl;

import com.milotnt.mapper.CourseOrderMapper;
import com.milotnt.pojo.CourseOrder;
import com.milotnt.service.CourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseOrderServiceImpl implements CourseOrderService {

    @Autowired
    private CourseOrderMapper courseOrderMapper;

    @Override
    public List<CourseOrder> findAll() {
        return courseOrderMapper.findAll();
    }

    @Override
    public Boolean insertCourseOrder(CourseOrder courseOrder) {
        return courseOrderMapper.insertCourseOrder(courseOrder);
    }

    @Override
    public List<CourseOrder> selectCourseOrderByMemberAccount(Integer memberAccount) {
        return courseOrderMapper.selectCourseOrderByMemberAccount(memberAccount);
    }

    @Override
    public Boolean deleteByCourseOrderId(Integer classOrderId) {
        return courseOrderMapper.deleteByCourseOrderId(classOrderId);
    }

    @Override
    public CourseOrder selectMemberByCourseIdAndMemberAccount(Integer classId, Integer memberAccount) {
        return courseOrderMapper.selectMemberByCourseIdAndMemberAccount(classId, memberAccount);
    }

    @Override
    public List<CourseOrder> selectMemberOrderList(Integer classId) {
        return courseOrderMapper.selectMemberOrderList(classId);
    }

    @Override
    public Boolean updateStatusByOrderId(Integer classOrderId) {
        return courseOrderMapper.updateStatusByOrderId(classOrderId);
    }

    public Boolean deleteOrderByOrderId(Integer classOrderId) {
        return courseOrderMapper.deleteOrderByOrderId(classOrderId);
    }
}
