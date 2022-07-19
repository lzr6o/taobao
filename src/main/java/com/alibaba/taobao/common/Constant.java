package com.alibaba.taobao.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * 描述：常量值
 */
public class Constant {
    public static final String ALIBABA_TAOBAO_USER = "alibaba_taobao_user";
    public static final String SALT = "8svbsvjkweDF,.03[";

    @Value("${file.upload.dir}")
    public static String FILE_UPLOAD_DIR;
}
