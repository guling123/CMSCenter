package cn.people.controller;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.*;
import cn.people.entity.Image;
import cn.people.entity.OriginImage;
import cn.people.entity.Watermark;
import cn.people.service.IFileService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * @author guling
 * @ClassName: FileController
 * @Description: 文件上传
 * @date 2019/1/18 18:33
 */
@RestController
@RequestMapping("/file")
@Api(value = "文件上传", description = "文件上传")
public class FileController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private IFileService iFileService;

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
    @ApiOperation(value = "图片复制", notes = "图片复制")
    @RequestMapping(value = "/copy", method = RequestMethod.POST)
    public ResultVO<Image> copy(@RequestBody ImageCopyVO imageCopy) throws Exception{
        LOGGER.info("图片处理copy接口入参,param={}", JSON.toJSONString(imageCopy));
        return iFileService.copy(imageCopy);
    }

    /**
     * @author guling
     * @Title   图片上传接口的校验
     * @Date    2019/1/16 16:08
     * @param   request
     * @return  java.lang.String 返回一个json字符串给前台作为校验的基础
     * @throws
     * @Description ueditor上传文件统一校验接口
     */
    @ApiOperation(value = "上传原始图片校验", notes = "上传原始图片校验")
    @RequestMapping(value="/origin/upload",method = RequestMethod.GET)
    @ResponseBody
    public String ueditor() {
        return iFileService.ueditor();
    }

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
    @ApiOperation(value = "上传原始图片", notes = "上传原始图片")
    @RequestMapping(value="/origin/upload",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ImageAddResultVO upload(@RequestPart("image") MultipartFile image) throws Exception{
        return iFileService.upload(image);
    }

    /**
     *
     * @Title: 原始图片筛选 
     * @author shidandan
     * @date 2018年11月29日 下午3:45:37 
     * @Description: 原始图片筛选 
     * @param  imageList 原始图片筛选参数
     * @return ResultVO<String>    返回类结果集
     */
    @ApiOperation(value = "原始图片筛选", notes = "原始图片筛选")
    @RequestMapping(value = "/origin/list", method = RequestMethod.POST)
    public ResultVO<IPage<OriginImage>> getOriginImagePaged(@RequestBody OriginImageListVO imageList)  throws Exception{
        LOGGER.info("原始图片筛选入参:{}",JSON.toJSONString(imageList));
        return iFileService.queryOriginImage(imageList);
    }





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
    @ApiOperation(value = "图片添加水印", notes = "图片添加水印")
    @RequestMapping(value = "/deal/watermark", method = RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResultVO<DealWatermarkResultVO> dealWatermark(@RequestParam("image") MultipartFile image,@RequestBody DealWatermarkVO param) throws Exception{
        //图片添加水印
        return ResultVO.ok(iFileService.dealWatermark(image, param));
    }

    /**
     * @author guling
     * @Title   缩略图保存
     * @Date    2019/1/18 16:56
     * @param   [imageCreateVO]  /image的入参
     * @return  boolean Boolean类型
     * @throws Exception
     * @Descripe 缩略图保存接口
     */
    @ApiOperation(value = "缩略图保存", notes = "缩略图保存")
    @RequestMapping(value = "/{id}/create", method = RequestMethod.POST)
    public Boolean createImage(@RequestBody(required = false)  ImageCreateVO imageCreateVO,@PathVariable String id) throws Exception{
        LOGGER.info("压缩图片添加接口入参：{}","111"+JSON.toJSONString(imageCreateVO));
        return iFileService.createImage(imageCreateVO);
    }

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
    @ApiOperation(value = "站点水印添加", notes = "站点水印添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultVO<Boolean> createWatermark(@RequestBody WatermarkCreateVO param) throws Exception{
        LOGGER.info("站点水印添加：{}","111"+JSON.toJSONString(param));
        return ResultVO.ok(iFileService.createWatermark(param));
    }

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
    @ApiOperation(value = "站点水印修改", notes = "站点水印修改")
    @RequestMapping(value = "/watermark/update", method = RequestMethod.POST)
    public ResultVO<Boolean> updateWatermark(@RequestBody Watermark param) throws Exception{
        LOGGER.info("站点水印修改：{}","111"+JSON.toJSONString(param));
        return ResultVO.ok(iFileService.updateWatermark(param));
    }


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
    @ApiOperation(value = "站点水印删除", notes = "站点水印删除")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResultVO<Boolean> delWatermark(@RequestParam (value = "id") String id) throws Exception{
        LOGGER.info("站点水印删除：{}","111"+JSON.toJSONString(id));
        return ResultVO.ok(iFileService.delWatermark(id));
    }

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
    @ApiOperation(value = "站点水印列表", notes = "站点水印列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultVO<Page<WatermarkListResultVO>> getWatermarkPaged(@RequestBody WatermarkListVO param){
        LOGGER.info("站点水印列表：{}","111"+JSON.toJSONString(param));
        return ResultVO.ok(iFileService.getWatermarkPaged(param));

    }
}
