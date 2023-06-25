package com.milotnt.mapper;

import com.milotnt.pojo.ClassTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassTableMapper {

    //Find all courses
    List<ClassTable> findAll();

    //delete class by id
    Boolean deleteClassByClassId(Integer classId);

    //add course
    Boolean insertClass(ClassTable classTable);

    //Query the class schedule by id
    ClassTable selectByClassId(Integer classId);

    //Delete reserved courses according to id
    Boolean deleteOrderByClassId(Integer classId);

}
