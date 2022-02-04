package com.example.serverappv1.service;

import com.example.serverappv1.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {

    Server create(Server server);

    Collection<Server> list(int limit);

    Server ping (String ipAddress) throws IOException;

    Server get(String id);

    Server update(Server server);

    Boolean delete(String id);
}
