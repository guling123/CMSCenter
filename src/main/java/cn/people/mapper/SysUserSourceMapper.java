package cn.people.mapper;

import cn.people.controller.vo.SysUserSourceVO;
import cn.people.entity.SysUserSource;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户常用稿源表 Mapper 接口
 * </p>
 *
 * @author shidandan
 * @since 2018-12-18
 */
public interface SysUserSourceMapper extends BaseMapper<SysUserSource> {

    @Select("SELECT us.*,cs.sourcename FROM `tb_sys_user_source` us LEFT JOIN `tb_content_source` cs ON us.sourceid=cs.id WHERE us.userid=#{createrId} AND cs.status='1';")
    List<SysUserSourceVO> getSysUserSource(String createrId);
}
