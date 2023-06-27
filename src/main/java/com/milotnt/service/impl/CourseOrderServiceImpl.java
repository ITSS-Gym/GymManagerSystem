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
    public Boolean deleteByCourseOrderId(Integer courseOrderId) {
        return courseOrderMapper.deleteByCourseOrderId(courseOrderId);
    }

    @Override
    public CourseOrder selectMemberByCourseIdAndMemberAccount(Integer courseId, Integer memberAccount) {
        return courseOrderMapper.selectMemberByCourseIdAndMemberAccount(courseId, memberAccount);
    }

    @Override
    public List<CourseOrder> selectMemberOrderList(Integer courseId) {
        return courseOrderMapper.selectMemberOrderList(courseId);
    }

    @Override
    public Boolean updateStatusByOrderId(Integer courseOrderId) {
        return courseOrderMapper.updateStatusByOrderId(courseOrderId);
    }

    public Boolean deleteOrderByOrderId(Integer courseOrderId) {
        return courseOrderMapper.deleteOrderByOrderId(courseOrderId);
    }
}
