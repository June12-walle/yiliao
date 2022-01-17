package com.offcn.utils;

public class PageTool {
	public PageTool(int totalCount, String currentPage) {
		this.totalCount = totalCount;
		initCurrentPage(currentPage);
		this.pageSize=3;//ҳ����д�����������޸�
		initTotalPages();
		initPrePage();
		initNextPage();
		initStartIndex();
	}
	//����ǰҳ���ʼ��
	private void initCurrentPage(String currentPage) {
		if (currentPage==null) {
			this.currentPage=1;
		}else {
			this.currentPage=Integer.valueOf(currentPage);
		}
	}
	//������ҳ��
	private void initTotalPages() {
		this.totalPages=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
	}
	//��һҳ
	private void initPrePage() {
		if (currentPage==1) {
			this.prePage=1;
		}else {
			this.prePage=currentPage-1;
		}
	}
	//��һҳ
	private void initNextPage() {
		if (currentPage==totalPages) {
			this.nextPage=totalPages;
		}else {
			this.nextPage=currentPage+1;
		}
	}
	//ÿҳ��һ����¼�ĳ�ʼ�±�
	private void initStartIndex() {
		this.startIndex=pageSize*(currentPage-1);
	}
	private int pageSize;//ҳ����
	private int totalCount;//�ܼ�¼��
	private int totalPages;//��ҳ��
	private int currentPage;//��ǰҳ��
	private int prePage;//��һҳ
	private int nextPage;//��һҳ
	private int startIndex;//ÿҳ��һ����¼�ĳ�ʼ�±�
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
}