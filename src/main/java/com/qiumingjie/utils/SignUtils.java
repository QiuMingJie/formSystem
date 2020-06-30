package com.qiumingjie.utils;

import cn.org.bjca.client.exceptions.*;
import cn.org.bjca.client.security.SecurityEngineDeal;
import org.junit.Before;
import org.junit.Test;
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
    private SecurityEngineDeal dsvs = null;

    public SignUtils() throws ApplicationNotFoundException, InitException, SVSConnectException {
        init();
    }

    @Before
    public void init() throws ApplicationNotFoundException, InitException, SVSConnectException {
        LOGGER.info("初始化");
        //读取配置文件里面文件
        SecurityEngineDeal.setProfilePath("C:\\BJCAROOT");
        //公网测试服务器
        dsvs = SecurityEngineDeal.getInstance("SVSDefault");
    }

    /**
     * 获取服务器证书
     * 成功返回Base64 编码的服务器证书。出错则返回空值
     */
    public void getServerCertificate() throws SVSConnectException {
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
    public void signData(String data) throws SVSConnectException, ParameterTooLongException {

        String sss = dsvs.signData(data);
        //sss = signData;
        LOGGER.info("原文:" + data);
        LOGGER.info("签名返回值:" + sss);
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
    @Test
    public void verifySignedData(String data) throws ParameterTooLongException, UnkownException, ParameterInvalidException, SVSConnectException, UnsupportedEncodingException {
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
    @Test
    public void validateCert() throws Exception {

        String base64EncodeCert = "MIIDRzCCAu6gAwIBAgIKIgAAAAAAAAbwjTAKBggqgRzPVQGDdTBoMQswCQYDVQQGEwJDTjEQMA4GA1UECAwHR3Vhbmd4aTEQMA4GA1UEBwwHTmFubmluZzENMAsGA1UECgwER1hDQTENMAsGA1UECwwER1hDQTEXMBUGA1UEAwwOR3Vhbmd4aSBTTTIgQ0EwHhcNMjAwMzA1MTYwMDAwWhcNMjEwMzA2MTU1OTU5WjCBpDELMAkGA1UEBhMCQ04xDzANBgNVBAgMBuW5v+ilvzEPMA0GA1UEBwwG5Y2X5a6BMTAwLgYDVQQKDCflub/opb/mlbDlrZfor4HkuaborqTor4HkuK3lv4PmtYvor5XkuIAxMDAuBgNVBAMMJ+W5v+ilv+aVsOWtl+ivgeS5puiupOivgeS4reW/g+a1i+ivleS4gDEPMA0GA1UELQwGQTAzMDAxMFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE7S93Y9d7YGc92ugW9tmJXMLvIZzo1/WUhJwc2yuVywt6LRpzzAK737SNMLIDzHkt4s/7xgJ8LF1/woRCOF4hIaOCAUEwggE9MB8GA1UdIwQYMBaAFKSwdSvAG1eiN3NHufr5gDWgIXj6MB0GA1UdDgQWBBSZrSp2y1NZXr38rHmh3a7S45fb7DALBgNVHQ8EBAMCA9gwgcEGA1UdHwSBuTCBtjCBhKCBgaB/pH0wezELMAkGA1UEBgwCQ04xEDAOBgNVBAgMB0d1YW5neGkxEDAOBgNVBAcMB05hbm5pbmcxDTALBgNVBAoMBEdYQ0ExDTALBgNVBAsMBEdYQ0ExFzAVBgNVBAMMDkd1YW5neGkgU00yIENBMREwDwYDVQQDEwhjYTExY3JsMzAtoCugKYYnaHR0cDovL3NtMi5neGNhLmNvbS5jbi9jcmwvY2ExMWNybDMuY3JsMB8GCGCGSAGG+EQCBBNKSkExMjM0NTY3ODkwMTIzNDU1MAkGA1UdEwQCMAAwCgYIKoEcz1UBg3UDRwAwRAIgG3OcDIkdosfq0kKlaFoTr1g+hcjm9N/rTmcxDVrhUgMCIFDSI08gQFGKcMi36VyaYklBu5m19nKbi38r7AkEU9e1";

        int res = dsvs.validateCert(base64EncodeCert);
        LOGGER.info("验证结果：" + res);

    }


    public static void main(String[] args) throws Exception {
        SignUtils signUtils = new SignUtils();
        signUtils.signData("aaa");
        signUtils.getServerCertificate();
        signUtils.validateCert();
    }
}
