/**   
* @Title: CMSBussinessException.java 
* @Package cn.people.commons.exceptions 
* @Description: CMS业务异常 
* @author shidandan
* @date 2018年12月12日 下午7:09:28 
* @version V1.0   
*/
package cn.people.commons.exceptions;

/** 
* @ClassName: CMSBussinessException 
* @Description: CMS业务异常
* @author shidandan
* @date 2018年12月12日 下午7:09:28 
*  
*/
public class CMSBussinessException extends Exception
{
    private static final long serialVersionUID = -2262023891881457036L;
    
    protected final String code;

    public CMSBussinessException(String code)
    {
        super("CMS Business Exception");
        this.code = code;
    }

    public CMSBussinessException(String code, String msg)
    {
        super(msg);
        this.code = code;
    }

    public CMSBussinessException(String code, Throwable t)
    {
        super(t);
        this.code = code;
    }

    public CMSBussinessException(String code, String msg, Throwable t)
    {
        super(msg, t);
        this.code = code;
    }

    public String getCode()
    {
        return this.code;
    }

    public String toString()
    {
        return super.toString() + "\nError Code: " + this.code;
    }

}
