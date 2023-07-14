package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserMapper {
    int insertUser();

    User getUserById(Integer id);

    User checkLogin(@Param("username") String username, @Param("password") String password);

    List<User> getAllUser();
}
