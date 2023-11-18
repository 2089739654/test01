package service;

import pojo.Client;

public interface ClientService {
    public Client QueryClient(String identity,String name,String phone);
    public int AddClient(Client client);


}
