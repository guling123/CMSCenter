package cn.people.commons.utils;


import java.io.UnsupportedEncodingException;
import java.security.Security;

import org.apache.commons.lang.RandomStringUtils;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

/** 
* @ClassName: Sm3Utils 
* @Description: Sm3工具类
* @author gaoyongjiu
* @date 2018年12月19日 上午9:22:17 
*  
*/
public class Sm3Utils {
	private static final String ENCODING = "UTF-8";	// 字符集
	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * sm3算法加密
	 * 
	 * @explain
	 * @param paramStr
	 *                 待加密字符串
	 * @return 返回加密后，固定长度=32的16进制字符串
	 */
	public static String encrypt(String paramStr) {
		// 将返回的hash值转换成16进制字符串
		String resultHexString = "";
		try {
			// 将字符串转换成byte数组
			byte[] srcData = paramStr.getBytes(ENCODING);
			// 调用hash()
			byte[] resultHash = hash(srcData);
			// 将返回的hash值转换成16进制字符串
			resultHexString = ByteUtils.toHexString(resultHash);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return resultHexString;
	}

	/**
	 * sm3算法加密
	 * 
	 * @explain
	 * @param paramStr
	 *                 待加密字符串
	 * @param salt
	 *               盐值(10位) 作为后缀
	 * @return 返回加密后，固定长度=32的16进制字符串
	 */
	public static String encryptWithSalt(String paramStr,String salt) {
		return encrypt(paramStr+salt);
	}

	/**
	 * 
	 * 返回长度=32的byte数组
	 * 
	 * @explain 生成对应的hash值
	 * @param srcData
	 * @return
	 * 
	 */
	public static byte[] hash(byte[] srcData) {

		SM3Digest digest = new SM3Digest();
		digest.update(srcData, 0, srcData.length);
		byte[] hash = new byte[digest.getDigestSize()];
		digest.doFinal(hash, 0);
		return hash;
	}
	
	/**
	 * 生成10位随机字符串
	 * @return
	 */
	public static String getSalt10() {
		return RandomStringUtils.randomNumeric(10);
	}
}
