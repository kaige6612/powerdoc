package com.putorn.powerdoc.enumconst;

/**
 * @description: 系统状态枚举类
 * @author：Guoqingkai
 * @date:2019/3/25
 */
public enum SystemStatusEnum {

    SYSTEM_STATUS_UNEFFECTIVE("0","失效"),
    SYSTEM_STATUS_EFFECTIVE("1","正常"),
	SYSTEM_STATUS_DELETED("2","已删除");

	private final String key;
	private final String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	SystemStatusEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getValue(String key){
		for(SystemStatusEnum ce : SystemStatusEnum.values()){
			if(ce.getKey().equals(key)){
				return ce.getValue();
			}
		}
		return null;
	}
}
