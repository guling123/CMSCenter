/**   
* @Title: ChannelCreateRemoteVO.java 
* @Package cn.people.controller.vo 
* @Description:  远程调用contentService 创建栏目参数
* @author shidandan
* @date 2019年1月14日 上午11:11:49 
* @version V1.0   
*/
package cn.people.controller.vo;

/** 
* @ClassName: ChannelCreateRemoteVO 
* @Description: 远程调用contentService 创建栏目参数
* @author shidandan
* @date 2019年1月14日 上午11:11:49 
*  
*/
public class ChannelCreateRemoteVO extends ChannelCreateVO
{

    private static final long serialVersionUID = 4397522592428818421L;
    
    private String createrId;
    public String getCreaterId()
    {
        return createrId;
    }
    public void setCreaterId(String createrId)
    {
        this.createrId = createrId;
    }
}
