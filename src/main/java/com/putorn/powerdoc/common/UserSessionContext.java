package com.putorn.powerdoc.common;

import com.putorn.powerdoc.entity.PowerSysUser;

/**
 * @description: 提供获取当前用户的方法
 * @author：Guoqingkai
 * @date:2019/4/29
 */
public class UserSessionContext {
	public static ThreadLocal<PowerSysUser> sessionContextHolder = new ThreadLocal<>();
	public static void setSession(PowerSysUser user) {
		sessionContextHolder.set(user);

	}
	public static PowerSysUser getuser() {
		return sessionContextHolder.get();
	}

	public static void clearContext() {
		sessionContextHolder.remove();
	}

}
