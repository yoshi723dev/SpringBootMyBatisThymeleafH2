package jp.co.web.attendance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.web.attendance.domain.User;
import jp.co.web.attendance.form.RegistForm;

@Mapper
public interface UserMapper {

    User findOne(@Param("userId") String userId, @Param("passWd") String passWd);

    List<User> find(@Param("limit") int limit, @Param("offset") int offset);

    int findAllCount();

	int insert(@Param("form") RegistForm form);

}
