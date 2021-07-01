package com.yasinymous.ecarbuy.filestore.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("buycar.s3")
public class S3ConfigProperties {
    private String url;
    private String accessKey;
    private String secretKey;
    private String bucket;
}
