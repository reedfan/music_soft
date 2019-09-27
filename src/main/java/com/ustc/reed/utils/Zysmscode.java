package com.ustc.reed.utils;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.http.HttpRequest;



public class Zysmscode {
    public static String sms(String mobile,String smscode) throws Exception {
        String url = "http://api.mix2.zthysms.com/v2/sendSmsTp";
//		String url = "http://hy.mix2.zthysms.com/sendSms.do";
        JSONObject json = new JSONObject();
        //获取时间戳
        String timestr=String.valueOf(System.currentTimeMillis()/1000);
        //生成密码加密
        String pwd = MD5.string2MD5(String.valueOf(MD5.string2MD5("esJTjPB6"))+timestr);
        System.out.println("pwd:"+timestr);
        //编辑短信手机号和验证码
        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();
        json2.put("var1", smscode);
        json1.put("mobile", mobile);
        json1.put("tpContent", json2);

        json.put("tpId", "713");
        json.put("username", "fywhhy");
        json.put("password", pwd);
        json.put("records", json1.toString());
        System.out.println(json1.toJSONString());
        json.put("signature", "【小白赚钱】");
        System.out.println("ti   "   +timestr);
        json.put("tKey", timestr);
        return "";

//        System.out.println("json:"+json.toString());
//
//        String result = HttpRequest.post(url, json.toString(), "utf-8");
//
//        System.out.println(result);
//
//        JSONObject jsStr = JSONObject.fromObject(result);
//
//        System.out.println(jsStr.get("code"));

       // return jsStr.get("code").toString();
    }
    public static void main(String[] args) throws Exception {
        //普通短信
        String mobile = "18663223225";
        int code = (int) (Math.random() * 9000 + 1000);
        String smscode = String.valueOf(code);
        //System.out.println(smscode);
        String map = sms(mobile,smscode);
        System.out.println("====="+map);
    }
}
