package com.template.auth.server.service.impl;

import com.template.auth.server.bean.ClientInfo;
import com.template.auth.server.entity.Client;
import com.template.auth.server.mapper.ClientMapper;
import com.template.auth.server.service.AuthClientService;
import com.template.auth.server.util.ClientTokenUtil;
import com.template.common.exception.auth.ClientInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouRunBin
 * Date: 2018/4/5 0005
 * Time: 2:51
 * Description:
 */
@Service
public class DBAuthClientService implements AuthClientService {

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientTokenUtil clientTokenUtil;

    @Override
    public String apply(String clientId, String secret) throws Exception {
        Client client = getClient(clientId, secret);
        return clientTokenUtil.generateToken(new ClientInfo(client.getCode(),client.getName(),client.getId().toString()));

    }

    @Override
    public List<String> getAllowedClient(String serviceId, String secret) {
        Client info = this.getClient(serviceId, secret);
        List<String> clients = clientMapper.selectAllowedClient(info.getId() + "");
        if(clients==null) {
            new ArrayList<String>();
        }
        return clients;
    }

    @Override
    public List<String> getAllowedClient(String clientId) {
        Client info = getClient(clientId);
        List<String> clients = clientMapper.selectAllowedClient(clientId);
        if (clients == null) {
            new ArrayList<String>();
        }
        return clients;
    }

    private Client getClient(String clientId, String secret) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)) {
            throw new ClientInvalidException("Client "+clientId+" not found or Client secret is error!");
        }
        return client;
    }

    private Client getClient(String clientId) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        return client;
    }

    @Override
    public void registryClient() {

    }

    @Override
    public void validate(String clientId, String secret) throws Exception {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)) {
            throw new ClientInvalidException("Client "+clientId+" not found or Client secret is error!");
        }
    }
}
