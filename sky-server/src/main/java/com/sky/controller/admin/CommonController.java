package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public Result<String> upload(MultipartFile file) {
      log.info("上传文件: {}", file);

      try {
          String originalFilename = file.getOriginalFilename();
          assert originalFilename != null;
          String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
          // 使用uuid对上传的文件进行重命名，这是为了防止重名导致的文件覆盖
          String objectName = UUID.randomUUID() + extension;

          String filePath = aliOssUtil.upload(file.getBytes(), objectName);

          return Result.success(filePath);

      } catch (Exception e) {
          log.error("上传文件失败: {}", e.getMessage());
      }


      return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
