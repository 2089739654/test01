package service;

import java.util.Map;

public interface ImOutService {
    public int[] SelectNum(String name, String dateOn, String dateOff);
    public Map<String,Integer[]> QueryGoods(String name, String dateOn, String dateOff, String lading_id);

    public double QueryScale(String name,String dateOn, String dateOff);
    public Map<String,Integer[]> QueryLogistics(String lading_id);
}
