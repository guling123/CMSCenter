/**   
* @Title: ContentExceptionHandler.java 
* @Package cn.people.commons.exceptions 
* @Description: CMS处理统一处理 
* @author gaoyongjiu
* @date 2018年12月04日 下午2:18:45 
* @version V1.0   
*/
package cn.people.commons.exceptions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.people.commons.constants.CodeConstants;
import cn.people.controller.vo.ResultVO;

/** 
* @ClassName: ContentExceptionHandler
* @Description: CMS处理统一处理 
* @author gaoyongjiu
* @date 2018年11月28日 下午2:18:45 
*  
*/
@ControllerAdvice
public class CMSExceptionHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CMSExceptionHandler.class);
    /**
     * 
    * @Title: handleException 
    * @author gaoyongjiu
    * @date 2018年11月28日 下午2:32:45 
    * @Description: 处理所有不可知的异常
    * @param @param e
    * @param @return  参数说明 
    * @return ResultVO    返回类型 
    * @throws 
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResultVO<String> handleException(Exception e){
        LOGGER.error(e.getMessage(), e);
        ResultVO<String> vo=new ResultVO<String>();
        
        return vo;
    }
    
    /**
     * 
    * @Title: handleBusinessException 
    * @author gaoyongjiu
    * @date 2018年11月28日 下午2:35:25 
    * @Description: 处理所有业务异常 
    * @param @param e
    * @param @return  参数说明 
    * @return ResultVO<String>    返回类型 
    * @throws 
     */
    @ExceptionHandler(CMSBussinessException.class)
    @ResponseBody
    ResultVO<String> handleBusinessException(CMSBussinessException e){
        LOGGER.error(e.getMessage(), e);
        
        return ResultVO.badRequest(e.getCode(), e.getMessage());
    }
    /**
     * 
    * @Title: handleMethodArgumentNotValidException 
    * @author gaoyongjiu
    * @date 2018年11月28日 下午2:36:11 
    * @Description: 处理所有接口数据验证异常 
    * @param @param e
    * @param @return  参数说明 
    * @return ResultVO<String>    返回类型 
    * @throws 
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    ResultVO<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error(e.getMessage(), e);
        ResultVO<String> vo=new ResultVO<String>();
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuffer message=new StringBuffer();
        for (FieldError fieldError : fieldErrors) {
            
            message.append(fieldError.getDefaultMessage()+",");
        }
        vo.setCode(CodeConstants.RESULT_ERR_PARAM);
        vo.setMessage(message.toString());
        return vo;
    }
}
