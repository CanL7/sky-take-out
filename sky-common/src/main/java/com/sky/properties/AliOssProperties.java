package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.alioss")
@Data
public class AliOssProperties {

    //从配置类中获取属性
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

}
