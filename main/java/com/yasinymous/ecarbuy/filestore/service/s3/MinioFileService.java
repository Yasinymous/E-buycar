package com.yasinymous.ecarbuy.filestore.service.s3;

import com.yasinymous.ecarbuy.filestore.config.S3ConfigProperties;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class MinioFileService implements FileService {

    private final MinioClient minioClient;
    private final S3ConfigProperties properties;

    @Override
    public void save(String id, String contentType, InputStream isFile) {

        try {
            var object = PutObjectArgs.builder()
                    .object(id)
                    .contentType(contentType)
                    .stream(isFile, isFile.available(), -1)
                    .bucket(properties.getBucket())
                    .build();
            minioClient.putObject(object);
        }catch (Exception e){
            log.error("",e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(id)
                    .build());
            }catch (Exception e){
            log.error("File Delete",e);
        }
    }

    @Override
    public byte[] get(String id) {
        try {
            return  minioClient.getObject(GetObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(id)
                    .build()).readAllBytes();
        }catch (Exception e){
            log.error("File Get",e);
        }
        return new byte[0];
    }
}
