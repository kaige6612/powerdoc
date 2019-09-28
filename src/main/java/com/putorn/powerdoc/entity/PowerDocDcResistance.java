package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDocDcResistance的实体类")
public class PowerDocDcResistance extends BaseEntity{

        // 变压器直流电阻报告主键
        @ApiModelProperty(value = "变压器直流电阻报告主键",example = "")
		private Long dcResistanceId;
        // 所属报告id
        @ApiModelProperty(value = "所属报告id",example = "")
		private Long subreportId;
        // 直阻测试值-ab
        @ApiModelProperty(value = "直阻测试值-ab",example = "")
		private String dcAb;
        // 直阻测试值-bc
        @ApiModelProperty(value = "直阻测试值-bc",example = "")
		private String dcBc;
        // 直阻测试值-ca
        @ApiModelProperty(value = "直阻测试值-ca",example = "")
		private String dcCa;
        // 直阻测试值-斜杠
        @ApiModelProperty(value = "直阻测试值-斜杠",example = "")
		private String dcLast;
        // 换算至相电阻-ax
        @ApiModelProperty(value = "换算至相电阻-ax",example = "")
		private String convertAx;
        // 换算至相电阻-by
        @ApiModelProperty(value = "换算至相电阻-by",example = "")
		private String convertBy;
        // 换算至相电阻-cz
        @ApiModelProperty(value = "换算至相电阻-cz",example = "")
		private String convertCz;
        // 相间最大误差(%)
        @ApiModelProperty(value = "相间最大误差(%)",example = "")
		private String convertError;
        // 高压侧直阻（m）_1_AO
        @ApiModelProperty(value = "高压侧直阻（m）_1_AO",example = "")
		private String high1ao;
        // 高压侧直阻（m）_1_BO
        @ApiModelProperty(value = "高压侧直阻（m）_1_BO",example = "")
		private String high1bo;
        // 高压侧直阻（m）_1_CO
        @ApiModelProperty(value = "高压侧直阻（m）_1_CO",example = "")
		private String high1co;
        // 高压侧直阻（m）_1_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_1_相间最大误差(%)",example = "")
		private String high1error;
        // 中压侧直阻（m）_1_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_1_AmOm",example = "")
		private String middle1amOm;
        // 中压侧直阻（m）_1_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_1_BmOm",example = "")
		private String middle1bmOm;
        // 中压侧直阻（m）_1_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_1_CmOm",example = "")
		private String middle1cmOm;
        // 中压侧直阻（m）_1_error
        @ApiModelProperty(value = "中压侧直阻（m）_1_error",example = "")
		private String middle1error;
        // 高压侧直阻（m）_2_AO
        @ApiModelProperty(value = "高压侧直阻（m）_2_AO",example = "")
		private String high2ao;
        // 高压侧直阻（m）_2_BO
        @ApiModelProperty(value = "高压侧直阻（m）_2_BO",example = "")
		private String high2bo;
        // 高压侧直阻（m）_2_CO
        @ApiModelProperty(value = "高压侧直阻（m）_2_CO",example = "")
		private String high2co;
        // 高压侧直阻（m）_2_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_2_相间最大误差(%)",example = "")
		private String high2error;
        // 中压侧直阻（m）_2_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_2_AmOm",example = "")
		private String middle2amOm;
        // 中压侧直阻（m）_2_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_2_BmOm",example = "")
		private String middle2bmOm;
        // 中压侧直阻（m）_2_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_2_CmOm",example = "")
		private String middle2cmOm;
        // 中压侧直阻（m）_2_error
        @ApiModelProperty(value = "中压侧直阻（m）_2_error",example = "")
		private String middle2error;
        // 高压侧直阻（m）_3_AO
        @ApiModelProperty(value = "高压侧直阻（m）_3_AO",example = "")
		private String high3ao;
        // 高压侧直阻（m）_3_BO
        @ApiModelProperty(value = "高压侧直阻（m）_3_BO",example = "")
		private String high3bo;
        // 高压侧直阻（m）_3_CO
        @ApiModelProperty(value = "高压侧直阻（m）_3_CO",example = "")
		private String high3co;
        // 高压侧直阻（m）_3_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_3_相间最大误差(%)",example = "")
		private String high3error;
        // 中压侧直阻（m）_3_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_3_AmOm",example = "")
		private String middle3amOm;
        // 中压侧直阻（m）_3_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_3_BmOm",example = "")
		private String middle3bmOm;
        // 中压侧直阻（m）_3_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_3_CmOm",example = "")
		private String middle3cmOm;
        // 中压侧直阻（m）_3_error
        @ApiModelProperty(value = "中压侧直阻（m）_3_error",example = "")
		private String middle3error;
        // 高压侧直阻（m）_4_AO
        @ApiModelProperty(value = "高压侧直阻（m）_4_AO",example = "")
		private String high4ao;
        // 高压侧直阻（m）_4_BO
        @ApiModelProperty(value = "高压侧直阻（m）_4_BO",example = "")
		private String high4bo;
        // 高压侧直阻（m）_4_CO
        @ApiModelProperty(value = "高压侧直阻（m）_4_CO",example = "")
		private String high4co;
        // 高压侧直阻（m）_4_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_4_相间最大误差(%)",example = "")
		private String high4error;
        // 中压侧直阻（m）_4_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_4_AmOm",example = "")
		private String middle4amOm;
        // 中压侧直阻（m）_4_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_4_BmOm",example = "")
		private String middle4bmOm;
        // 中压侧直阻（m）_4_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_4_CmOm",example = "")
		private String middle4cmOm;
        // 中压侧直阻（m）_4_error
        @ApiModelProperty(value = "中压侧直阻（m）_4_error",example = "")
		private String middle4error;
        // 高压侧直阻（m）_5_AO
        @ApiModelProperty(value = "高压侧直阻（m）_5_AO",example = "")
		private String high5ao;
        // 高压侧直阻（m）_5_BO
        @ApiModelProperty(value = "高压侧直阻（m）_5_BO",example = "")
		private String high5bo;
        // 高压侧直阻（m）_5_CO
        @ApiModelProperty(value = "高压侧直阻（m）_5_CO",example = "")
		private String high5co;
        // 高压侧直阻（m）_5_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_5_相间最大误差(%)",example = "")
		private String high5error;
        // 中压侧直阻（m）_5_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_5_AmOm",example = "")
		private String middle5amOm;
        // 中压侧直阻（m）_5_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_5_BmOm",example = "")
		private String middle5bmOm;
        // 中压侧直阻（m）_5_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_5_CmOm",example = "")
		private String middle5cmOm;
        // 中压侧直阻（m）_5_error
        @ApiModelProperty(value = "中压侧直阻（m）_5_error",example = "")
		private String middle5error;
        // 高压侧直阻（m）_6_AO
        @ApiModelProperty(value = "高压侧直阻（m）_6_AO",example = "")
		private String high6ao;
        // 高压侧直阻（m）_6_BO
        @ApiModelProperty(value = "高压侧直阻（m）_6_BO",example = "")
		private String high6bo;
        // 高压侧直阻（m）_6_CO
        @ApiModelProperty(value = "高压侧直阻（m）_6_CO",example = "")
		private String high6co;
        // 高压侧直阻（m）_6_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_6_相间最大误差(%)",example = "")
		private String high6error;
        // 中压侧直阻（m）_6_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_6_AmOm",example = "")
		private String middle6amOm;
        // 中压侧直阻（m）_6_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_6_BmOm",example = "")
		private String middle6bmOm;
        // 中压侧直阻（m）_6_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_6_CmOm",example = "")
		private String middle6cmOm;
        // 中压侧直阻（m）_6_error
        @ApiModelProperty(value = "中压侧直阻（m）_6_error",example = "")
		private String middle6error;
        // 高压侧直阻（m）_7_AO
        @ApiModelProperty(value = "高压侧直阻（m）_7_AO",example = "")
		private String high7ao;
        // 高压侧直阻（m）_7_BO
        @ApiModelProperty(value = "高压侧直阻（m）_7_BO",example = "")
		private String high7bo;
        // 高压侧直阻（m）_7_CO
        @ApiModelProperty(value = "高压侧直阻（m）_7_CO",example = "")
		private String high7co;
        // 高压侧直阻（m）_7_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_7_相间最大误差(%)",example = "")
		private String high7error;
        // 中压侧直阻（m）_7_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_7_AmOm",example = "")
		private String middle7amOm;
        // 中压侧直阻（m）_7_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_7_BmOm",example = "")
		private String middle7bmOm;
        // 中压侧直阻（m）_7_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_7_CmOm",example = "")
		private String middle7cmOm;
        // 中压侧直阻（m）_7_error
        @ApiModelProperty(value = "中压侧直阻（m）_7_error",example = "")
		private String middle7error;
        // 高压侧直阻（m）_8_AO
        @ApiModelProperty(value = "高压侧直阻（m）_8_AO",example = "")
		private String high8ao;
        // 高压侧直阻（m）_8_BO
        @ApiModelProperty(value = "高压侧直阻（m）_8_BO",example = "")
		private String high8bo;
        // 高压侧直阻（m）_8_CO
        @ApiModelProperty(value = "高压侧直阻（m）_8_CO",example = "")
		private String high8co;
        // 高压侧直阻（m）_8_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_8_相间最大误差(%)",example = "")
		private String high8error;
        // 中压侧直阻（m）_8_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_8_AmOm",example = "")
		private String middle8amOm;
        // 中压侧直阻（m）_8_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_8_BmOm",example = "")
		private String middle8bmOm;
        // 中压侧直阻（m）_8_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_8_CmOm",example = "")
		private String middle8cmOm;
        // 中压侧直阻（m）_8_error
        @ApiModelProperty(value = "中压侧直阻（m）_8_error",example = "")
		private String middle8error;
        // 高压侧直阻（m）_9b_AO
        @ApiModelProperty(value = "高压侧直阻（m）_9b_AO",example = "")
		private String high9bAo;
        // 高压侧直阻（m）_9b_BO
        @ApiModelProperty(value = "高压侧直阻（m）_9b_BO",example = "")
		private String high9bBo;
        // 高压侧直阻（m）_9b_CO
        @ApiModelProperty(value = "高压侧直阻（m）_9b_CO",example = "")
		private String high9bCo;
        // 高压侧直阻（m）_9b_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_9b_相间最大误差(%)",example = "")
		private String high9bError;
        // 中压侧直阻（m）_9b_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_9b_AmOm",example = "")
		private String middle9bAmOm;
        // 中压侧直阻（m）_9b_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_9b_BmOm",example = "")
		private String middle9bBmOm;
        // 中压侧直阻（m）_9b_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_9b_CmOm",example = "")
		private String middle9bCmOm;
        // 中压侧直阻（m）_9b_error
        @ApiModelProperty(value = "中压侧直阻（m）_9b_error",example = "")
		private String middle9bError;
        // 高压侧直阻（m）_10_AO
        @ApiModelProperty(value = "高压侧直阻（m）_10_AO",example = "")
		private String high10Ao;
        // 高压侧直阻（m）_10_BO
        @ApiModelProperty(value = "高压侧直阻（m）_10_BO",example = "")
		private String high10Bo;
        // 高压侧直阻（m）_10_CO
        @ApiModelProperty(value = "高压侧直阻（m）_10_CO",example = "")
		private String high10Co;
        // 高压侧直阻（m）_10_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_10_相间最大误差(%)",example = "")
		private String high10Error;
        // 中压侧直阻（m）_10_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_10_AmOm",example = "")
		private String middle10AmOm;
        // 中压侧直阻（m）_10_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_10_BmOm",example = "")
		private String middle10BmOm;
        // 中压侧直阻（m）_10_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_10_CmOm",example = "")
		private String middle10CmOm;
        // 中压侧直阻（m）_10_error
        @ApiModelProperty(value = "中压侧直阻（m）_10_error",example = "")
		private String middle10Error;
        // 高压侧直阻（m）_11_AO
        @ApiModelProperty(value = "高压侧直阻（m）_11_AO",example = "")
		private String high11Ao;
        // 高压侧直阻（m）_11_BO
        @ApiModelProperty(value = "高压侧直阻（m）_11_BO",example = "")
		private String high11Bo;
        // 高压侧直阻（m）_11_CO
        @ApiModelProperty(value = "高压侧直阻（m）_11_CO",example = "")
		private String high11Co;
        // 高压侧直阻（m）_11_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_11_相间最大误差(%)",example = "")
		private String high11Error;
        // 中压侧直阻（m）_11_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_11_AmOm",example = "")
		private String middle11AmOm;
        // 中压侧直阻（m）_11_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_11_BmOm",example = "")
		private String middle11BmOm;
        // 中压侧直阻（m）_11_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_11_CmOm",example = "")
		private String middle11CmOm;
        // 中压侧直阻（m）_11_error
        @ApiModelProperty(value = "中压侧直阻（m）_11_error",example = "")
		private String middle11Error;
        // 高压侧直阻（m）_12_AO
        @ApiModelProperty(value = "高压侧直阻（m）_12_AO",example = "")
		private String high12Ao;
        // 高压侧直阻（m）_12_BO
        @ApiModelProperty(value = "高压侧直阻（m）_12_BO",example = "")
		private String high12Bo;
        // 高压侧直阻（m）_12_CO
        @ApiModelProperty(value = "高压侧直阻（m）_12_CO",example = "")
		private String high12Co;
        // 高压侧直阻（m）_12_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_12_相间最大误差(%)",example = "")
		private String high12Error;
        // 中压侧直阻（m）_12_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_12_AmOm",example = "")
		private String middle12AmOm;
        // 中压侧直阻（m）_12_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_12_BmOm",example = "")
		private String middle12BmOm;
        // 中压侧直阻（m）_12_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_12_CmOm",example = "")
		private String middle12CmOm;
        // 中压侧直阻（m）_12_error
        @ApiModelProperty(value = "中压侧直阻（m）_12_error",example = "")
		private String middle12Error;
        // 高压侧直阻（m）_13_AO
        @ApiModelProperty(value = "高压侧直阻（m）_13_AO",example = "")
		private String high13Ao;
        // 高压侧直阻（m）_13_BO
        @ApiModelProperty(value = "高压侧直阻（m）_13_BO",example = "")
		private String high13Bo;
        // 高压侧直阻（m）_13_CO
        @ApiModelProperty(value = "高压侧直阻（m）_13_CO",example = "")
		private String high13Co;
        // 高压侧直阻（m）_13_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_13_相间最大误差(%)",example = "")
		private String high13Error;
        // 中压侧直阻（m）_13_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_13_AmOm",example = "")
		private String middle13AmOm;
        // 中压侧直阻（m）_13_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_13_BmOm",example = "")
		private String middle13BmOm;
        // 中压侧直阻（m）_13_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_13_CmOm",example = "")
		private String middle13CmOm;
        // 中压侧直阻（m）_13_error
        @ApiModelProperty(value = "中压侧直阻（m）_13_error",example = "")
		private String middle13Error;
        // 高压侧直阻（m）_14_AO
        @ApiModelProperty(value = "高压侧直阻（m）_14_AO",example = "")
		private String high14Ao;
        // 高压侧直阻（m）_14_BO
        @ApiModelProperty(value = "高压侧直阻（m）_14_BO",example = "")
		private String high14Bo;
        // 高压侧直阻（m）_14_CO
        @ApiModelProperty(value = "高压侧直阻（m）_14_CO",example = "")
		private String high14Co;
        // 高压侧直阻（m）_14_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_14_相间最大误差(%)",example = "")
		private String high14Error;
        // 中压侧直阻（m）_14_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_14_AmOm",example = "")
		private String middle14AmOm;
        // 中压侧直阻（m）_14_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_14_BmOm",example = "")
		private String middle14BmOm;
        // 中压侧直阻（m）_14_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_14_CmOm",example = "")
		private String middle14CmOm;
        // 中压侧直阻（m）_14_error
        @ApiModelProperty(value = "中压侧直阻（m）_14_error",example = "")
		private String middle14Error;
        // 高压侧直阻（m）_15_AO
        @ApiModelProperty(value = "高压侧直阻（m）_15_AO",example = "")
		private String high15Ao;
        // 高压侧直阻（m）_15_BO
        @ApiModelProperty(value = "高压侧直阻（m）_15_BO",example = "")
		private String high15Bo;
        // 高压侧直阻（m）_15_CO
        @ApiModelProperty(value = "高压侧直阻（m）_15_CO",example = "")
		private String high15Co;
        // 高压侧直阻（m）_15_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_15_相间最大误差(%)",example = "")
		private String high15Error;
        // 中压侧直阻（m）_15_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_15_AmOm",example = "")
		private String middle15AmOm;
        // 中压侧直阻（m）_15_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_15_BmOm",example = "")
		private String middle15BmOm;
        // 中压侧直阻（m）_15_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_15_CmOm",example = "")
		private String middle15CmOm;
        // 中压侧直阻（m）_15_error
        @ApiModelProperty(value = "中压侧直阻（m）_15_error",example = "")
		private String middle15Error;
        // 高压侧直阻（m）_16_AO
        @ApiModelProperty(value = "高压侧直阻（m）_16_AO",example = "")
		private String high16Ao;
        // 高压侧直阻（m）_16_BO
        @ApiModelProperty(value = "高压侧直阻（m）_16_BO",example = "")
		private String high16Bo;
        // 高压侧直阻（m）_16_CO
        @ApiModelProperty(value = "高压侧直阻（m）_16_CO",example = "")
		private String high16Co;
        // 高压侧直阻（m）_16_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_16_相间最大误差(%)",example = "")
		private String high16Error;
        // 中压侧直阻（m）_16_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_16_AmOm",example = "")
		private String middle16AmOm;
        // 中压侧直阻（m）_16_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_16_BmOm",example = "")
		private String middle16BmOm;
        // 中压侧直阻（m）_16_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_16_CmOm",example = "")
		private String middle16CmOm;
        // 中压侧直阻（m）_16_error
        @ApiModelProperty(value = "中压侧直阻（m）_16_error",example = "")
		private String middle16Error;
        // 高压侧直阻（m）_17_AO
        @ApiModelProperty(value = "高压侧直阻（m）_17_AO",example = "")
		private String high17Ao;
        // 高压侧直阻（m）_17_BO
        @ApiModelProperty(value = "高压侧直阻（m）_17_BO",example = "")
		private String high17Bo;
        // 高压侧直阻（m）_17_CO
        @ApiModelProperty(value = "高压侧直阻（m）_17_CO",example = "")
		private String high17Co;
        // 高压侧直阻（m）_17_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_17_相间最大误差(%)",example = "")
		private String high17Error;
        // 中压侧直阻（m）_17_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_17_AmOm",example = "")
		private String middle17AmOm;
        // 中压侧直阻（m）_17_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_17_BmOm",example = "")
		private String middle17BmOm;
        // 中压侧直阻（m）_17_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_17_CmOm",example = "")
		private String middle17CmOm;
        // 中压侧直阻（m）_17_error
        @ApiModelProperty(value = "中压侧直阻（m）_17_error",example = "")
		private String middle17Error;
        // 添加人id
        @ApiModelProperty(value = "添加人id",example = "")
		private Integer addUserid;
        // 添加人姓名
        @ApiModelProperty(value = "添加人姓名",example = "")
		private String addUsername;
        // 添加时间
        @ApiModelProperty(value = "添加时间",example = "")
		private java.sql.Timestamp addtime;
        // 修改人id
        @ApiModelProperty(value = "修改人id",example = "")
		private Integer editUserid;
        // 修改人姓名
        @ApiModelProperty(value = "修改人姓名",example = "")
		private String editUsername;
        // 修改时间
        @ApiModelProperty(value = "修改时间",example = "")
		private java.sql.Timestamp edittime;



