package cn.people.service;

import cn.people.controller.vo.SysUserSourceVO;
import cn.people.entity.SysUserSource;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户常用稿源表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-18
 */
public interface ISysUserSourceService extends IService<SysUserSource> {

    /**
     * 
    * @Title: getSysUserSource 
    * @author shidandan
    * @date 2018年12月20日 下午5:57:45 
    * @Description: 查询用户常用稿源
    * @param @return  参数说明 
    * @return List<SysUserSource>    返回类型 
    * @throws 
     */
    List<SysUserSourceVO> getSysUserSource(String createrId);
}
