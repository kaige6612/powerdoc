package com.putorn.powerdoc.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页参数传递工具类 .
 */
@ApiModel(description = "分页实体类")
public class PageParam implements Serializable {

    /**
   * 
   */
    private static final long serialVersionUID = 6297178964005032338L;

    /**
     * 默认为第一页.
     */
    @ApiModelProperty(value = "默认页码",example = "1")
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 默认每页记录数(10).
     */
    @ApiModelProperty(value = "默认每页记录数",example = "10")
    public static final int DEFAULT_NUM_PER_PAGE = 10;

    /**
     * 最大每页记录数(100).
     */
    public static final int MAX_PAGE_SIZE = 100;

	@ApiModelProperty(value = "当前页码",example = "1")
    private int currentPage = DEFAULT_PAGE_NUM; // 当前页数
	@ApiModelProperty(value = "每页记录数",example = "10")
    private int pageSize = DEFAULT_NUM_PER_PAGE; // 每页记录数
    
    /**
     * params a map which contains the query parameters
     */

    @ApiModelProperty(value = "查询参数")
    private Map<String, Object> params  = new HashMap<String, Object>();

    /**
     * 默认构造函数
     */
    public PageParam(){}

    /**
     * 带参数的构造函数
     * @param pageNum
     * @param numPerPage
     */
    public PageParam(int pageNum , int numPerPage){}



    public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

    /** 每页记录数 */
    public void setNumPerPage(int pageSize) {
        this.pageSize = pageSize;
    }

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	/** 每页记录数 */
    public int getPageSize() {
        return pageSize > 0 ? pageSize : DEFAULT_NUM_PER_PAGE;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
