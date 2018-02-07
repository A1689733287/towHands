package com.kmyj.shopping.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class Info {


	public static String getFileUpInfo() {
		String jscode = "";
		jscode += "<script src=/twoHands/js/popup.js></script>";
		jscode += "<font onclick=\"uploaddoc()\" src=\"js/nopic.jpg\" style='cursor:hand' id=txt >点击此处上传</font>";
		jscode += "&nbsp;&nbsp;<input type=text readonly style='border:0px' size=30  name=\"docname\" id=\"docname\" value=\"\" />";
		return jscode;
	}

	public static String tform(HashMap map) {
		String jscode = "";
		try {
			jscode += "<script type=\"text/javascript\">\n";
			jscode += "function getPvalue()\n";
			jscode += "{\n";

			Set set = map.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				String pm = ((Object) it.next()).toString();
				String str1 = "";
				String str2 = "";
				String[] strs = pm.split("=");
				str1 = strs[0];
				if (strs.length == 1)
					str2 = "";
				if (strs.length == 2)
					str2 = strs[1];
				str2 = str2.replaceAll("\r\n", "-----");

				if (!str1.equals("content")) {

					jscode += " if(document.getElementsByName(\"" + str1
							+ "\").length>1)\n";
					jscode += " {\n";
					jscode += " var radios = document.getElementsByName(\""
							+ str1 + "\");\n";

					jscode += " if(radios[0].type=='radio'){\n";
					jscode += " for(var i=0;i<radios.length;i++)\n";
					jscode += " {\n";
					jscode += " if(radios[i].value==\"" + str2 + "\")\n";
					jscode += " {\n";
					jscode += " radios[i].checked=\"checked\";\n";
					jscode += " }\n";
					jscode += " }\n";
					jscode += " }\n";

					jscode += " if(radios[0].type=='checkbox'){\n";

					jscode += " for(var i=0;i<radios.length;i++)\n";
					jscode += " {\n";

					jscode += " if(\"" + str2
							+ "\".indexOf(radios[i].value)>-1)\n";
					jscode += " {\n";

					jscode += " radios[i].checked=\"checked\";\n";

					if (str2.indexOf(" - ") > -1) {
						for (String strch : str2.split(" ~ ")) {

							String strchname = strch.substring(0,
									strch.lastIndexOf(" - "));
							jscode += " if(document.getElementsByName('"
									+ strchname + "').length>0)\n";
							jscode += " {\n";
							jscode += " document.getElementsByName('"
									+ strchname
									+ "')[0].value='"
									+ strch.substring(strch.lastIndexOf(":") + 1)
									+ "';\n";
							jscode += " }\n";

						}
					}

					jscode += " }\n";
					jscode += " }\n";
					jscode += " }\n";

					jscode += " if(radios.type=='select'){\n";
					jscode += " f1." + str1 + ".value=\"" + str2 + "\";\n";
					jscode += " }\n";

					jscode += " }else{\n";
					jscode += " if(f1." + str1 + ")\n";
					jscode += "{\n";
					jscode += "f1." + str1 + ".value=\"" + str2 + "\";\n";
					jscode += "}\n";
					jscode += "}\n";

					jscode += "if(document.getElementById(\"txt\"))\n";
					jscode += "{\n";
					jscode += "document.getElementById(\"txt\").src=\"/twoHands/upfile/"
							+ map.get("filename") + "\";\n";
					jscode += "}\n";

					jscode += "if(document.getElementById(\"txt2\"))\n";
					jscode += "{\n";
					jscode += "document.getElementById(\"txt2\").src=\"/twoHands/upfile/"
							+ map.get("filename2") + "\";\n";
					jscode += "}\n";

					jscode += "if(document.getElementById(\"txt3\"))\n";
					jscode += "{\n";
					jscode += "document.getElementById(\"txt3\").src=\"/twoHands/upfile/"
							+ map.get("filename3") + "\";\n";
					jscode += "}\n";

					jscode += "if(document.getElementById(\"txt4\"))\n";
					jscode += "{\n";
					jscode += "document.getElementById(\"txt4\").src=\"/twoHands/upfile/"
							+ map.get("filename4") + "\";\n";
					jscode += "}\n";

					jscode += "if(document.getElementById(\"txt5\"))\n";
					jscode += "{\n";
					jscode += "document.getElementById(\"txt5\").src=\"/twoHands/upfile/"
							+ map.get("filename5") + "\";\n";
					jscode += "}\n";

				}
			}

			jscode += "}\n";

			jscode += " getPvalue();\n";
			jscode += "</script>\n";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jscode;
	}

	public static String generalFileName(String srcFileName) {
		try {
			int index = srcFileName.lastIndexOf(".");
			return StrUtil.generalSrid()
					+ srcFileName.substring(index).toLowerCase();
		} catch (Exception e) {
			return StrUtil.generalSrid();
		}
	}

	public synchronized static String getID() {
		Random random = new Random();
		StringBuffer ret = new StringBuffer(20);
		String rand = String.valueOf(Math.abs(random.nextInt()));
		ret.append(getDateStr());
		ret.append(rand.substring(0, 6));

		return ret.toString();
	}

	public static String getImgUpInfoext(int height) {
		String jscode = "";
		jscode += "<img style=\"cursor: hand\" onclick=\"uploadimg()\" src=\"/twoHands/js/nopic.jpg\" id=txt height=\""
				+ height + "\"/>";
		jscode += "<input type=hidden name=\"filename\" id=\"filename\" value=\"\" />";
		jscode += "<script type=\"text/javascript\"  src=\"/twoHands/js/popupsext.js\"></script>";
		return jscode;
	}

	public static String getImgUpInfo(int height) {
		String jscode = "";
		jscode += "<img style=\"cursor: hand\" onclick=\"uploadimg()\" src=\"/twoHands/js/nopic.jpg\" id=txt height=\""
				+ height + "\"/>";
		jscode += "<input type=hidden name=\"filename\" id=\"filename\" value=\"\" />";
		jscode += "<script type=\"text/javascript\"  src=\"/twoHands/js/popup.js\"></script>";
		return jscode;
	}

	public static String fck(int height, String content) {
		String jscode = "<TEXTAREA   name=\"content\" id=\"content\">"
				+ content + "</TEXTAREA>";
		jscode += "<script type=\"text/javascript\"  src=\"/twoHands/fckeditor/fckeditor.js\"></script>";
		jscode += "<script language=\"javascript\">";
		jscode += "function fckinit()";
		jscode += "{";
		jscode += " var of = new FCKeditor(\"content\");";
		jscode += "of.BasePath=\"/twoHands/fckeditor/\";";
		jscode += "of.Height = \"" + height + "\";";
		jscode += "of.ToolbarSet=\"Default\";";
		jscode += "of.ReplaceTextarea();";
		jscode += "}";
		jscode += "fckinit();";
		jscode += "</script>";

		return jscode;
	}

	public synchronized static String subStr(String source, int length) {
		if (source.length() > length) {
			source = source.substring(0, length) + "...";
		}

		return source;
	}

	public static String getDateStr() {
		String dateString = "";
		try {// yyyyMMddHHmmss
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date currentTime_1 = new java.util.Date();
			dateString = formatter.format(currentTime_1);
		} catch (Exception e) {
		}
		return dateString;
	}

	public static String getUTFStr(String str) {
		if (str == null) {
			return "";
		}

		try {
			str = new String(str.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public static String getGBKStr(String str)
			throws UnsupportedEncodingException {
		if (str == null) {
			return "";
		}
		return new String(str.getBytes("ISO-8859-1"), "GBK");
	}

	public static String getGB2312Str(String str)
			throws UnsupportedEncodingException {
		if (str == null) {
			return "";
		}
		return new String(str.getBytes("ISO-8859-1"), "gb2312");
	}

	/**
	 * 过滤html代码
	 * 
	 */
	public static String filterStrIgnoreCase(String source, String from,
			String to) {
		String sourceLowcase = source.toLowerCase();
		String sub1, sub2, subLowcase1, subLowcase2;
		sub1 = sub2 = subLowcase1 = subLowcase2 = "";
		int start = 0, end;
		boolean done = true;
		if (source == null)
			return null;
		if (from == null || from.equals("") || to == null || to.equals(""))
			return source;
		while (done) {
			start = sourceLowcase.indexOf(from, start);
			if (start == -1) {
				break;
			}
			subLowcase1 = sourceLowcase.substring(0, start);
			sub1 = source.substring(0, start);
			end = sourceLowcase.indexOf(to, start);
			if (end == -1) {
				end = sourceLowcase.indexOf("/>", start);
				if (end == -1) {
					done = false;
				}
			} else {
				end = end + to.length();
				subLowcase2 = sourceLowcase.substring(end, source.length());
				sub2 = source.substring(end, source.length());
				sourceLowcase = subLowcase1 + subLowcase2;
				source = sub1 + sub2;
			}
			// System.out.println(start+" "+end);
		}
		return source;
	}

	public static void delPic(String path, String img) {
		if (img != null) {
			if (!img.equals("")) {
				File file1 = new File(path + "/" + img);
				if (file1.exists()) {
					file1.deleteOnExit();
					file1.delete();
				}
			}
		}
	}

}
