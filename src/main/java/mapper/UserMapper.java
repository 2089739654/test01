package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {
    User selectById(@Param("id") String id);

    int deleteById(@Param("id") String id);

    int insert(User user);
}
