/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: SingureTest
 * Author:   yuanlin_csu
 * Date:     2019/12/13 17:32
 * Description: 测试RSA加签与验签
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.singure;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试RSA加签与验签〉
 *
 * @author yuanlin_csu
 * @create 2019/12/13
 * @since 1.0.0
 */
public class SingureTest {

    private static final String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCnRg5OMhmg7btO" +
            "kAYmCIxk1vYF28InloABNeM6p+gEzGm08FfjYf2Gajza+TO6T6Gbmfbt7ZK2QtaZ" +
            "9Z9x4aiCbEbhvnLNfVxYuRpc7/OSInqaI98KNWqb6SZggGxysnq5uZyQQRwtMYBu" +
            "VQVwm2YOwNgvgi0Fd7+WqvBqN7n/kvS9hjWidJToY3bnDh5JW2Un6FGY1PZH6oRT" +
            "ykjsZvZkmYp+4kREty4jjuFdXAMddAegD/MbuI36qcA0kNrveEFI4+bElm+gKn+P" +
            "mZwWktvuZeQVnjyR7U/jwy4uFt+bRnKG4OC4X6TEkKdrJvn7btxPpEVNGXPwRoI1" +
            "mUjvSovBAgMBAAECggEAU8/JOSrnJngXQqztN79OwPPn/1V1+anx5yld+jTJDyZw" +
            "zIUkND0T73ZpmXoFjhN6MOG7FMnVmdbxeeDVDBV5/idMeK2ZDhcC3z2X1PsxeoYm" +
            "EfdpOM885HO0k+Ok8u80iLxUkv7cpFRKOn4FJL/oKfo8F8nMzxGKAG8T2NSlMEVd" +
            "ICpvJo7EUZIeiU+RtTkm15C2bGkLpXJR0kxAE4R2BVpJggFTD/d/sA4zNc+NCufW" +
            "B66+JhOIrR9P/j/hjkxehG8P4fAKYjdU1VK3A94j1eZG1MUEQwx1FXlRWcTMg4/z" +
            "KszPnn0LG6yMkuIG5oJzKugddt4nbduLArm/Pv7flQKBgQDYgmzl+x3khMhYefai" +
            "eQnq71pRE/HsgBve5tyzET33mMWLb7T+cKrgFgd7Vg+t5OE1FwbBIUGmuPmxcEa2" +
            "g/jg27q1bhQBpxUXD1Wpol/AqVWXg4+lQFkf3+5dgK2visxMB6Nl6bHbXGsj3Y1a" +
            "FJqHp9VmNIFVViJVYdUyj/pzTwKBgQDFyKPkUTdHkW+JtGbVAKeznC8vpzuV70Vw" +
            "2gigh97RtIHzkMm9WQl+Qm8al/DW1cpQv/YKpAghdv9Xy8xYnv/Dlhn26gETD5Pa" +
            "PaTDlkxqOGzjMsRDUrohS+cpI400FZZ3xe1rIIhWZrT5uQkCSrfIsIuYnp6ifwTZ" +
            "+eQFNxOL7wKBgQDG27Rt36HrHFJvgUYYoJeNY15PDcSsdlYi+2RGTFXgLj9y/Jz+" +
            "/jjULSeeDsPD8m8vNgEMLiGAonEkmn04ciqLTQZGUd6qTe4/CeSiM/NCn8VvrnSn" +
            "UV0Ku8DRvLjKfO97/aAEoQqs8kut23ZTAI2Wf36vqxYHbV+HkJ4jHL7qXQKBgQCL" +
            "doM6h5o3OPIxY6fvIlseZ09OhtmZS/LnNJdIuwX/UQ0hNkNK5PGwuh+l3OXSV0Yl" +
            "0nYn4qppDoPW4Lni85rdy4Xbef3v9tgG19jKobyYWdlOC4og/sCIogEKHSuAQoir" +
            "REG5fGMmqZ2LSVJ070LQnMySfabWZkKBgZerpb5+uQKBgH/d+zsUvRSobLKg3IHg" +
            "DIkSfKFlH6Hg9L05YdGsjxzq/eq04kgoj9PMVJydPl9tcPJUQvwbj2+OxDPLIAkT" +
            "3nLIftf07nq9Eg6USEXqtp7n8IGyHT0kSno3YbR6kbMG4aFJDnmfXQq7zT4Ap6OF" +
            "ZpfYQLURDvLuDeDeP7cHMmkM";
    private static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp0YOTjIZoO27TpAGJgiM" +
            "ZNb2BdvCJ5aAATXjOqfoBMxptPBX42H9hmo82vkzuk+hm5n27e2StkLWmfWfceGo" +
            "gmxG4b5yzX1cWLkaXO/zkiJ6miPfCjVqm+kmYIBscrJ6ubmckEEcLTGAblUFcJtm" +
            "DsDYL4ItBXe/lqrwaje5/5L0vYY1onSU6GN25w4eSVtlJ+hRmNT2R+qEU8pI7Gb2" +
            "ZJmKfuJERLcuI47hXVwDHXQHoA/zG7iN+qnANJDa73hBSOPmxJZvoCp/j5mcFpLb" +
            "7mXkFZ48ke1P48MuLhbfm0ZyhuDguF+kxJCnayb5+27cT6RFTRlz8EaCNZlI70qL" +
            "wQIDAQAB";

