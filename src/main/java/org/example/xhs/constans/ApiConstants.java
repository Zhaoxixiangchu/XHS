package org.example.xhs.constans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiConstants {

    @Value("${api.xhs}")
    public String xhsApi;

}
