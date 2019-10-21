package com.putorn.powerdoc;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.deepoove.poi.data.DocxRenderData;
import com.putorn.powerdoc.entity.PowerSubReport;
import com.putorn.powerdoc.entity.SubReport;
import com.putorn.powerdoc.entity.vo.PowerSubReportVo;

import java.io.File;
import java.util.*;

/**
 * @description: 普通逻辑或java方法测试
 * @author：Guoqingkai
 * @date:2019/3/25
 */
public class TestCommon {
	public static void main(String[] args) {
//		testListAndArray();

//		testJosnToMap();

//		testJavabeanToJson();
//        long time = System.currentTimeMillis();
//        System.out.printf(String.valueOf(time));


		testJson();

    }

	public static void testListAndArray() {
		JSONObject json = new JSONObject();
		List<String> list = new ArrayList<>();
		list.add("1234");
		list.add("9871");
		json.put("at",list.toString());
		System.out.println(json.toJSONString());

		String[] arr = {"1111","2222"};
		json.put("bt", Arrays.asList(arr));
		System.out.println(json.toJSONString());
	}

	public static void testJosnToMap() {
		Map<String,Object> map = new HashMap<>();
		JSONObject json = new JSONObject();
		json.put("name","小李子");
		json.put("age","28");

		map = (Map<String,Object>)json;

		Map<String, Object> params = JSONObject.parseObject(json.toJSONString(), new TypeReference<Map<String, Object>>(){});
		System.out.println("json:"+map.toString());
		System.out.println("params:"+params.toString());
	}

	/*public static void testJavabeanToJson() {
		UpUser user = new UpUser();
		user.setDpmId(1);
		user.setUsername("小五");
		user.setId(123L);
		user.setStatus(22);
		user.setIsSysadmin(1);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSON(user).toString());
//		JSONObject jsonObject = JSON.parseObject(user.toString());
		System.out.println(jsonObject.toJSONString());
	}*/

	public static void maxLong() {
		List<PowerSubReportVo> segments = new ArrayList<>();
		DocxRenderData segment = new DocxRenderData(new File("src/test/resources/story/segment.docx"), segments );
//		segment.getRenderDatas()getRenderDatas
	}


	public static void testJson() {
		JSONObject json = new JSONObject();

		json.put("addtime","2019-10-21 14:05:21");
		json.put("edittime","2019-09-21 14:05:22");
		json.put("addUsername","张飞");
		json.put("editUsername","赵云");

		System.out.println("转换前参数："+json.toJSONString());
		SubReport subReport = JSON.toJavaObject(json, SubReport.class);

		System.out.println("转换后修改时间为："+subReport.getEdittime());

		System.out.println("对象转json："+JSON.toJSONString(subReport));
	}


}
