package org.example.xhs.constans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StorageConstants {

    @Value("${storage.type}")
    public String storageType;

    @Value("${storage.local-path}")
    public String storageLocalPath;
}
