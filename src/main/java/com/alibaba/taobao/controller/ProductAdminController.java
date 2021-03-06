package com.alibaba.taobao.controller;

import com.alibaba.taobao.common.ApiRestResponse;
import com.alibaba.taobao.common.Constant;
import com.alibaba.taobao.exception.AlibabaTaobaoException;
import com.alibaba.taobao.exception.AlibabaTaobaoExceptionEnum;
import com.alibaba.taobao.model.request.AddProductReq;
import com.alibaba.taobao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/**
 * 描述: 后台商品管理Controller
 */
@RestController
public class ProductAdminController {

    @Autowired
    ProductService productService;

    @PostMapping("admin/product/add")
    public ApiRestResponse addProduct(@Valid @RequestBody AddProductReq addProductReq) {
        productService.add(addProductReq);
        return ApiRestResponse.success();
    }

    @PostMapping("admin/upload/file")
    public ApiRestResponse upload(HttpServletRequest httpServletRequest, @RequestParam MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 生成文件名称UUID
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid.toString() + suffixName;
        // 创建文件
        File fileDirectory = new File(Constant.FILE_UPLOAD_DIR);
        File destFile = new File(Constant.FILE_UPLOAD_DIR + newFileName);
        if (!fileDirectory.exists()) {
            if (!fileDirectory.mkdir()) {
                throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.MKDIR_FAILED);
            }
        }
        try {
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return ApiRestResponse.success(getHost(new URI(httpServletRequest.getRequestURI() + "")) + "/images/" + newFileName);
        } catch (URISyntaxException e) {
            return ApiRestResponse.error(AlibabaTaobaoExceptionEnum.UPLOAD_FAILED);
        }
    }

    private URI getHost(URI uri) {
        URI effectiveURI;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (URISyntaxException e) {
            effectiveURI = null;
        }
        return effectiveURI;
    }
}
