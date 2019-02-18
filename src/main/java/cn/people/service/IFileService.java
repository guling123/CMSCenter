package cn.people.service;


import cn.people.controller.vo.*;
import cn.people.entity.Image;
import cn.people.entity.OriginImage;
import cn.people.entity.Watermark;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author guling
 * @ClassName: IFileService
 * @Description: 文件上传
 * @date 2019/1/18 18:35
 */
public interface IFileService
{
    /**
     *
     * @Title: 图片复制 
     * @author shidandan
     * @date 2018年11月29日 下午2:30:18 
     * @Description: 图片复制 
     * @param  image 图片复制
     * @return ResultVO<String>    返回类结果集
     * @throws ImageBussinessException
     */
    ResultVO<Image> copy(ImageCopyVO imageCopy);

    /**
     * @author guling
     * @Title   图片上传接口的校验
     * @Date    2019/1/16 16:08
     * @param   request
     * @return  java.lang.String 返回一个json字符串给前台作为校验的基础
     * @throws
     * @Description ueditor上传文件统一校验接口
     */
    String ueditor();

    /**
     *
     * @Title: 图片上传 
     * @author shidandan
     * @date 2018年11月29日 下午1:55:30 
     * @Description: 上传原始图片 
     * @param @param image MultipartFile类型
     * @param @return  参数说明 
     * @return ResultVO<String>    返回类型 
     * @throws 
     */
    ImageAddResultVO upload(MultipartFile image);

    /**
     *
     * @Title: 原始图片筛选 
     * @author shidandan
     * @date 2018年11月29日 下午3:45:37 
     * @Description: 原始图片筛选 
     * @param  imageList 原始图片筛选参数
     * @return ResultVO<String>    返回类结果集
     */
    ResultVO<IPage<OriginImage>> queryOriginImage(OriginImageListVO imageList);

    /**
     *
     * @Title: 图片添加水印 
     * @author shidandan
     * @date 2018年11月29日 上午11:06:08 
     * @Description: 图片添加水印 
     * @param  param 添加水印请求参数
     * @param  image MultipartFile
     * @return ResultVO<?>    返回结果 
     * @throws Exception
     */
    DealWatermarkResultVO dealWatermark(MultipartFile image, DealWatermarkVO param);

    /**
     * @author guling
     * @Title   缩略图保存
     * @Date    2019/1/18 16:56
     * @param   [imageCreateVO]  /image的入参
     * @return  boolean Boolean类型
     * @throws Exception
     * @Descripe 缩略图保存接口
     */
    Boolean createImage(ImageCreateVO imageCreateVO);

    /**
     *
     * @Title: 站点水印添加 
     * @author shidandan
     * @date 2018年11月29日 上午10:18:32 
     * @Description: 站点水印添加 
     * @param param 创建站点水印参数 
     * @return ResultVO<?>    返回类型 
     * @throws Exception
     *  @Description: 站点水印添加
     */
    Boolean createWatermark(WatermarkCreateVO param);

    /**
     *
     * @Title: 站点水印修改 
     * @author shidandan
     * @date 2018年11月29日 上午10:51:51 
     * @Description: 站点水印修改 
     * @param Watermark  TbWatermark对象 
     * @return ResultVO<?>    返回结果
     * @throws Exception
     * @Description: 站点水印修改 
     */
    Boolean updateWatermark(Watermark param);

    /**
     *
     * @Title: 站点水印删除 
     * @author shidandan
     * @date 2018年11月29日 上午10:51:51 
     * @Description: 站点水印删除 
     * @param @param id 图片id
     * @return ResultVO<?>    返回结果
     * @throws Exception
     * @Description: 站点水印删除
     */
    Boolean delWatermark(String id);


    /**
     *
     * @Title: 站点水印列表 
     * @author shidandan
     * @date 2018年11月29日 上午11:02:21 
     * @Description: 站点水印列表 
     * @param WatermarkListVO 站点水印列表入参
     * @return ResultVO<Page<WatermarkListResultVO>>    返回类型 
     * @throws 
     */
    Page<WatermarkListResultVO> getWatermarkPaged(WatermarkListVO param);
}
