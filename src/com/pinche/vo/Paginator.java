package com.pinche.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 分页vo
 */
public class Paginator {

	private int pageNumber = 0;

	private int pageSize = 10;

	private int total = 0;

	private List<?> rows;

	@JsonIgnore
	public int getOffset() {
		return (this.pageNumber - 1) * this.pageSize;
	}

	@JsonIgnore
	public int getSize() {
		return this.pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
