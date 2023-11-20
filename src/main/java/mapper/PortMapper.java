package mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import pojo.Port;

import java.util.List;


public interface PortMapper {

    int update(Port port);
    int insert(Port port);
    int deleteByNameDatePort(@Param("port_name") String name, @Param("action_date") String date);
    List<Port> selectByNameDatePort(@Param("port_name") String name, @Param("action_date_on") String dateOn,@Param("action_date_off") String dateOff, @Param("lading_id") String id,@Param("action") String action);

    int selectAll(@Param("action_date_on")String dateOn,@Param("action_date_off")String dateOff);

}
