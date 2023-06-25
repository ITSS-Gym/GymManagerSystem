package com.milotnt.service;

import com.milotnt.pojo.ClassTable;

import java.util.List;

public interface ClassTableService {

    // Find all courses
    List<ClassTable> findAll();

    // Delete class by id
    Boolean deleteClassByClassId(Integer classId);

    // Add course
    Boolean insertClass(ClassTable classTable);

    // Query the class schedule by id
    ClassTable selectByClassId(Integer classId);

    // Delete reserved courses according to id
    Boolean deleteOrderByClassId(Integer classId);

}
