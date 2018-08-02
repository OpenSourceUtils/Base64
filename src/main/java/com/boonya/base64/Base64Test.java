package com.boonya.base64;

/**
 * @ClassName: Base64Test
 * @Description: TODO(功能描述)
 * @author: pengjunlin
 * @company: 上海势航网络科技有限公司
 * @date 2018-07-25
 */
public class Base64Test {

    /**
     * 主函数入口
     * @param args
     */
    public static void main(String[] args) {
        String base64Code = Base64ImageUtils.getBase64Code("C:\\Users\\Administrator\\Desktop\\ocr01.jpeg");
        System.out.println(base64Code);
        Base64ImageUtils.generateImage(base64Code, "C:\\Users\\Administrator\\Desktop\\ocr00.jpeg");
    }
}
