package service;

import mapper.PortMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Port;
import utils.SqlSessionUtil;

import java.util.*;

@Transactional
@Service("ImOutServiceImp")
public class ImOutServiceImp implements ImOutService{
    @Autowired
    private PortMapper portMapper;
    public int[] SelectNum(String name, String dateOn, String dateOff){
        List<Port> listIm = portMapper.selectByNameDatePort(name,dateOn,dateOff,null,"入库");
        List<Port> listOut = portMapper.selectByNameDatePort(name,dateOn,dateOff,null,"出库");
        int []result =new int[2];
        result[0]=listIm.size();
        result[1]=listOut.size();
        return result;
    }


    public Map<String,Integer[]> QueryGoods(String name,String dateOn, String dateOff,String lading_id){
        List<Port> list = portMapper.selectByNameDatePort(name,dateOn,dateOff,lading_id,null);
        Map<String,Integer[]> result=new TreeMap<>();
        for (Port port:list
             ) {
            Integer[] i= {0,0};
            if(!result.containsKey(port.getAction_date())){
                result.put(port.getAction_date(),i);
            }
            i=result.get(port.getAction_date());
            if(port.getAction().equals("入库")){
                i[0]++;
            }else {
                i[1]++;
            }
            result.put(port.getAction_date(),i);
        }
        return result;
    }


    public double QueryScale(String name,String dateOn, String dateOff){
        int total = portMapper.selectAll(dateOn,dateOff);
        List<Port> list = portMapper.selectByNameDatePort(name, dateOn, dateOff, null, null);
        return (double) list.size() /total;
    }

    public Map<String,Integer[]> QueryLogistics(String lading_id){
        List<Port> list = portMapper.selectByNameDatePort(null, null, null, lading_id, null);
        Map<String,Integer[]> result =new HashMap<>();
        for (Port port:list
        ) {
            Integer[] i={0,0};
            if(!result.containsKey(port.getPort_name())){
                result.put(port.getPort_name(),i);
            }
            i=result.get(port.getPort_name());
            if(port.getAction().equals("入库")){
                i[0]++;
            }else {
                i[1]++;
            }
            result.put(port.getPort_name(),i);
        }
        return result;
    }

    public int insert(Port port) {
        return portMapper.insert(port);
    }

    public int update(Port port) {
        return  portMapper.update(port);
    }

    public int delete(Port port) {
        return portMapper.delete(port);
    }

}
