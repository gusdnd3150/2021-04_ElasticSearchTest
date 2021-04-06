package com.example.demo.content.modules;

import lombok.Data;

@Data
public class PagingVo {
	private int nowPage, startPage, endPage, total, cntPerPage, lastPage, limit, offset;
	private int cntPage = 5;  //한화면에 보여줄 페이징 숫자의 개수
	private int listType;
	private int listType2;
	private int search;
	private int id;

	private String searchType;
	private String searchContent;
	private String starD;
	private String endD;
	private String sorting;


	public PagingVo() {
	}

	public PagingVo(int listType, int total, int nowPage, int cntPerPage,String searchContent) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
		this.listType = listType;
		this.searchContent = searchContent;

	}

	public PagingVo(int listType, int total, int nowPage, int cntPerPage,String searchContent, String sorting) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
		this.listType = listType;
		this.searchContent = searchContent;
		this.sorting = sorting;

	}

	public PagingVo(String starD,String endD,int listType,int listType2, int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
		this.listType = listType;
		this.listType2 = listType2;
		this.endD=endD;
		this.starD=starD;
	}
	public PagingVo(String starD,String endD,int listType, int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
		this.listType = listType;
		this.endD=endD;
		this.starD=starD;
	}

	public PagingVo(int id, int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
		this.id = id;
	}

	public PagingVo(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}

	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double) total / (double) cntPerPage));
		if(getLastPage()==0) {
			setLastPage(1);
		}
	}

	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage);
		
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
		if(getEndPage()==0) {
			setEndPage(1);
		}
	}

	// DB 쿼리에서 사용할 limit, offset값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setOffset((nowPage-1) * cntPerPage);   //offset 시작
		setLimit(cntPerPage);  //limit 
	}

}
