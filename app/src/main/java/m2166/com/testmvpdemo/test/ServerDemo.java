package m2166.com.testmvpdemo.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class ServerDemo {
    public String getSign(Map<String,String> params,String secret){
        Set<String> sets = params.keySet();
        List<String> list = new ArrayList<String>();
        for(String str : sets) {
            list.add(str);
        }

        Object[] obj = new Object[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            obj[i] = list.get(i);
        }
        Arrays.sort(obj);

//		for (String in : params.keySet()) {
//		// map.keySet()返回的是所有key的值
//		String str = params.get(in);// 得到每个key多对用value的值
//	}pay_time' => 1502683407,
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < obj.length ; i++) {
            if(i == obj.length -1) {
                try {
                    sb.append(obj[i]+"="+ URLEncoder.encode(params.get(obj[i]), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else{
                try {
                    sb.append(obj[i]+"="+URLEncoder.encode(params.get(obj[i]), "UTF-8")+"&");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        sb.append(secret);
        String md5 = EncryptUtils.md5(sb.toString()).toLowerCase();
        try {
            String base64 = Base64Encode.encode(md5.getBytes("UTF-8"));
            String sign = URLEncoder.encode(base64, "UTF-8");
            return sign;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
