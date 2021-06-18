package cn.xdf.shudu.ocr;

import java.net.URLEncoder;

/**
 * author:fumm
 * Date : 2021/ 06/ 18 11:34 AM
 * Dec : TODO
 **/
public class Numbers {

    public static String numbers() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/numbers";
        try {
            // 本地文件路径
            String filePath = "[本地文件路径]";
            //byte[] imgData = FileUtil.readFileByBytes(filePath);
            byte[] imgData=new byte[]{};
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
