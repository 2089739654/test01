package service;

import mapper.PortMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Port;
import utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImOutServiceImp implements ImOutService{
    public int[] SelectNum(String name, String dateOn, String dateOff){
        SqlSession sqlSession=SqlSessionUtil.GetSqlSession();
        PortMapper portMapper=sqlSession.getMapper(PortMapper.class);

        List<Port> listIm = portMapper.selectByNameDatePort(name,dateOn,dateOff,null,"入库");
        List<Port> listOut = portMapper.selectByNameDatePort(name,dateOn,dateOff,null,"出库");
        int []result =new int[2];
        result[0]=listIm.size();
        result[1]=listOut.size();

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return result;
    }


    public Map<String,Integer[]> QueryGoods(String name,String dateOn, String dateOff,String lading_id){
        SqlSession sqlSession=SqlSessionUtil.GetSqlSession();
        PortMapper portMapper=sqlSession.getMapper(PortMapper.class);

        List<Port> list = portMapper.selectByNameDatePort(name,dateOn,dateOff,lading_id,null);
        Map<String,Integer[]> result=new HashMap<>();
        for (Port port:list
             ) {
            Integer[] i=new Integer[2];
            if(result.containsKey(port.getAction_date())){
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
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return result;
    }


    public double QueryScale(String name,String dateOn, String dateOff){
        SqlSession sqlSession=SqlSessionUtil.GetSqlSession();
        PortMapper portMapper=sqlSession.getMapper(PortMapper.class);

        int total = portMapper.selectAll();
        List<Port> list = portMapper.selectByNameDatePort(name, dateOn, dateOff, null, null);

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return (double) list.size() /total;
    }

    public Map<String,Integer[]> QueryLogistics(String lading_id){
        SqlSession sqlSession=SqlSessionUtil.GetSqlSession();
        PortMapper portMapper=sqlSession.getMapper(PortMapper.class);

        List<Port> list = portMapper.selectByNameDatePort(null, null, null, lading_id, null);
        Map<String,Integer[]> result =new HashMap<>();
        for (Port port:list
        ) {
            Integer[] i=new Integer[2];
            if(result.containsKey(port.getPort_name())){
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
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return result;
    }





}