    // 算法
    private static final String  SIGN_ALGORITHMS = "SHA1WithRSA";

    public SingureTest(){
        super();
    }


    public static String sign(String privateKey, String param){

        try {
            //获取privatekey
            byte[] privateKeyByte = new Base64().decode(privateKey);
            KeyFactory keyfactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec encoderule = new PKCS8EncodedKeySpec(privateKeyByte);
            PrivateKey key = keyfactory.generatePrivate(encoderule);

            //用私钥给入参加签
            Signature sign = Signature.getInstance(SIGN_ALGORITHMS);
            sign.initSign(key);
            sign.update(param.getBytes());

            byte[] signature = sign.sign();
            //将签名的入参转换成16进制字符串
            return bytesToHexStr(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    public static boolean verifyRes(String param,String signature,String publicKey){

        try {
            //获取公钥
            KeyFactory keyFactory=KeyFactory.getInstance("RSA");
            byte[] publicKeyByte= new Base64().decode(publicKey);
            X509EncodedKeySpec encodeRule=new X509EncodedKeySpec(publicKeyByte);
            PublicKey key= keyFactory.generatePublic(encodeRule);

            //用获取到的公钥对   入参中未加签参数param 与  入参中的加签之后的参数signature 进行验签
            Signature sign = Signature.getInstance(SIGN_ALGORITHMS);
            sign.initVerify(key);
            sign.update(param.getBytes());

            //将16进制码转成字符数组
            byte[] hexByte = hexStrToBytes(signature);
            //验证签名
            return sign.verify(hexByte);

        }  catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }



    /**
     * byte数组转换成十六进制字符串
     * @param bytes byte数组
     * @return      返回十六进制字符串
     */
    private static String bytesToHexStr(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < bytes.length; ++i) {
            stringBuffer.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF)).substring(1).toUpperCase());
        }
        return stringBuffer.toString();
    }

    /**
     * 十六进制字符串转成byte数组
     * @param hexStr   十六进制字符串
     * @return          返回byte数组
     * */
    private static byte[] hexStrToBytes(String hexStr) {
        byte[] bytes = new byte[hexStr.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hexStr.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    
    public static void main (String [] args){

        String oriStr = "yuanl8888888888888888888888888888888888888888888888888888888888888888in3";

        String signureStr = sign(privateKey,oriStr);

        System.out.println("length = " + signureStr.length());
        System.out.println("signureStr =  " + signureStr);

        System.out.println("verifyStr =  " + verifyRes(oriStr,signureStr,publicKey));

    }

}
