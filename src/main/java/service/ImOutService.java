package service;

import org.apache.ibatis.annotations.Param;
import pojo.Port;

import java.util.Map;

public interface ImOutService {
    public int[] SelectNum(String name, String dateOn, String dateOff);
    public Map<String,Integer[]> QueryGoods(String name, String dateOn, String dateOff, String lading_id);

    public double QueryScale(String name,String dateOn, String dateOff);
    public Map<String,Integer[]> QueryLogistics(String lading_id);

    public int insert(Port port);

    int update(Port port);

    int delete(Port port);
}
