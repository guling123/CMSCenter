/**   
* @Title: PasswordUtils.java 
* @Package cn.people.utils 
* @Description: 密码工具类 
* @author shidandan
* @date 2018年12月16日 上午9:22:17 
* @version V1.0   
*/
package cn.people.commons.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.people.commons.exceptions.CMSExceptionHandler;
/** 
* @ClassName: PasswordUtils 
* @Description: 密码工具类（暂时无用）
* @author shidandan
* @date 2018年12月16日 上午9:22:17 
*  
*/
public class PasswordUtils {
   private static final Logger LOGGER = LoggerFactory.getLogger(CMSExceptionHandler.class);
    
   private static SecureRandom random = new SecureRandom();
   
   /**
    * 
   * @Title: entryptPassword 
   * @author shidandan
   * @date 2018年12月17日 下午8:03:26 
   * @Description: 加密
   * @param @param plainPassword
   * @param @param salt
   * @param @return  参数说明 
   * @return String    返回类型 
   * @throws 
    */
   public static String entryptPassword(String plainPassword,String salt) {
        
       try {
           Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器

           byte[] byteContent = plainPassword.getBytes("utf-8");

           cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(salt));// 初始化为加密模式的密码器

           byte[] result = cipher.doFinal(byteContent);// 加密

           return Base64.encodeBase64String(result);//通过Base64转码返回
       } catch (Exception ex) {
           LOGGER.error("加密失败", ex);
       }

       return null;
    }
    
    /**
     * 
   * @Title: decrypt 
   * @author fuqiang
   * @date 2018年12月19日 上午9:03:23 
   * @Description: AES解密
   * @param @param password 加密后的密码内容
   * @param @param salt 随机数密钥
   * @param @return  参数说明 
   * @return String  解密的内容
   * @throws 
    */
   public static String decrypt(String password, String salt) {
       try {
           //实例化
           Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

           //使用密钥初始化，设置为解密模式
           cipher.init(Cipher.DECRYPT_MODE, getSecretKey(salt));

           //执行操作
           byte[] result = cipher.doFinal(Base64.decodeBase64(password));

           return new String(result, "utf-8");
       } catch (Exception e) {
           LOGGER.error(e.getMessage(),e);
       }
       
       return null;
   }
    /**
     * 
    * @Title: validatePassword 
    * @author shidandan
    * @date 2018年12月14日 下午6:02:49 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param plainPassword
    * @param @param password
    * @param @param salt
    * @param @return  参数说明 
    * @return boolean    返回类型 
    * @throws 
     */
    public static boolean validatePassword(String plainPassword, String password,String salt) {
        try {
//            //实例化
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//
//            //使用密钥初始化，设置为解密模式
//            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(salt));
//
//            //执行操作
//            byte[] result = cipher.doFinal(Base64.decodeBase64(plainPassword));

            plainPassword= entryptPassword(plainPassword, salt);
        } catch (Exception ex) {
            LOGGER.error("解密失败", ex);
        }
        
         
         return password.equals(plainPassword);
    }
	
	/**
	 * 
	* @Title: generateSalt 
	* @author shidandan
	* @date 2018年12月14日 下午6:09:39 
	* @Description: 生成255位的盐值
	* @param @param numBytes
	* @param @return  参数说明 
	* @return byte[]    返回类型 
	* @throws 
	 */
	public static String generateSalt(int numBytes)
    {
      Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

      byte[] bytes = new byte[numBytes];
      random.nextBytes(bytes);
      return Base64.encodeBase64String(bytes);
    }
	/**
	 * 
	* @Title: getSecretKey 
	* @author shidandan
	* @date 2018年12月17日 下午7:57:43 
	* @Description: 生成加密秘钥
	* @param @param password
	* @param @return  参数说明 
	* @return SecretKeySpec    返回类型 
	* @throws 
	 */
	 private static SecretKeySpec getSecretKey(final String password) {
	        //返回生成指定算法密钥生成器的 KeyGenerator 对象
	        KeyGenerator kg = null;

	        try {
	            kg = KeyGenerator.getInstance("AES");

	            //AES 要求密钥长度为 128
	            kg.init(128, new SecureRandom(password.getBytes()));

	            //生成一个密钥
	            SecretKey secretKey = kg.generateKey();

	            return new SecretKeySpec(secretKey.getEncoded(), "AES");// 转换为AES专用密钥
	        } catch (Exception ex) {
	            LOGGER.error("生成加密秘钥失败", ex);
	        }

	        return null;
	    }
}
