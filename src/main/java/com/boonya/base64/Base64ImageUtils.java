package com.boonya.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.*;
/**
 * @ClassName: Base64ImageUtils
 * @Description: TODO(Base64与图片互转)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-07-25
 */
public class Base64ImageUtils {

    /**
     * 将base64编码字符串转换为图片
     * @param base64Code
     * @param outputPath
     * @return
     */
    public static boolean generateImage(String base64Code, String outputPath) {
        if (base64Code == null)
            return false;
            BASE64Decoder decoder = new BASE64Decoder();
        try {
                // 解密
                byte[] b = decoder.decodeBuffer(base64Code);
                // 处理数据
                for (int i = 0; i < b.length; ++i) {
                    if (b[i] < 0) {
                         b[i] += 256;
                    }
                 }
                OutputStream out = new FileOutputStream(outputPath);
                out.write(b);
                out.flush();
                out.close();
                return true;
        } catch (Exception e) {
             return false;
        }
    }

    /**
     * 根据图片地址转换为base64编码字符串
     * @param imagePath
     * @return
     */
    public static String getBase64Code(String imagePath) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imagePath);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

}
