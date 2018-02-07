package com.kmyj.shopping.util;

import java.util.ArrayList;
import java.util.List;

public class MyPagination {
	public List<Object> list = null;
	private int recordCount = 0;
	private int pagesize = 0;
	private int maxPage = 0;

	// 初始化分页信息
	public List getInitPage(List list, int Page, int pagesize) {
		List<Object> newList = new ArrayList<Object>();
		this.list = list;
		recordCount = list.size();
		this.pagesize = pagesize;
		this.maxPage = getMaxPage();
		try {
			for (int i = (Page - 1) * pagesize; i <= Page * pagesize - 1; i++) {
				try {
					if (i >= recordCount) {
						break;
					}
				} catch (Exception e) {
				}
				newList.add((Object) list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newList;
	}

	// 获取指定页的数据
	public List<Object> getAppointPage(int Page) {
		List<Object> newList = new ArrayList<Object>();
		try {
			for (int i = (Page - 1) * pagesize; i <= Page * pagesize - 1; i++) {
				try {
					if (i >= recordCount) {
						break;
					}
				} catch (Exception e) {
				}
				newList.add((Object) list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newList;
	}

	// 获取最大记录数
	public int getMaxPage() {
		int maxPage = (recordCount % pagesize == 0) ? (recordCount / pagesize)
				: (recordCount / pagesize + 1);
		return maxPage;
	}

	// 获取总记录数
	public int getRecordSize() {
		return recordCount;
	}

	// 获取当前页数
	public int getPage(String str) {
		System.out.println("STR:" + str + "&&&&" + recordCount);
		if (str == null) {
			str = "0";
		}
		int Page = Integer.parseInt(str);
		if (Page < 1) {
			Page = 1;
		} else {
			if (((Page - 1) * pagesize + 1) > recordCount) {
				Page = maxPage;
			}
		}
		return Page;
	}

	public String printCtrl(int Page, String url) {
		String strHtml = "当前页数[" + Page + "/" + maxPage + "]&nbsp;&nbsp;";
		try {
			if (Page > 1) {
				strHtml = strHtml + "<a href='" + url + "&Page=1'>首页</a>";
				strHtml = strHtml + "&nbsp;&nbsp;<a href='" + url + "&Page="
						+ (Page - 1) + "'>上一页</a>";
			}
			if (Page < maxPage) {
				strHtml = strHtml + "&nbsp;&nbsp;<a href='" + url + "&Page="
						+ (Page + 1) + "'>下一页</a>&nbsp;&nbsp;<a href='" + url
						+ "&Page=" + maxPage + "'>尾页&nbsp;</a>";
			}
			strHtml = strHtml + "";
		} catch (Exception e) {
			e.printStackTrace();

		}
		return strHtml;
	}
}
