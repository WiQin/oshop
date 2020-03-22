package com.oshop.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/22
 */
public interface UploadService {

    String uploadImage(MultipartFile file);
}
