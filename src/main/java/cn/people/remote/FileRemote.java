package cn.people.remote;

import cn.people.controller.vo.*;
import cn.people.entity.Image;
import cn.people.entity.OriginImage;
import cn.people.entity.Watermark;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author guling
 * @ClassName: FileRemote
 * @Description: 文件上传
 * @date 2019/1/18 18:31
 */
//@FeignClient("imageService")
@FeignClient(value = "imageService")
public interface FileRemote
{

    /**
     *
     * @Title: 图片复制 
     * @author guling
     * @date 2018年11月29日 下午2:30:18 
     * @Description: 图片复制 
     * @param  image 图片复制
     * @return ResultVO<String>    返回类结果集
     * @throws ImageBussinessException
     */
    @RequestMapping(value ="/image/deal/copy", method = RequestMethod.POST)
    ResultVO<Image> copy(@RequestBody ImageCopyVO imageCopy);

    /**
     * @author guling
     * @Title   图片上传接口的校验
     * @Date    2019/1/16 16:08
     * @param   request
     * @return  java.lang.String 返回一个json字符串给前台作为校验的基础
     * @throws
     * @Description ueditor上传文件统一校验接口
     */
    @RequestMapping(value="/image/origin/upload",method = RequestMethod.GET)
    String ueditor();

    /**
     *
     * @Title: 图片上传 
     * @author guling
     * @date 2018年11月29日 下午1:55:30 
     * @Description: 上传原始图片 
     * @param @param image MultipartFile类型
     * @param @return  参数说明 
     * @return ResultVO<String>    返回类型 
     * @throws 
     */
    @RequestMapping(value="/image/origin/upload",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ImageAddResultVO upload(@RequestPart("image") MultipartFile image);

    /**
     *
     * @Title: 原始图片筛选 
     * @author guling
     * @date 2018年11月29日 下午3:45:37 
     * @Description: 原始图片筛选 
     * @param  imageList 原始图片筛选参数
     * @return ResultVO<String>    返回类结果集
     */
    @RequestMapping(value = "/image/origin/list", method = RequestMethod.POST)
    ResultVO<IPage<OriginImage>> queryOriginImage(@RequestBody OriginImageListVO imageList);

    /**
     *
     * @Title: 图片添加水印 
     * @author guling
     * @date 2018年11月29日 上午11:06:08 
     * @Description: 图片添加水印 
     * @param  param 添加水印请求参数
     * @param  image MultipartFile
     * @return ResultVO<?>    返回结果 
     * @throws Exception
     */
   @RequestMapping(value = "/image/deal/watermark", method = RequestMethod.POST)
    DealWatermarkResultVO dealWatermark(@RequestParam("image") MultipartFile image, @RequestBody DealWatermarkVO param);

    /**
     * @author guling
     * @Title   缩略图保存
     * @Date    2019/1/18 16:56
     * @param   [imageCreateVO]  /image的入参
     * @return  boolean Boolean类型
     * @throws Exception
     * @Descripe 缩略图保存接口
     */
    @RequestMapping(value = "/image/create", method = RequestMethod.POST)
    ResultVO<Boolean> createImage(@RequestBody ImageCreateVO imageCreateVO);

    /**
     *
     * @Title: 站点水印添加 
     * @author guling
     * @date 2018年11月29日 上午10:18:32 
     * @Description: 站点水印添加 
     * @param param 创建站点水印参数 
     * @return ResultVO<?>    返回类型 
     * @throws Exception
     *  @Description: 站点水印添加
     */
    @RequestMapping(value = "/site/watermark/add", method = RequestMethod.POST)
    Boolean createWatermark(@RequestBody WatermarkCreateVO param);

    /**
     *
     * @Title: 站点水印修改 
     * @author guling
     * @date 2018年11月29日 上午10:51:51 
     * @Description: 站点水印修改 
     * @param Watermark  TbWatermark对象 
     * @return ResultVO<?>    返回结果
     * @throws Exception
     * @Description: 站点水印修改 
     */
    @RequestMapping(value = "/site/watermark/update", method = RequestMethod.POST)
    Boolean updateWatermark(@RequestBody Watermark param);

    /**
     *
     * @Title: 站点水印删除 
     * @author guling
     * @date 2018年11月29日 上午10:51:51 
     * @Description: 站点水印删除 
     * @param @param id 图片id
     * @return ResultVO<?>    返回结果
     * @throws Exception
     * @Description: 站点水印删除
     */
    @RequestMapping(value = "/site/watermark/del", method = RequestMethod.GET)
    Boolean delWatermark(@PathVariable  String id);

    /**
     *
     * @Title: 站点水印列表 
     * @author guling
     * @date 2018年11月29日 上午11:02:21 
     * @Description: 站点水印列表 
     * @param WatermarkListVO 站点水印列表入参
     * @return ResultVO<Page<WatermarkListResultVO>>    返回类型 
     * @throws 
     */
    @RequestMapping(value = "/site/watermark/list", method = RequestMethod.POST)
    Page<WatermarkListResultVO> getWatermarkPaged(@RequestBody WatermarkListVO param);
}
