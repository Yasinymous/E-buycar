package com.yasinymous.ecarbuy.filestore.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStoreService {

    public Mono<byte[]> getImage(String id) throws IOException {
        File file = ResourceUtils.getFile("classpath:docs/xx.svg");
        return Mono.just(Files.readAllBytes(file.toPath()));
    }

}
