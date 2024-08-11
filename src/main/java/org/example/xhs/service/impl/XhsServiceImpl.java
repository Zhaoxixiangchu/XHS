package org.example.xhs.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.example.xhs.constans.ApiConstants;
import org.example.xhs.constans.StorageConstants;
import org.example.xhs.entity.req.ParseParam;
import org.example.xhs.entity.req.ProductResource;
import org.example.xhs.exception.ApiException;
import org.example.xhs.service.IAuthorService;
import org.example.xhs.service.IProductResourceService;
import org.example.xhs.service.IProductService;
import org.example.xhs.service.IXhsService;
import org.example.xhs.utils.DownloadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class XhsServiceImpl implements IXhsService {

    @Autowired
    private StorageConstants storageConstants;

    @Autowired
    private ApiConstants apiConstants;

    @Autowired
    private DownloadUtil downloadUtil;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductResourceService productResourceService;

    @Override
    public JSONObject parseResult(ParseParam parseParam) {
        if (StringUtils.isEmpty(parseParam.getUrl())){
            throw new ApiException("地址不能为空");
        }
        JSONObject result = new JSONObject();
        try {
            String resultBody = HttpRequest.post(apiConstants.xhsApi).body(JSON.toJSONString(parseParam)).execute().body();
            result = JSONObject.parseObject(resultBody);
            Integer code = result.getInteger("code");
            if (code == 200){
                String url = result.getString("url");
                JSONObject data = result.getJSONObject("data");
                data.put("url", url);
                String productTitle = data.getString("productTitle");
                String productId = data.getString("productId");
                String authorNickName = data.getString("authorNickName");

                /*String productUrl = data.getString("productUrl");

                String productTags = data.getString("productTags");
                String productDesc = data.getString("productDesc");
                String productType = data.getString("productType");
                Date publishedTime = data.getDate("publishedTime");
                Date lastUpdateDate = data.getDate("lastUpdateDate");
                String authorName = data.getString("authorName");
                String authorId = data.getString("authorId");
                Integer favoriteCount = data.getInteger("favoriteCount");
                Integer likeCount = data.getInteger("likeCount");
                Integer shareCount = data.getInteger("shareCount");
                Integer commentCount = data.getInteger("commentCount");*/

                authorService.insert(data);
                productService.insert(data);

                //保存资源
                JSONArray downloadObject = data.getJSONArray("downloadUrl");
                JSONArray dynamicObject = data.getJSONArray("dynamicPhotoUrl");

                for (int i = 0; i < dynamicObject.size(); i++) {
                    if (!StringUtils.isEmpty(dynamicObject.get(i))){
                        downloadObject.add(dynamicObject.get(i));
                    }
                }

                List<ProductResource> list = new ArrayList<>();
                for (int i = 0; i < downloadObject.size(); i++) {
                    String downloadUrl = downloadObject.getString(i);
                    ProductResource productResource = new ProductResource();
                    productResource.setProductId(productId);
                    productResource.setProductTitle(productTitle);
                    productResource.setDownloadUrl(downloadUrl);
                    productResource.setCreateDate(new Date());
                    list.add(productResource);
                }
                CompletableFuture.runAsync(() ->{
                    String storageLocalPath = authorNickName + FileUtil.FILE_SEPARATOR + productTitle;
                    for (int i = 0; i < list.size(); i++) {
                        String downloadUrl = list.get(i).getDownloadUrl();
                        String fileName = downloadUrl.contains(".mp4") ? productTitle + "_" + i + ".mp4" : productTitle + "_" + i + ".png";
                        downloadUtil.download(downloadUrl, fileName, storageLocalPath);
                    }
                    log.info("下载完成，共计:{}个文件", CollectionUtils.isEmpty(list) ? 0 : list.size());
                });
                productResourceService.deleteByProductId(productId);
                productResourceService.insert(list);
            }
        }catch (Exception e){
            log.error("请求错误: {}", e);
        }
        return result;
    }
}
