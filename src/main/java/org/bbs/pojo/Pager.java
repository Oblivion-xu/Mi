package org.bbs.pojo;

public class Pager {

	private Integer pageIndex = 1;
	private Integer pageSize = 8;
	private Integer pageTotal;

	public Pager() {
	}

	public Pager(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageCount() {
		return pageTotal % pageSize == 0 ? pageTotal / pageSize : pageTotal / pageSize + 1;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

}
