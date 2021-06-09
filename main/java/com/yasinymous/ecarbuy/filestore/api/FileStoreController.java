package com.yasinymous.ecarbuy.filestore.api;


import com.yasinymous.ecarbuy.filestore.service.FileStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.lang.management.MonitorInfo;

@RestController
@RequestMapping("/filestore")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FileStoreController {

    private final FileStoreService fileStoreService;

    @GetMapping("/{id}")
    public Mono<Void> getImage(@PathVariable("id") String id, ServerWebExchange serverWebExchange) throws IOException {
        ServerHttpResponse response = serverWebExchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().setContentType(MediaType.IMAGE_JPEG);

        DataBufferFactory factory = new DefaultDataBufferFactory();
        System.out.println("xxx"+id);
        return fileStoreService.getImage(id).flatMap(img ->{
           return response.writeWith(Flux.just(factory.wrap(img)));
        });
    }

}
