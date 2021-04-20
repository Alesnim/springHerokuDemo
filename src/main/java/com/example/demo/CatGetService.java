package com.example.demo;


import com.example.demo.model.CatImage;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;

@Service
public class CatGetService {
    @Autowired
    private WebClient webClient;


    public Mono<CatImage> getUserByIdAsync() {
        return webClient
                .get()
                .uri("https://cataas.com/cat?json=true")
                .retrieve()
                .bodyToMono(CatImage.class);
    }


}
