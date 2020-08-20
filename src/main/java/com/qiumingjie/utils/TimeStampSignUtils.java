package com.qiumingjie.utils;

import cn.org.bjca.client.security.SecurityEngineDeal;

/**
 * @author QiuMingJie
 * @date 2020-08-13 16:07
 * @description 时间戳签名工具类
 */
public class TimeStampSignUtils {

    private static SecurityEngineDeal sed = null;
    //原文数据
    private static String inData = null;
    //时间戳请求
    private static String timeRequest = null;
    //时间戳
    private static String timeStamp = null;


    private static void init() throws Exception {
        //实例化对象
        SecurityEngineDeal.setProfilePath("C:\\BJCAROOT"); //读取配置文件里面文件
        sed = SecurityEngineDeal.getInstance("TSSDefault");
        //原文数据
    }

    /**
     * 生成时间戳请求
     * @param originalData 原文数据
     * @return 时间戳数据
     * @throws Exception
     */
    public static String createTimeStamp(String originalData) throws Exception {
        init();
        //生成时间戳请求
        String timeRequest = sed.createTSRequest(originalData.getBytes(), true);
        System.out.println("时间戳请求数据：" + timeRequest);
        //生成时间戳
        String timeStamp = sed.createTS(timeRequest);
        System.out.println("时间戳数据：" + timeStamp);
        return timeStamp;
    }

    public static void  testGetTssInfo() throws Exception {
        String tssTime = null;
        String inDataHash = null;
        String serverCert = null;
        String certSerialNumbe = null;
        //解析时间戳时间
        tssTime = sed.getTSInfo(timeStamp, 1);
        System.out.println("时间：" + tssTime);
        //解析时间戳原文hash
        inDataHash = sed.getTSInfo(timeStamp, 2);
        System.out.println("原文hash：" + inDataHash);
        //解析时间戳签名证书
        serverCert = sed.getTSInfo(timeStamp, 3);
        System.out.println("签名证书：" + serverCert);

        //服务器证书序列号
        certSerialNumbe = sed.getTSInfo(timeStamp, 4);
        System.out.println("服务器证书序列号：" + certSerialNumbe);
    }

    /**
     *
     * @param timeStamp 时间戳数据
     * @param originalData 原始数据
     * @return
     * @throws Exception
     */
    public static String verifyTss(String timeStamp,String originalData) throws Exception {
        //原文如果为空则表示不验证原文。
        int verifyRes = sed.verifyTS(timeStamp, originalData.getBytes());
        //1 为时间戳有效，-1 为时间戳验证不通过，-2 为原文验证不通过，-3 为不是所信任的根，-4 证书未生效，-5 查询不到此证书，-6 为签发时间戳时服务器证书过期。
        System.out.println(verifyRes);
        switch (verifyRes) {
            case 1:
                return "1";
            case -1:
                return "时间戳验证不通过";
            case -2:
                return "原文验证不通过";
            case -3:
                return "不是所信任的根";
            case -4:
                return "证书未生效";
            case -5:
                return "查询不到此证书";
            default:
                return "签发时间戳时服务器证书过期";
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        String original = "321";
        //生成时间戳
        String timeStamp = TimeStampSignUtils.createTimeStamp(original);
        //解析时间戳
//        TimeStampSignUtils.testGetTssInfo();
        //验证时间戳
        TimeStampSignUtils.verifyTss(timeStamp,original);
    }

}
