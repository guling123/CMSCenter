package cn.people.entity;

import cn.people.entity.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 管理权限表
 * </p>
 *
 * @author fuqiang
 * @since 2018-12-17
 */
@ApiModel(value="SysPermission对象", description="管理权限表")
@TableName("tb_sys_permission")
public class SysPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableField("id")
    private String id;
    
    @ApiModelProperty(value = "权限标识")
    @TableField("ident")
    private String ident;

    @ApiModelProperty(value = "权限名称")
    @TableField("permissionname")
    private String permissionname;

    @ApiModelProperty(value = "父节点")
    @TableField("parent_id")
    private String parentId;
    
    @ApiModelProperty(value = "菜单的URL，配合前端显示菜单")
    @TableField("pre_url")
    private String preUrl;
    
    @ApiModelProperty(value = "是否显示站点树")
    @TableField("site_show")
    private Integer siteShow;

    @ApiModelProperty(value = "排序")
    @TableField("sort_index")
    private Integer sortIndex;

    @ApiModelProperty(value = "菜单标识(1:菜单)")
    @TableField("menu_flg")
    private Integer menuFlg;

    public Integer getSiteShow()
    {
        return siteShow;
    }

    public void setSiteShow(Integer siteShow)
    {
        this.siteShow = siteShow;
    }

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "创建人id")
    @TableField("createrid")
    private String createrid;

    public String getIdent() {
        return ident;
    }

    public String getPreUrl()
    {
        return preUrl;
    }

    public void setPreUrl(String preUrl)
    {
        this.preUrl = preUrl;
    }

    public SysPermission setIdent(String ident) {
        this.ident = ident;
        return this;
    }
    public String getPermissionname() {
        return permissionname;
    }

    public SysPermission setPermissionname(String permissionname) {
        this.permissionname = permissionname;
        return this;
    }
    public String getParentId() {
        return parentId;
    }

    public SysPermission setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }
    public Integer getSortIndex() {
        return sortIndex;
    }

    public SysPermission setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
        return this;
    }
    public Integer getMenuFlg() {
        return menuFlg;
    }

    public SysPermission setMenuFlg(Integer menuFlg) {
        this.menuFlg = menuFlg;
        return this;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public SysPermission setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public SysPermission setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
        "id=" + id +
        "ident=" + ident +
        ", permissionname=" + permissionname +
        ", parentId=" + parentId +
        ", sortIndex=" + sortIndex +
        ", menuFlg=" + menuFlg +
        ", createtime=" + createtime +
        ", createrid=" + createrid +
        "}";
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
}
