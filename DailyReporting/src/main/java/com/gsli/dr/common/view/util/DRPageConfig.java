package com.gsli.dr.common.view.util;


public class DRPageConfig {
	int pageNum = 0;
	int pageSize = 0;
	int resultsPerPage = 0;
	PageSortDirection sortDirection;
	String[] propertiesToOrderBy;

	public DRPageConfig(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public DRPageConfig(int pageNum, int resultsPerPage,
			PageSortDirection sortDirection, String[] propertiesToOrderBy) {
		this.pageNum = pageNum;
		this.resultsPerPage = resultsPerPage;
		this.sortDirection = sortDirection;
		this.propertiesToOrderBy = propertiesToOrderBy;
	}

	public DRPageConfig(PageSortDirection sortDirection,
			String[] propertiesToOrderBy) {
		this.sortDirection = sortDirection;
		this.propertiesToOrderBy = propertiesToOrderBy;
	}

	public int getPageNum() {
		return this.pageNum;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public int getResultsPerPage() {
		return this.resultsPerPage;
	}

	public PageSortDirection getSortDirection() {
		return this.sortDirection;
	}

	public String[] getPropertiesToOrderBy() {
		return this.propertiesToOrderBy;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setResultsPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	public void setSortDirection(PageSortDirection sortDirection) {
		this.sortDirection = sortDirection;
	}

	public void setPropertiesToOrderBy(String[] propertiesToOrderBy) {
		this.propertiesToOrderBy = propertiesToOrderBy;
	}
}