package com.example.serverappv1;

import com.example.serverappv1.enumeration.Status;
import com.example.serverappv1.model.Server;
import com.example.serverappv1.repository.ServerRepository;
import com.example.serverappv1.service.ServerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class ServerAppV1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServerAppV1Application.class, args);

    }



//    @Bean
//    CommandLineRunner run(ServerService serverService){
//        return args -> {
//            serverService.create(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC",
//                    "http://localhost:6868/server/image/server1.png", Status.SERVER_UP));
//            serverService.create(new Server(null, "192.168.1.58", "Fedora Linux", "16 GB", "Dell Tower",
//                    "http://localhost:6868/server/image/server2.png", Status.SERVER_UP));
//            serverService.create(new Server(null, "192.168.1.21", "NS 2008", "32 GB", "Web server",
//                    "http://localhost:6868/server/image/server3.png", Status.SERVER_DOWN));
//            serverService.create(new Server(null, "192.168.1.14", "Red hat enterprise Linux", "64 GB", "Mail server",
//                    "http://localhost:6868/server/image/server4.png", Status.SERVER_UP));
//        };
//    }


//    @Bean
//    public CorsFilter corsFilter(){
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
//        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//        "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Requested-Method",
//                "Access-Control-Requested-Headers"));
//
//        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//                "Accept", "Jwt-Token", "Authorization", "Access-Control-Allow-Credentials", "Filename"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }


}
