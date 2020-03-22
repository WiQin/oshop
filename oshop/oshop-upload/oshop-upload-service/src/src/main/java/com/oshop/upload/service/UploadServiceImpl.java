package com.oshop.upload.service;

import com.oshop.common.exception.BizException;
import com.oshop.common.exception.ExceptionEnums;
import com.oshop.upload.constants.ImageTypeConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/22
 */
@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);
    private static final List<String> ALLOW_TYPE = Arrays.asList(ImageTypeConstants.JPG,ImageTypeConstants.PNG,ImageTypeConstants.BMP);

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            //校验文件类型
            String contentType = file.getContentType();
            if (!ALLOW_TYPE.contains(contentType)){
                throw new BizException(ExceptionEnums.INVALID_FILE_TYPE);
            }
            //校验文件内容
            //不是图片，返回为空
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null){
                throw new BizException(ExceptionEnums.INVALID_FILE_TYPE);
            }

            //1.准备本地目标路径文件
            File dest = new File("E:\\study\\oshop\\oshop\\oshop-upload\\image", file.getOriginalFilename());
            //2.保存文件到本地目标路径
            file.transferTo(dest);
            //3.返回路径
            return "http://image.oshop.com/" + file.getOriginalFilename();
        } catch (IOException e) {
            logger.error("图片上传失败", e);
            throw new BizException(ExceptionEnums.UPLOAD_ERROR);
        }

    }
}