	public void setDcResistanceId(Long dcResistanceId) {
		this.dcResistanceId = dcResistanceId;
	}
	public Long getDcResistanceId() {
		return this.dcResistanceId;
	}
	public void setSubreportId(Long subreportId) {
		this.subreportId = subreportId;
	}
	public Long getSubreportId() {
		return this.subreportId;
	}
	public void setDcAb(String dcAb) {
		this.dcAb = dcAb;
	}
	public String getDcAb() {
		return this.dcAb;
	}
	public void setDcBc(String dcBc) {
		this.dcBc = dcBc;
	}
	public String getDcBc() {
		return this.dcBc;
	}
	public void setDcCa(String dcCa) {
		this.dcCa = dcCa;
	}
	public String getDcCa() {
		return this.dcCa;
	}
	public void setDcLast(String dcLast) {
		this.dcLast = dcLast;
	}
	public String getDcLast() {
		return this.dcLast;
	}
	public void setConvertAx(String convertAx) {
		this.convertAx = convertAx;
	}
	public String getConvertAx() {
		return this.convertAx;
	}
	public void setConvertBy(String convertBy) {
		this.convertBy = convertBy;
	}
	public String getConvertBy() {
		return this.convertBy;
	}
	public void setConvertCz(String convertCz) {
		this.convertCz = convertCz;
	}
	public String getConvertCz() {
		return this.convertCz;
	}
	public void setConvertError(String convertError) {
		this.convertError = convertError;
	}
	public String getConvertError() {
		return this.convertError;
	}
	public void setHigh1ao(String high1ao) {
		this.high1ao = high1ao;
	}
	public String getHigh1ao() {
		return this.high1ao;
	}
	public void setHigh1bo(String high1bo) {
		this.high1bo = high1bo;
	}
	public String getHigh1bo() {
		return this.high1bo;
	}
	public void setHigh1co(String high1co) {
		this.high1co = high1co;
	}
	public String getHigh1co() {
		return this.high1co;
	}
	public void setHigh1error(String high1error) {
		this.high1error = high1error;
	}
	public String getHigh1error() {
		return this.high1error;
	}
	public void setMiddle1amOm(String middle1amOm) {
		this.middle1amOm = middle1amOm;
	}
	public String getMiddle1amOm() {
		return this.middle1amOm;
	}
	public void setMiddle1bmOm(String middle1bmOm) {
		this.middle1bmOm = middle1bmOm;
	}
	public String getMiddle1bmOm() {
		return this.middle1bmOm;
	}
	public void setMiddle1cmOm(String middle1cmOm) {
		this.middle1cmOm = middle1cmOm;
	}
	public String getMiddle1cmOm() {
		return this.middle1cmOm;
	}
	public void setMiddle1error(String middle1error) {
		this.middle1error = middle1error;
	}
	public String getMiddle1error() {
		return this.middle1error;
	}
	public void setHigh2ao(String high2ao) {
		this.high2ao = high2ao;
	}
	public String getHigh2ao() {
		return this.high2ao;
	}
	public void setHigh2bo(String high2bo) {
		this.high2bo = high2bo;
	}
	public String getHigh2bo() {
		return this.high2bo;
	}
	public void setHigh2co(String high2co) {
		this.high2co = high2co;
	}
	public String getHigh2co() {
		return this.high2co;
	}
	public void setHigh2error(String high2error) {
		this.high2error = high2error;
	}
	public String getHigh2error() {
		return this.high2error;
	}
	public void setMiddle2amOm(String middle2amOm) {
		this.middle2amOm = middle2amOm;
	}
	public String getMiddle2amOm() {
		return this.middle2amOm;
	}
	public void setMiddle2bmOm(String middle2bmOm) {
		this.middle2bmOm = middle2bmOm;
	}
	public String getMiddle2bmOm() {
		return this.middle2bmOm;
	}
	public void setMiddle2cmOm(String middle2cmOm) {
		this.middle2cmOm = middle2cmOm;
	}
	public String getMiddle2cmOm() {
		return this.middle2cmOm;
	}
	public void setMiddle2error(String middle2error) {
		this.middle2error = middle2error;
	}
	public String getMiddle2error() {
		return this.middle2error;
	}
	public void setHigh3ao(String high3ao) {
		this.high3ao = high3ao;
	}
	public String getHigh3ao() {
		return this.high3ao;
	}
	public void setHigh3bo(String high3bo) {
		this.high3bo = high3bo;
	}
	public String getHigh3bo() {
		return this.high3bo;
	}
	public void setHigh3co(String high3co) {
		this.high3co = high3co;
	}
	public String getHigh3co() {
		return this.high3co;
	}
	public void setHigh3error(String high3error) {
		this.high3error = high3error;
	}
	public String getHigh3error() {
		return this.high3error;
	}
	public void setMiddle3amOm(String middle3amOm) {
		this.middle3amOm = middle3amOm;
	}
	public String getMiddle3amOm() {
		return this.middle3amOm;
	}
	public void setMiddle3bmOm(String middle3bmOm) {
		this.middle3bmOm = middle3bmOm;
	}
	public String getMiddle3bmOm() {
		return this.middle3bmOm;
	}
	public void setMiddle3cmOm(String middle3cmOm) {
		this.middle3cmOm = middle3cmOm;
	}
	public String getMiddle3cmOm() {
		return this.middle3cmOm;
	}
	public void setMiddle3error(String middle3error) {
		this.middle3error = middle3error;
	}
	public String getMiddle3error() {
		return this.middle3error;
	}
	public void setHigh4ao(String high4ao) {
		this.high4ao = high4ao;
	}
	public String getHigh4ao() {
		return this.high4ao;
	}
	public void setHigh4bo(String high4bo) {
		this.high4bo = high4bo;
	}
	public String getHigh4bo() {
		return this.high4bo;
	}
	public void setHigh4co(String high4co) {
		this.high4co = high4co;
	}
	public String getHigh4co() {
		return this.high4co;
	}
	public void setHigh4error(String high4error) {
		this.high4error = high4error;
	}
	public String getHigh4error() {
		return this.high4error;
	}
	public void setMiddle4amOm(String middle4amOm) {
		this.middle4amOm = middle4amOm;
	}
	public String getMiddle4amOm() {
		return this.middle4amOm;
	}
	public void setMiddle4bmOm(String middle4bmOm) {
		this.middle4bmOm = middle4bmOm;
	}
	public String getMiddle4bmOm() {
		return this.middle4bmOm;
	}
	public void setMiddle4cmOm(String middle4cmOm) {
		this.middle4cmOm = middle4cmOm;
	}
	public String getMiddle4cmOm() {
		return this.middle4cmOm;
	}
	public void setMiddle4error(String middle4error) {
		this.middle4error = middle4error;
	}
	public String getMiddle4error() {
		return this.middle4error;
	}
	public void setHigh5ao(String high5ao) {
		this.high5ao = high5ao;
	}
	public String getHigh5ao() {
		return this.high5ao;
	}
	public void setHigh5bo(String high5bo) {
		this.high5bo = high5bo;
	}
	public String getHigh5bo() {
		return this.high5bo;
	}
	public void setHigh5co(String high5co) {
		this.high5co = high5co;
	}
	public String getHigh5co() {
		return this.high5co;
	}
	public void setHigh5error(String high5error) {
		this.high5error = high5error;
	}
	public String getHigh5error() {
		return this.high5error;
	}
	public void setMiddle5amOm(String middle5amOm) {
		this.middle5amOm = middle5amOm;
	}
	public String getMiddle5amOm() {
		return this.middle5amOm;
	}
	public void setMiddle5bmOm(String middle5bmOm) {
		this.middle5bmOm = middle5bmOm;
	}
	public String getMiddle5bmOm() {
		return this.middle5bmOm;
	}
	public void setMiddle5cmOm(String middle5cmOm) {
		this.middle5cmOm = middle5cmOm;
	}
	public String getMiddle5cmOm() {
		return this.middle5cmOm;
	}
	public void setMiddle5error(String middle5error) {
		this.middle5error = middle5error;
	}
	public String getMiddle5error() {
		return this.middle5error;
	}
	public void setHigh6ao(String high6ao) {
		this.high6ao = high6ao;
	}
	public String getHigh6ao() {
		return this.high6ao;
	}
	public void setHigh6bo(String high6bo) {
		this.high6bo = high6bo;
	}
	public String getHigh6bo() {
		return this.high6bo;
	}
	public void setHigh6co(String high6co) {
		this.high6co = high6co;
	}
	public String getHigh6co() {
		return this.high6co;
	}
	public void setHigh6error(String high6error) {
		this.high6error = high6error;
	}
	public String getHigh6error() {
		return this.high6error;
	}
	public void setMiddle6amOm(String middle6amOm) {
		this.middle6amOm = middle6amOm;
	}
	public String getMiddle6amOm() {
		return this.middle6amOm;
	}
	public void setMiddle6bmOm(String middle6bmOm) {
		this.middle6bmOm = middle6bmOm;
	}
	public String getMiddle6bmOm() {
		return this.middle6bmOm;
	}
	public void setMiddle6cmOm(String middle6cmOm) {
		this.middle6cmOm = middle6cmOm;
	}
	public String getMiddle6cmOm() {
		return this.middle6cmOm;
	}
	public void setMiddle6error(String middle6error) {
		this.middle6error = middle6error;
	}
	public String getMiddle6error() {
		return this.middle6error;
	}
	public void setHigh7ao(String high7ao) {
		this.high7ao = high7ao;
	}
	public String getHigh7ao() {
		return this.high7ao;
	}
	public void setHigh7bo(String high7bo) {
		this.high7bo = high7bo;
	}
	public String getHigh7bo() {
		return this.high7bo;
	}
	public void setHigh7co(String high7co) {
		this.high7co = high7co;
	}
	public String getHigh7co() {
		return this.high7co;
	}
	public void setHigh7error(String high7error) {
		this.high7error = high7error;
	}
	public String getHigh7error() {
		return this.high7error;
	}
	public void setMiddle7amOm(String middle7amOm) {
		this.middle7amOm = middle7amOm;
	}
	public String getMiddle7amOm() {
		return this.middle7amOm;
	}
	public void setMiddle7bmOm(String middle7bmOm) {
		this.middle7bmOm = middle7bmOm;
	}
	public String getMiddle7bmOm() {
		return this.middle7bmOm;
	}
	public void setMiddle7cmOm(String middle7cmOm) {
		this.middle7cmOm = middle7cmOm;
	}
	public String getMiddle7cmOm() {
		return this.middle7cmOm;
	}
	public void setMiddle7error(String middle7error) {
		this.middle7error = middle7error;
	}
	public String getMiddle7error() {
		return this.middle7error;
	}
	public void setHigh8ao(String high8ao) {
		this.high8ao = high8ao;
	}
	public String getHigh8ao() {
		return this.high8ao;
	}
	public void setHigh8bo(String high8bo) {
		this.high8bo = high8bo;
	}
	public String getHigh8bo() {
		return this.high8bo;
	}
	public void setHigh8co(String high8co) {
		this.high8co = high8co;
	}
	public String getHigh8co() {
		return this.high8co;
	}
	public void setHigh8error(String high8error) {
		this.high8error = high8error;
	}
	public String getHigh8error() {
		return this.high8error;
	}
	public void setMiddle8amOm(String middle8amOm) {
		this.middle8amOm = middle8amOm;
	}
	public String getMiddle8amOm() {
		return this.middle8amOm;
	}
	public void setMiddle8bmOm(String middle8bmOm) {
		this.middle8bmOm = middle8bmOm;
	}
	public String getMiddle8bmOm() {
		return this.middle8bmOm;
	}
	public void setMiddle8cmOm(String middle8cmOm) {
		this.middle8cmOm = middle8cmOm;
	}
	public String getMiddle8cmOm() {
		return this.middle8cmOm;
	}
	public void setMiddle8error(String middle8error) {
		this.middle8error = middle8error;
	}
	public String getMiddle8error() {
		return this.middle8error;
	}
	public void setHigh9bAo(String high9bAo) {
		this.high9bAo = high9bAo;
	}
	public String getHigh9bAo() {
		return this.high9bAo;
	}
	public void setHigh9bBo(String high9bBo) {
		this.high9bBo = high9bBo;
	}
	public String getHigh9bBo() {
		return this.high9bBo;
	}
	public void setHigh9bCo(String high9bCo) {
		this.high9bCo = high9bCo;
	}
	public String getHigh9bCo() {
		return this.high9bCo;
	}
	public void setHigh9bError(String high9bError) {
		this.high9bError = high9bError;
	}
	public String getHigh9bError() {
		return this.high9bError;
	}
	public void setMiddle9bAmOm(String middle9bAmOm) {
		this.middle9bAmOm = middle9bAmOm;
	}
	public String getMiddle9bAmOm() {
		return this.middle9bAmOm;
	}
	public void setMiddle9bBmOm(String middle9bBmOm) {
		this.middle9bBmOm = middle9bBmOm;
	}
	public String getMiddle9bBmOm() {
		return this.middle9bBmOm;
	}
	public void setMiddle9bCmOm(String middle9bCmOm) {
		this.middle9bCmOm = middle9bCmOm;
	}
	public String getMiddle9bCmOm() {
		return this.middle9bCmOm;
	}
	public void setMiddle9bError(String middle9bError) {
		this.middle9bError = middle9bError;
	}
	public String getMiddle9bError() {
		return this.middle9bError;
	}
	public void setHigh10Ao(String high10Ao) {
		this.high10Ao = high10Ao;
	}
	public String getHigh10Ao() {
		return this.high10Ao;
	}
	public void setHigh10Bo(String high10Bo) {
		this.high10Bo = high10Bo;
	}
	public String getHigh10Bo() {
		return this.high10Bo;
	}
	public void setHigh10Co(String high10Co) {
		this.high10Co = high10Co;
	}
	public String getHigh10Co() {
		return this.high10Co;
	}
	public void setHigh10Error(String high10Error) {
		this.high10Error = high10Error;
	}
	public String getHigh10Error() {
		return this.high10Error;
	}
	public void setMiddle10AmOm(String middle10AmOm) {
		this.middle10AmOm = middle10AmOm;
	}
	public String getMiddle10AmOm() {
		return this.middle10AmOm;
	}
	public void setMiddle10BmOm(String middle10BmOm) {
		this.middle10BmOm = middle10BmOm;
	}
	public String getMiddle10BmOm() {
		return this.middle10BmOm;
	}
	public void setMiddle10CmOm(String middle10CmOm) {
		this.middle10CmOm = middle10CmOm;
	}
	public String getMiddle10CmOm() {
		return this.middle10CmOm;
	}
	public void setMiddle10Error(String middle10Error) {
		this.middle10Error = middle10Error;
	}
	public String getMiddle10Error() {
		return this.middle10Error;
	}
	public void setHigh11Ao(String high11Ao) {
		this.high11Ao = high11Ao;
	}
	public String getHigh11Ao() {
		return this.high11Ao;
	}
	public void setHigh11Bo(String high11Bo) {
		this.high11Bo = high11Bo;
	}
	public String getHigh11Bo() {
		return this.high11Bo;
	}
	public void setHigh11Co(String high11Co) {
		this.high11Co = high11Co;
	}
	public String getHigh11Co() {
		return this.high11Co;
	}
	public void setHigh11Error(String high11Error) {
		this.high11Error = high11Error;
	}
	public String getHigh11Error() {
		return this.high11Error;
	}
	public void setMiddle11AmOm(String middle11AmOm) {
		this.middle11AmOm = middle11AmOm;
	}
	public String getMiddle11AmOm() {
		return this.middle11AmOm;
	}
	public void setMiddle11BmOm(String middle11BmOm) {
		this.middle11BmOm = middle11BmOm;
	}
	public String getMiddle11BmOm() {
		return this.middle11BmOm;
	}
	public void setMiddle11CmOm(String middle11CmOm) {
		this.middle11CmOm = middle11CmOm;
	}
	public String getMiddle11CmOm() {
		return this.middle11CmOm;
	}
	public void setMiddle11Error(String middle11Error) {
		this.middle11Error = middle11Error;
	}
	public String getMiddle11Error() {
		return this.middle11Error;
	}
	public void setHigh12Ao(String high12Ao) {
		this.high12Ao = high12Ao;
	}
	public String getHigh12Ao() {
		return this.high12Ao;
	}
	public void setHigh12Bo(String high12Bo) {
		this.high12Bo = high12Bo;
	}
	public String getHigh12Bo() {
		return this.high12Bo;
	}
	public void setHigh12Co(String high12Co) {
		this.high12Co = high12Co;
	}
	public String getHigh12Co() {
		return this.high12Co;
	}
	public void setHigh12Error(String high12Error) {
		this.high12Error = high12Error;
	}
	public String getHigh12Error() {
		return this.high12Error;
	}
	public void setMiddle12AmOm(String middle12AmOm) {
		this.middle12AmOm = middle12AmOm;
	}
	public String getMiddle12AmOm() {
		return this.middle12AmOm;
	}
	public void setMiddle12BmOm(String middle12BmOm) {
		this.middle12BmOm = middle12BmOm;
	}
	public String getMiddle12BmOm() {
		return this.middle12BmOm;
	}
	public void setMiddle12CmOm(String middle12CmOm) {
		this.middle12CmOm = middle12CmOm;
	}
	public String getMiddle12CmOm() {
		return this.middle12CmOm;
	}
	public void setMiddle12Error(String middle12Error) {
		this.middle12Error = middle12Error;
	}
	public String getMiddle12Error() {
		return this.middle12Error;
	}
	public void setHigh13Ao(String high13Ao) {
		this.high13Ao = high13Ao;
	}
	public String getHigh13Ao() {
		return this.high13Ao;
	}
	public void setHigh13Bo(String high13Bo) {
		this.high13Bo = high13Bo;
	}
	public String getHigh13Bo() {
		return this.high13Bo;
	}
	public void setHigh13Co(String high13Co) {
		this.high13Co = high13Co;
	}
	public String getHigh13Co() {
		return this.high13Co;
	}
	public void setHigh13Error(String high13Error) {
		this.high13Error = high13Error;
	}
	public String getHigh13Error() {
		return this.high13Error;
	}
	public void setMiddle13AmOm(String middle13AmOm) {
		this.middle13AmOm = middle13AmOm;
	}
	public String getMiddle13AmOm() {
		return this.middle13AmOm;
	}
	public void setMiddle13BmOm(String middle13BmOm) {
		this.middle13BmOm = middle13BmOm;
	}
	public String getMiddle13BmOm() {
		return this.middle13BmOm;
	}
	public void setMiddle13CmOm(String middle13CmOm) {
		this.middle13CmOm = middle13CmOm;
	}
	public String getMiddle13CmOm() {
		return this.middle13CmOm;
	}
	public void setMiddle13Error(String middle13Error) {
		this.middle13Error = middle13Error;
	}
	public String getMiddle13Error() {
		return this.middle13Error;
	}
	public void setHigh14Ao(String high14Ao) {
		this.high14Ao = high14Ao;
	}
	public String getHigh14Ao() {
		return this.high14Ao;
	}
	public void setHigh14Bo(String high14Bo) {
		this.high14Bo = high14Bo;
	}
	public String getHigh14Bo() {
		return this.high14Bo;
	}
	public void setHigh14Co(String high14Co) {
		this.high14Co = high14Co;
	}
	public String getHigh14Co() {
		return this.high14Co;
	}
	public void setHigh14Error(String high14Error) {
		this.high14Error = high14Error;
	}
	public String getHigh14Error() {
		return this.high14Error;
	}
	public void setMiddle14AmOm(String middle14AmOm) {
		this.middle14AmOm = middle14AmOm;
	}
	public String getMiddle14AmOm() {
		return this.middle14AmOm;
	}
	public void setMiddle14BmOm(String middle14BmOm) {
		this.middle14BmOm = middle14BmOm;
	}
	public String getMiddle14BmOm() {
		return this.middle14BmOm;
	}
	public void setMiddle14CmOm(String middle14CmOm) {
		this.middle14CmOm = middle14CmOm;
	}
	public String getMiddle14CmOm() {
		return this.middle14CmOm;
	}
	public void setMiddle14Error(String middle14Error) {
		this.middle14Error = middle14Error;
	}
	public String getMiddle14Error() {
		return this.middle14Error;
	}
	public void setHigh15Ao(String high15Ao) {
		this.high15Ao = high15Ao;
	}
	public String getHigh15Ao() {
		return this.high15Ao;
	}
	public void setHigh15Bo(String high15Bo) {
		this.high15Bo = high15Bo;
	}
	public String getHigh15Bo() {
		return this.high15Bo;
	}
	public void setHigh15Co(String high15Co) {
		this.high15Co = high15Co;
	}
	public String getHigh15Co() {
		return this.high15Co;
	}
	public void setHigh15Error(String high15Error) {
		this.high15Error = high15Error;
	}
	public String getHigh15Error() {
		return this.high15Error;
	}
	public void setMiddle15AmOm(String middle15AmOm) {
		this.middle15AmOm = middle15AmOm;
	}
	public String getMiddle15AmOm() {
		return this.middle15AmOm;
	}
	public void setMiddle15BmOm(String middle15BmOm) {
		this.middle15BmOm = middle15BmOm;
	}
	public String getMiddle15BmOm() {
		return this.middle15BmOm;
	}
	public void setMiddle15CmOm(String middle15CmOm) {
		this.middle15CmOm = middle15CmOm;
	}
	public String getMiddle15CmOm() {
		return this.middle15CmOm;
	}
	public void setMiddle15Error(String middle15Error) {
		this.middle15Error = middle15Error;
	}
	public String getMiddle15Error() {
		return this.middle15Error;
	}
	public void setHigh16Ao(String high16Ao) {
		this.high16Ao = high16Ao;
	}
	public String getHigh16Ao() {
		return this.high16Ao;
	}
	public void setHigh16Bo(String high16Bo) {
		this.high16Bo = high16Bo;
	}
	public String getHigh16Bo() {
		return this.high16Bo;
	}
	public void setHigh16Co(String high16Co) {
		this.high16Co = high16Co;
	}
	public String getHigh16Co() {
		return this.high16Co;
	}
	public void setHigh16Error(String high16Error) {
		this.high16Error = high16Error;
	}
	public String getHigh16Error() {
		return this.high16Error;
	}
	public void setMiddle16AmOm(String middle16AmOm) {
		this.middle16AmOm = middle16AmOm;
	}
	public String getMiddle16AmOm() {
		return this.middle16AmOm;
	}
	public void setMiddle16BmOm(String middle16BmOm) {
		this.middle16BmOm = middle16BmOm;
	}
	public String getMiddle16BmOm() {
		return this.middle16BmOm;
	}
	public void setMiddle16CmOm(String middle16CmOm) {
		this.middle16CmOm = middle16CmOm;
	}
	public String getMiddle16CmOm() {
		return this.middle16CmOm;
	}
	public void setMiddle16Error(String middle16Error) {
		this.middle16Error = middle16Error;
	}
	public String getMiddle16Error() {
		return this.middle16Error;
	}
	public void setHigh17Ao(String high17Ao) {
		this.high17Ao = high17Ao;
	}
	public String getHigh17Ao() {
		return this.high17Ao;
	}
	public void setHigh17Bo(String high17Bo) {
		this.high17Bo = high17Bo;
	}
	public String getHigh17Bo() {
		return this.high17Bo;
	}
	public void setHigh17Co(String high17Co) {
		this.high17Co = high17Co;
	}
	public String getHigh17Co() {
		return this.high17Co;
	}
	public void setHigh17Error(String high17Error) {
		this.high17Error = high17Error;
	}
	public String getHigh17Error() {
		return this.high17Error;
	}
	public void setMiddle17AmOm(String middle17AmOm) {
		this.middle17AmOm = middle17AmOm;
	}
	public String getMiddle17AmOm() {
		return this.middle17AmOm;
	}
	public void setMiddle17BmOm(String middle17BmOm) {
		this.middle17BmOm = middle17BmOm;
	}
	public String getMiddle17BmOm() {
		return this.middle17BmOm;
	}
	public void setMiddle17CmOm(String middle17CmOm) {
		this.middle17CmOm = middle17CmOm;
	}
	public String getMiddle17CmOm() {
		return this.middle17CmOm;
	}
	public void setMiddle17Error(String middle17Error) {
		this.middle17Error = middle17Error;
	}
	public String getMiddle17Error() {
		return this.middle17Error;
	}
	public void setAddUserid(Integer addUserid) {
		this.addUserid = addUserid;
	}
	public Integer getAddUserid() {
		return this.addUserid;
	}
	public void setAddUsername(String addUsername) {
		this.addUsername = addUsername;
	}
	public String getAddUsername() {
		return this.addUsername;
	}
	public void setAddtime(java.sql.Timestamp addtime) {
		this.addtime = addtime;
	}
	public java.sql.Timestamp getAddtime() {
		return this.addtime;
	}
	public void setEditUserid(Integer editUserid) {
		this.editUserid = editUserid;
	}
	public Integer getEditUserid() {
		return this.editUserid;
	}
	public void setEditUsername(String editUsername) {
		this.editUsername = editUsername;
	}
	public String getEditUsername() {
		return this.editUsername;
	}
	public void setEdittime(java.sql.Timestamp edittime) {
		this.edittime = edittime;
	}
	public java.sql.Timestamp getEdittime() {
		return this.edittime;
	}
}

