package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Client;

public interface ClientMapper {
    public int insert(Client client);
    public Client selectByIdentityNamePhone(@Param("identity") String identity,@Param("name") String name,@Param("phone") String phone);


}
