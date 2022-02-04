package com.example.serverappv1.service.implementation;

import com.example.serverappv1.enumeration.Status;
import com.example.serverappv1.model.Server;
import com.example.serverappv1.repository.ServerRepository;
import com.example.serverappv1.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
    private final ServerRepository serverRepository;
    private final SequenceGeneratorService sequenceGeneratorService;


    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
//        server.setId(sequenceGeneratorService.generateSequence(Server.SEQUENCE_NAME));
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException{
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }


    @Override
    public Server get(String id) {
        log.info("Fetching server by ID: {}", id);
        return serverRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Server does not exist"));
    }

    @Override
    public Server update(Server server) {
        log.info("Updating new server: {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(String id) {
        log.info("Deleting server by ID: {}", id);
        serverRepository.deleteById(id);
        return Boolean.TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames =  {"server1.png", "server2.png", "server3.png", "server4.png"};

        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
