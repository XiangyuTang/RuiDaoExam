package com.neuedu.ruidaoexam.configUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * 人脸检测与属性分析
 */
public class FaceDetect {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String detect() {
        // 请求url
        //String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";//人脸识别
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";//人脸对比
        
        try {
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> map1 = new HashMap<>();
            byte[] bytes = FileUtil.readFileByBytes("C:\\myEclipseProjects\\RuiDaoExam\\src\\main\\resources\\static\\images\\1.jpg");
            String img1 = Base64Util.encode(bytes);
            byte[] bytes1 = FileUtil.readFileByBytes("C:\\myEclipseProjects\\RuiDaoExam\\src\\main\\resources\\static\\images\\2.jpg");
            String img2 = Base64Util.encode(bytes1);
            String img = img1+","+img2;
            map.put("image", img);
            
            //map.put("face_field", "faceshape,facetype");
            //map.put("image_type", "BASE64");

            String param = GsonUtils.toJson(map);
            //String param2 = GsonUtils.toJson(map1);
            
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.d04e818295c4494ce63dc3c9ecabb900.2592000.1564293538.282335-16588810";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        detect();
    }
}
