package com.putorn.powerdoc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        try {
            //核心API采用了极简设计，只需要一行代码
            XWPFTemplate template = XWPFTemplate.compile("C:\\Users\\mfhj-dz-001-502\\Documents\\temp1.docx");
            HashMap<String,Object> map = new HashMap<String, Object>();

            //文字替换
            map.put("reportName", "高 压 试 验 报 告");
            map.put("company", "八公桥变电站");
            map.put("deviceNames", "断路器 、避雷器、PT");
            map.put("runCode", "坊八2");
            map.put("experimental", "2017年度例行试验");
            map.put("testPeoples", "王元峰 刘亚兵");
            map.put("testMainPseron", "江峰");
            map.put("testDate", "2017年3月20日");
            map.put("checkPerson", " ");
            map.put("aduitPerson", " ");
            map.put("deviceName", "断路器");
            map.put("manufacturer", "山东泰开电力开关有限公司");

            //图片
            map.put("myPicture",new PictureRenderData(130,130,"C:\\Users\\mfhj-dz-001-502\\Pictures\\001.jpg"));


            //表格
            RowRenderData header = RowRenderData.build(new TextRenderData("6B8E23", "姓名"), new TextRenderData("6B8E23", "学历"));

            RowRenderData row0 = RowRenderData.build("张三", "研究生");
            RowRenderData row1 = RowRenderData.build("李四", "博士");
            RowRenderData row2 = RowRenderData.build("王五", "博士后");
            map.put("table", new MiniTableRenderData(header, Arrays.asList(row0, row1, row2)));


            //列表
            map.put("myList", new NumbericRenderData(new ArrayList<TextRenderData>() {
                {
                    add(new TextRenderData("Plug-in grammar"));
                    add(new TextRenderData("Supports word text, header..."));
                    add(new TextRenderData("Not just templates, but also style templates"));
                }
            }));


            template.render(map);
            template.writeToFile("out_template2.doc");
//            FileOutputStream out = new FileOutputStream("out_template1.doc");
//            template.write(out);
//            out.flush();
//            out.close();
            template.close();
//            Arrays.sort(new ArrayList);
        }catch (Exception e) {

        }
    }
}
