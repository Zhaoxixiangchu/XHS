package org.example.xhs.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import io.github.artislong.core.StandardOssClient;
import io.github.artislong.core.minio.MinioOssConfiguration;
import io.github.artislong.model.OssInfo;
import lombok.extern.slf4j.Slf4j;
import org.example.xhs.constans.StorageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;

@Slf4j
@Component
public class DownloadUtil {


    @Autowired
    private StorageConstants storageConstants;

    @Autowired
    @Qualifier(MinioOssConfiguration.DEFAULT_BEAN_NAME)
    private StandardOssClient ossClient;

    public void download(String url, String fileName, String path){
        String storageType = storageConstants.storageType;
        String storagePath = storageConstants.storageLocalPath + FileUtil.FILE_SEPARATOR + path+ FileUtil.FILE_SEPARATOR + fileName;
        log.info("正在下载文件: {}", fileName);
        File file = FileUtil.file(storagePath);
        HttpUtil.downloadFile(url, file);
        log.info("文件：{}, 下载完成，存储路径为: {}", fileName, storagePath);

        if (!StringUtils.isEmpty(storageType) && !"LOCAL".equals(storageType)){
            //存到对象存储
            try {
                String bucketStoragePath = path+ FileUtil.FILE_SEPARATOR + fileName;
                OssInfo ossInfo = ossClient.upLoad(Files.newInputStream(file.toPath()), bucketStoragePath);
                log.info("上传{}到对象存储完成, 路径为: {}", fileName, ossInfo.getPath());
            }catch (Exception e){
                log.error("上传文件失败: {}", e);
            }
        }

    }
}
