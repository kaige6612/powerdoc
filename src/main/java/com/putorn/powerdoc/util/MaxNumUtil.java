package com.putorn.powerdoc.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author：Guoqingkai
 * @date:2019/4/22
 */
@Component
public class MaxNumUtil {
	public static String initNum = "10000000";
	private final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private RedisUtil redisService;
	/**
	 * 生成当天该类型的最大号(当前分+6位递增数字)
	 * @param type
	 * @return
	 */
	public  Long getMaxNumByDay(String type) {
		Long result;
		String date = DateUtil.getNowDate();
		//通过redisKey区分不同天数
		String redisKey = type+date;
//		boolean exists = redisService.exists(redisKey);
		Long existValue = redisService.getLong(redisKey);
		if(existValue == 0) {
			result = Long.parseLong(date+initNum);
			redisService.initValue(redisKey,result,DateUtil.getTodayEndTime());

		}else {
			result = redisService.generate(redisKey);
		}
//		result = redisService.generate(redisKey);
		return result;
	}

}
