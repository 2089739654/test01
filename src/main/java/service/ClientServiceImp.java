package service;

import mapper.ClientMapper;
import mapper.PortMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Client;
import utils.SqlSessionUtil;



@Transactional
@Service("ClientServiceImp")
public class ClientServiceImp implements ClientService{
    @Autowired
    private ClientMapper mapper;
    public Client QueryClient(String identity, String name, String phone) {
        return mapper.selectByIdentityNamePhone(identity, name, phone);
    }

    public int AddClient(Client client) {
        return mapper.insert(client);
    }
}
