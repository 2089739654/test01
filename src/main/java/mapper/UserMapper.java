package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {
    int selectByIdPassword(@Param("id") String id,@Param("password") Integer password);

    int deleteByIdPassword(@Param("id") String id,@Param("password") Integer password);

    int insert(User user);
}
