package com.ycb.util;

import java.util.List;

/**
 * 分页类
 * 
 * @author Administrator
 * 
 */
public class PageBean {
	private List data; // 分页数据集合
	private Object objDate; // 分页单对象
	private Integer pageCur; // 当前页码
	private Integer pageSize ; // 当前页大小
	private Integer pageSum; // 总页数
	private Integer total; // 总记录数
	private Integer pageNext; // 上一页
	private Integer pageUp; // 下一页

	public Object getObjDate() {
		return objDate;
	}

	public void setObjDate(Object objDate) {
		this.objDate = objDate;
	}

	public PageBean() {
		super();
	}

	public PageBean(List data, Integer pageCur, Integer pageSize, Integer total) {
		super();
		this.data = data;
		this.pageCur = pageCur;
		this.pageSize = pageSize;
		this.pageSum = (total - 1) / pageSize + 1;
		this.total = total;
	}

	public PageBean(List data, Object objDate, Integer pageCur,
			Integer pageSize, Integer total) {
		super();
		this.data = data;
		this.objDate = objDate;
		this.pageCur = pageCur;
		this.pageSize = pageSize;
		this.pageSum = (total - 1) / pageSize + 1;
		this.total = total;
	}

	private int startnow;
	private int endnow;

	public void getNow(Integer currentPage, Integer pageSize) {
		this.startnow = (currentPage - 1) * pageSize+1;
		this.endnow = currentPage * pageSize;
	}

	public int getStartnow() {
		return startnow;
	}

	public void setStartnow(int startnow) {
		this.startnow = startnow;
	}

	public int getEndnow() {
		return endnow;
	}

	public void setEndnow(int endnow) {
		this.endnow = endnow;
	}

	public List getdata() {
		return data;
	}

	public void setdata(List data) {
		this.data = data;
	}

	public Integer getPageCur() {
		return pageCur;
	}

	public void setPageCur(Integer pageCur) {
		this.pageCur = pageCur;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSum() {
		return (total - 1) / pageSize + 1;
	}

	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageNext() {
		return (pageCur - 1) < 1 ? 1 : (pageCur - 1);
	}

	public void setPageNext(Integer pageNext) {
		this.pageNext = pageNext;
	}

	public Integer getPageUp() {
		return (pageCur + 1) > pageSum ? pageSum : (pageCur + 1);
	}

	public void setPageUp(Integer pageUp) {
		this.pageUp = pageUp;
	}

}
