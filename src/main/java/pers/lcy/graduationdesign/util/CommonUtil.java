package pers.lcy.graduationdesign.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;

public class CommonUtil {
    public static Logger logger= LoggerFactory.getLogger(CommonUtil.class);

    public static final String[] imageExt=new String[]{"png","jpg","jpeg","bmp"};

    public static String Domain="http://127.0.0.1:8080/";

    public static String QiniuDomain="http://qj95rst59.hn-bkt.clouddn.com/";

    public static String HeadUrlPre="http://qj95rst59.hn-bkt.clouddn.com/touxiang";

    public static String ImageStorePath="D:/toutiaoImage/";

    public static String NewsTitleNormalRegex="[\\u4e00-\\u9fa5a-zA-Z0-9]+";

    public static String MinganRegex="[\\S]*(杀人|鬼|淫|奸)+[\\S]*";

    public static String LinkRegex="(http|ftp)(s)?://(\\w)+(\\.\\w+)+(/[\\w_\\?\\.&=%-]*)*";

    public static String getJsonString(int code){
        JSONObject jsonObejct=new JSONObject();
        jsonObejct.put("code",code);
        return  jsonObejct.toJSONString();
    }

    public static String getJsonString(int code,String msg){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        return  jsonObject.toJSONString();
    }

    public static String getJsonString(int code, Map<String,Object> map){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",code);
        for(Map.Entry<String,Object> entry:map.entrySet()){
            jsonObject.put(entry.getKey(),entry.getValue());
        }
        return  jsonObject.toJSONString();
    }

    public static boolean isFileAllowed(String fileExt){
        for (String ext:imageExt
             ) {
            if(fileExt.equals(ext)){
                return true;
            }
        }
        return false;
    }

    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            logger.error("生成MD5失败", e);
            return null;
        }
    }

    public static String getUserHeadUrl(){
        return HeadUrlPre+(new Random().nextInt(6)+1)+".jpg";
    }
}
