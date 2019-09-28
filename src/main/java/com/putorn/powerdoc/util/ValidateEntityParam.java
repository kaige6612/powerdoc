package com.putorn.powerdoc.util;

import com.putorn.powerdoc.entity.PowerSysUser;

/**
 * @description:
 * @author：Guoqingkai
 * @date:2019/4/19
 */
public class ValidateEntityParam {

	public static String validateUser(PowerSysUser user) {
		String errorMsg = null;
		if (user.getUsername() == null || user.getUsername().equals("")){
			errorMsg = "请填写用户名";
		}
		if(user.getPassword() == null || user.getPassword().equals("")){
			errorMsg = "请填写密码";
		}

		return errorMsg;
	}
}
