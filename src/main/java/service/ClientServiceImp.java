package service;

import mapper.ClientMapper;
import mapper.PortMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Client;
import utils.SqlSessionUtil;

public class ClientServiceImp implements ClientService{
    public Client QueryClient(String identity, String name, String phone) {
        SqlSession sqlSession= SqlSessionUtil.GetSqlSession();
        ClientMapper mapper=sqlSession.getMapper(ClientMapper.class);
        Client client = mapper.selectByIdentityNamePhone(identity, name, phone);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return client;
    }

    public int AddClient(Client client) {
        SqlSession sqlSession= SqlSessionUtil.GetSqlSession();
        ClientMapper mapper=sqlSession.getMapper(ClientMapper.class);
        int counter = mapper.insert(client);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return counter;
    }
}
