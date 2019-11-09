package com.dol.school.service.impl;

import com.dol.school.common.utils.VCodeUtils;
import com.dol.school.service.api.IVerificationService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @description: 实现验证码
 * @author: YaoGuangXun
 * @date: 2019/6/29 16:47
 */
@Service
public class VerificationService implements IVerificationService {

    @Override
    public void getVerificationCode(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 设置响应
        // 设置发送到客户端的响应的内容类型
        response.setContentType("image/jpeg");
        // 设置浏览器禁止缓存
        response.setHeader("cache-control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires",0);

        // 创建内存图像
        char[] vCode = VCodeUtils.generateVCode();
        // 生成验证码图片
        BufferedImage image =  VCodeUtils.getVCodeImage(vCode);

        // 将图像输出到客户端
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image,"JPEG",baos);

        // 将验证码存入Session中
        HttpSession session = request.getSession();
        session.setAttribute("vcode",new String(vCode));

        byte[]  bytes = baos.toByteArray();

        response.setContentLength(bytes.length);

        ServletOutputStream stream = response.getOutputStream();

        // 下面的语句也可写成：bos.writeTo(sos);
        stream.write(bytes);
        baos.close();
        stream.close();

    }
}
