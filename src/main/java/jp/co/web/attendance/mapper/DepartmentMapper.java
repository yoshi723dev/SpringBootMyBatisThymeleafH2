package jp.co.web.attendance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.web.attendance.domain.Department;

@Mapper
public interface DepartmentMapper {

    List<Department> findAll();

}
