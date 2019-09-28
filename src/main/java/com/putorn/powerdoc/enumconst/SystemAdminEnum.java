package com.putorn.powerdoc.enumconst;

/**
 * @description: 是否是系统管理员
 * @author：Guoqingkai
 * @date:2019/3/25
 */
public enum SystemAdminEnum {

	SYSTEM_STATUS_ON(0,"否"),
	SYSTEM_STATUS_OFF(1,"是");

	private final Integer key;
	private final String value;

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	SystemAdminEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getValue(String key){
		for(SystemAdminEnum ce : SystemAdminEnum.values()){
			if(ce.getKey().equals(key)){
				return ce.getValue();
			}
		}
		return null;
	}
}
