package cn.people.controller.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SessionUser extends User {

	private static final long serialVersionUID = -6933949239915673818L;

	/**
	 * 账户ID
	 */
	private String userId;
	/**
	 * 租户ID
	 */
	private String tenantId;
	/**
	 * 权限集合
	 */
	private SysPermissionMenuVO permissions;
	/**
	 * 站点信息
	 */
	private List<SiteVO> sites;
	
	private String defaultSite;

	public SessionUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public SessionUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
			throws IllegalArgumentException {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDefaultSite()
    {
        return defaultSite;
    }

    public void setDefaultSite(String defaultSite)
    {
        this.defaultSite = defaultSite;
    }

    public String getTenantId() {
		return tenantId;
	}

	public List<SiteVO> getSites()
    {
        return sites;
    }

    public void setSites(List<SiteVO> sites)
    {
        this.sites = sites;
    }

    public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

    public SysPermissionMenuVO getPermissions()
    {
        return permissions;
    }

    public void setPermissions(SysPermissionMenuVO permissions)
    {
        this.permissions = permissions;
    }
}