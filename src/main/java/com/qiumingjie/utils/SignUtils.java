package com.qiumingjie.utils;

import cn.org.bjca.client.exceptions.*;
import cn.org.bjca.client.security.SecurityEngineDeal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @author QiuMingJie
 * @date 2020-06-21 9:26
 * @description 签名工具
 */
public class SignUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(SignUtils.class);
    private static SecurityEngineDeal dsvs = null;
    private static final SignUtils signUtils = new SignUtils();

    public static SignUtils init() {
        try {
            LOGGER.info("初始化");
            //读取配置文件里面文件
            SecurityEngineDeal.setProfilePath("C:\\BJCAROOT");
            //公网测试服务器
            dsvs = SecurityEngineDeal.getInstance("SVSDefault");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signUtils;
    }

    /**
     * 获取服务器证书
     * 成功返回Base64 编码的服务器证书。出错则返回空值
     */
    public static void getServerCertificate() throws SVSConnectException {
        String serverCertificate = dsvs.getServerCertificate();
        LOGGER.info("serverCertificate:" + serverCertificate);

    }

    /**
     * 签名
     * String signData(byte[] inData);
     * 参数：
     * inData：[IN] 待签名的数据原文。
     * 返回值：
     * 成功返回 pkcs1 格式的签名值的 base64 编码。失败返回空值（NULL）
     *
     * @throws SVSConnectException
     * @throws ParameterTooLongException
     */
    public static String signData(String data) {
        String sss = null;
        try {
            sss = dsvs.signData(data);
        } catch (SVSConnectException e) {
            e.printStackTrace();
        } catch (ParameterTooLongException e) {
            e.printStackTrace();
        }
        //sss = signData;
        LOGGER.info("原文:" + data);
        LOGGER.info("签名返回值:" + sss);
        return sss;
    }


    /**
     * 验证签名
     * 函数：boolean verifySignedData(String base64EncodeCert, byte[] inData, byte[]   signValue)
     * 参数：
     * base64EncodeCert：[IN] base64 编码的签名证书。
     * inData：[IN] 待验证的原文。
     * signValue：[IN] 签名值。
     * 返回值：
     * true：验证成功。false：验证失败。
     */
    public void verifySignedData1(String data) throws ParameterTooLongException, UnkownException, ParameterInvalidException, SVSConnectException, UnsupportedEncodingException {
        //原文
        byte[] dataBytes = data.getBytes();
        //签名结果值
        String signedValue = dsvs.signData(dataBytes);
        byte[] signedValueByte = dsvs.base64Decode(signedValue);
        //证书，这里用的是服务器证书
        String cert = dsvs.getServerCertificate();
        boolean verifyRes = dsvs.verifySignedData(cert, dataBytes, signedValueByte);
        System.out.println(verifyRes);

    }

    public static byte[] base64Decode(String signedValue) {
        return dsvs.base64Decode(signedValue);
    }

    public Boolean verifySignedData(String cert, String data, String signedValue) throws ParameterTooLongException, UnkownException, ParameterInvalidException, SVSConnectException, UnsupportedEncodingException {
        return dsvs.verifySignedData(cert, data, signedValue);
    }


    /**
     * 验证证书有效性
     * 函数定义：   int validateCert(String base64EncodeCert)
     * 参数：
     * base64EncodeCert：[IN] 待验证的 base64 编码证书
     * 证书有效返回 1,
     * 证书无效情况下： -1 为不是所信任的根，-2 为超过有效期，-3 为作废证书，-4 已加入黑名单，-5 证书未生效, 0 未知错误     *
     *
     * @return
     */
    public static String validateCert(String base64EncodeCert) throws Exception {
//         base64EncodeCert = "MIIDRzCCAu6gAwIBAgIKIgAAAAAAAAbwjTAKBggqgRzPVQGDdTBoMQswCQYDVQQGEwJDTjEQMA4GA1UECAwHR3Vhbmd4aTEQMA4GA1UEBwwHTmFubmluZzENMAsGA1UECgwER1hDQTENMAsGA1UECwwER1hDQTEXMBUGA1UEAwwOR3Vhbmd4aSBTTTIgQ0EwHhcNMjAwMzA1MTYwMDAwWhcNMjEwMzA2MTU1OTU5WjCBpDELMAkGA1UEBhMCQ04xDzANBgNVBAgMBuW5v+ilvzEPMA0GA1UEBwwG5Y2X5a6BMTAwLgYDVQQKDCflub/opb/mlbDlrZfor4HkuaborqTor4HkuK3lv4PmtYvor5XkuIAxMDAuBgNVBAMMJ+W5v+ilv+aVsOWtl+ivgeS5puiupOivgeS4reW/g+a1i+ivleS4gDEPMA0GA1UELQwGQTAzMDAxMFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE7S93Y9d7YGc92ugW9tmJXMLvIZzo1/WUhJwc2yuVywt6LRpzzAK737SNMLIDzHkt4s/7xgJ8LF1/woRCOF4hIaOCAUEwggE9MB8GA1UdIwQYMBaAFKSwdSvAG1eiN3NHufr5gDWgIXj6MB0GA1UdDgQWBBSZrSp2y1NZXr38rHmh3a7S45fb7DALBgNVHQ8EBAMCA9gwgcEGA1UdHwSBuTCBtjCBhKCBgaB/pH0wezELMAkGA1UEBgwCQ04xEDAOBgNVBAgMB0d1YW5neGkxEDAOBgNVBAcMB05hbm5pbmcxDTALBgNVBAoMBEdYQ0ExDTALBgNVBAsMBEdYQ0ExFzAVBgNVBAMMDkd1YW5neGkgU00yIENBMREwDwYDVQQDEwhjYTExY3JsMzAtoCugKYYnaHR0cDovL3NtMi5neGNhLmNvbS5jbi9jcmwvY2ExMWNybDMuY3JsMB8GCGCGSAGG+EQCBBNKSkExMjM0NTY3ODkwMTIzNDU1MAkGA1UdEwQCMAAwCgYIKoEcz1UBg3UDRwAwRAIgG3OcDIkdosfq0kKlaFoTr1g+hcjm9N/rTmcxDVrhUgMCIFDSI08gQFGKcMi36VyaYklBu5m19nKbi38r7AkEU9e1";
        int res = dsvs.validateCert(base64EncodeCert);
        LOGGER.info("证书验证结果：" + res);
        switch (res) {
            case 1:
                return "1";
            case -1:
                return "不是所信任的根";
            case -2:
                return "证书超过有效期";
            case -3:
                return "证书已作废";
            case -4:
                return "证书已加入黑名单";
            case -5:
                return "证书未生效";
            default:
                return "证书校验失败：未知错误";
        }
    }


    public static void main(String[] args) throws Exception {
        SignUtils signUtils = SignUtils.init();
        SignUtils.validateCert("MIIC/zCCAqSgAwIBAgIKIgAAAAAAAAbBmjAKBggqgRzPVQGDdTBoMQswCQYDVQQGEwJDTjEQMA4GA1UECAwHR3Vhbmd4aTEQMA4GA1UEBwwHTmFubmluZzENMAsGA1UECgwER1hDQTENMAsGA1UECwwER1hDQTEXMBUGA1UEAwwOR3Vhbmd4aSBTTTIgQ0EwHhcNMjAwMjA3MTYwMDAwWhcNMjEwMjA4MTU1OTU5WjBjMQswCQYDVQQGDAJDTjEeMBwGA1UECgwV5qKn5bee5biC5Lq65rCR5Yy76ZmiMQ8wDQYDVQQIDAblub/opb8xEjAQBgNVBAMMCeWPtuW7uueciTEPMA0GA1UEBwwG5qKn5beeMFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEugZPyA8acpfA2e4H72UP3RIiLhuVMUBp5y9UG7cHV0u83KuN8CJl8ViPv5MWmUG23U0LwR+V7M64SGUQ0yVVfaOCATkwggE1MB8GA1UdIwQYMBaAFKSwdSvAG1eiN3NHufr5gDWgIXj6MB0GA1UdDgQWBBT28gc1XRu96yxZ3cXcX7FA7IJzXjALBgNVHQ8EBAMCA9gwgcEGA1UdHwSBuTCBtjCBhKCBgaB/pH0wezELMAkGA1UEBgwCQ04xEDAOBgNVBAgMB0d1YW5neGkxEDAOBgNVBAcMB05hbm5pbmcxDTALBgNVBAoMBEdYQ0ExDTALBgNVBAsMBEdYQ0ExFzAVBgNVBAMMDkd1YW5neGkgU00yIENBMREwDwYDVQQDEwhjYTExY3JsMzAtoCugKYYnaHR0cDovL3NtMi5neGNhLmNvbS5jbi9jcmwvY2ExMWNybDMuY3JsMCIGCGCGSAGG+EQCBBYMFFNGNDUyNDAyMTk5NzAzMTMzOTQ0MAoGCCqBHM9VAYN1A0kAMEYCIQDE9UCUtGoSkkSLLYPTD83+49BveT232bq+dSGLlLXirAIhAN4UkgaGZrJt7tJ4kTL4mVsGHMmnMUS/OYDSA6mcVjo3");
        SignUtils.signData("12121212");
        System.out.println(dsvs.base64Decode(SignUtils.signData("12121212")));
//        signUtils.getServerCertificate();
//        signUtils.validateCert("");
    }
}
