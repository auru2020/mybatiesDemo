package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface SpecialSqlMapper {

    List<User> selectUserByName(@Param("nameLike") String nameLike);

}
