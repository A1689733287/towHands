package com.kmyj.shopping.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.kmyj.shopping.dao.IGoodsCarDao;
import com.kmyj.shopping.entity.DataDesc;
import com.kmyj.shopping.entity.Favorites;
import com.kmyj.shopping.entity.FriendLink;
import com.kmyj.shopping.entity.GoodsCar;
import com.kmyj.shopping.entity.GoodsSorts;
import com.kmyj.shopping.entity.Messages;
import com.kmyj.shopping.entity.News;
import com.kmyj.shopping.entity.Orders;
import com.kmyj.shopping.entity.TwoHand;
import com.kmyj.shopping.entity.User;
import com.kmyj.shopping.service.ICheckNoService;
import com.kmyj.shopping.service.IDataDescServics;
import com.kmyj.shopping.service.IFavoritesService;
import com.kmyj.shopping.service.IFriendLinkService;
import com.kmyj.shopping.service.IGoodsCarService;
import com.kmyj.shopping.service.IGoodsSortsService;
import com.kmyj.shopping.service.IMessagesService;
import com.kmyj.shopping.service.INewsService;
import com.kmyj.shopping.service.IOrdersService;
import com.kmyj.shopping.service.ITwoHandService;
import com.kmyj.shopping.service.IUserService;
import com.kmyj.shopping.serviceimpl.CheckNoService;
import com.kmyj.shopping.serviceimpl.DataDescService;
import com.kmyj.shopping.serviceimpl.FavoritesService;
import com.kmyj.shopping.serviceimpl.FriendLinkService;
import com.kmyj.shopping.serviceimpl.GoodsCarService;
import com.kmyj.shopping.serviceimpl.GoodsSortsService;
import com.kmyj.shopping.serviceimpl.MessagesService;
import com.kmyj.shopping.serviceimpl.NewsService;
import com.kmyj.shopping.serviceimpl.OrdersService;
import com.kmyj.shopping.serviceimpl.TwoHandService;
import com.kmyj.shopping.serviceimpl.UserService;
import com.kmyj.shopping.util.Info;

public class CoreServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CoreServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void go(String url, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void gor(String url, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("GB2312");
		response.setCharacterEncoding("GB2312");
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();
		String error = "";
		String ac = request.getParameter("ac");
		String url = "/twoHands" + path + "?ac=" + ac + "";
		if (ac == null)
			ac = "";
		String date = Info.getDateStr();
		// 管理员登录
		if (ac.equals("login")) {
			IUserService dao = new UserService();
			String username = request.getParameter("uname");
			String password = request.getParameter("upass");
			String utype = request.getParameter("utype");
			session.setAttribute("utype", utype);
			User user = new User();
			user.setUsername(username);
			user.setUserpass(password);
			if (dao.findManagerUser(user)) {
				session.setAttribute("admin", username);
				session.setAttribute("utype", username);
				go("/admin/main.jsp", request, response);
			} else {
				request.setAttribute("error", "");
				go("/admin/login.jsp", request, response);
			}

		}
		// 会员登录
		if (ac.equals("mlogin")) {
			IUserService dao = new UserService();
			String username = request.getParameter("uname");
			String password = request.getParameter("upass");
			User user = new User();
			user.setUsername(username);
			user.setUserpass(password);
			if (dao.findUsualUser(user)) {
				session.setAttribute("admin", user.getUsername());
				gor("/twoHands/index.jsp", request, response);
			} else {
				request.setAttribute("error", "");
				go("/index.jsp", request, response);
			}
		}

		// 修改密码
		if (ac.equals("uppass")) {
			IUserService dao = new UserService();
			String uname = request.getParameter("uname");
			String olduserpass = request.getParameter("olduserpass");
			String userpass = request.getParameter("userpass");
			if (dao.updateUser(uname, userpass, olduserpass)) {
				request.setAttribute("suc", "");
				go("/admin/uppass.jsp", request, response);
			} else {
				request.setAttribute("error", "");
				go("/admin/uppass.jsp", request, response);
			}
		}
		// 修改注册信息
		if (ac.equals("regeditxg")) {
			IUserService dao = new UserService();
			String username = request.getParameter("name");
			String userpass = request.getParameter("userpass");
			String truename = request.getParameter("truename");
			String sex = request.getParameter("sex");
			String qq = request.getParameter("qq");
			String phoneno = request.getParameter("phoneno");
			String email = request.getParameter("email");
			String address = request.getParameter("dizhi");
			String filename = request.getParameter("filename");
			User user = new User(username, userpass, truename, sex, qq,
					phoneno, email, address, filename, date);
			if (dao.updateUser(user)) {
				go("/regeditx.jsp", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 普通用户信息添加
		if (ac.equals("uregedit")) {
			IUserService dao = new UserService();
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String truename = request.getParameter("truename");
			String sex = request.getParameter("sex");
			String qq = request.getParameter("qq");
			String phoneno = request.getParameter("phoneno");
			String email = request.getParameter("email");
			String address = request.getParameter("dizhi");
			String filename = request.getParameter("filename");
			String usertype = "会员";
			User user = new User(username, userpass, truename, sex, qq,
					phoneno, email, address, usertype, filename, date);
			if (dao.insertUser(user)) {
				request.setAttribute("suc", "suc");
				go("/regedit.jsp", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 管理员信息添加
		if (ac.equals("regedit")) {
			String str = "";
			IUserService dao = new UserService();
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String truename = request.getParameter("truename");
			String sex = request.getParameter("sex");
			String qq = request.getParameter("qq");
			String phoneno = request.getParameter("phoneno");
			String email = request.getParameter("email");
			String address = request.getParameter("dizhi");
			String filename = request.getParameter("filename");
			User user = new User(username, userpass, truename, sex, qq,
					phoneno, email, address, "管理员", filename, date);
			if (dao.insertUser(user)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 修改会员信息
		if (ac.equals("regedituxg")) {
			String str = "";
			IUserService dao = new UserService();
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String truename = request.getParameter("truename");
			String sex = request.getParameter("sex");
			String qq = request.getParameter("qq");
			String phoneno = request.getParameter("phoneno");
			String email = request.getParameter("email");
			String address = request.getParameter("dizhi");
			String filename = request.getParameter("filename");
			User user = new User(username, userpass, truename, sex, qq,
					phoneno, email, address, filename, date);
			if (dao.updateUser(user, id)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 管理员信息修改
		if (ac.equals("regeditmxg")) {
			String str = "";
			IUserService dao = new UserService();
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String userpass = request.getParameter("userpass");
			String truename = request.getParameter("truename");
			String sex = request.getParameter("sex");
			String qq = request.getParameter("qq");
			String phoneno = request.getParameter("phoneno");
			String email = request.getParameter("email");
			String address = request.getParameter("dizhi");
			String filename = request.getParameter("filename");
			User user = new User(username, userpass, truename, sex, qq,
					phoneno, email, address, filename, date);
			if (dao.updateUser(user, id)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 会员查询
		if (ac.equals("muser")) {
			IUserService dao = new UserService();
			List<User> list = dao.findAllUsualUser();
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/admin/membercx.jsp", request, response);

		}
		// 管理员查询
		if (ac.equals("user")) {
			IUserService dao = new UserService();
			List<User> list = dao.findAllManagerUser();
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/admin/userscx.jsp", request, response);
		}
		// 用户删除
		if (ac.equals("musc")) {
			IUserService dao = new UserService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=muser", request, response);
			}else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 管理员删除
		if (ac.equals("usc")) {
			IUserService dao = new UserService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=user", request, response);
			}else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 管理员物品分类查询
		if (ac.equals("gcx")) {
			IGoodsSortsService dao = new GoodsSortsService();
			List<GoodsSorts> list = dao.findAll();
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/wpflcx.jsp", request, response);
		}

		// 用户物品分类查询
		if (ac.equals("ugcx")) {
			IGoodsSortsService dao = new GoodsSortsService();
			List<GoodsSorts> list = dao.findAll();
			request.setAttribute("url", url);
			request.setAttribute("list", list);
		}

		// 物品分类添加
		if (ac.equals("gtj")) {
			String str = "";
			IGoodsSortsService dao = new GoodsSortsService();
			String typename = request.getParameter("typename");
			GoodsSorts gs = new GoodsSorts(typename);
			if (dao.insert(gs)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 物品分类修改
		if (ac.equals("gxg")) {
			String str = "";
			IGoodsSortsService dao = new GoodsSortsService();
			int id = Integer.parseInt(request.getParameter("id"));
			String typename = request.getParameter("typename");
			GoodsSorts gs = new GoodsSorts();
			gs.setTypename(typename);
			if (dao.update(gs, id)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 物品分类删除
		if (ac.equals("gsc")) {
			IGoodsSortsService dao = new GoodsSortsService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=gcx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 管理员新闻查询
		if (ac.equals("ncx")) {
			INewsService dao = new NewsService();
			List<News> list = dao.findAll();
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/hbnewscx.jsp", request, response);

		}

		// 用户新闻查询
		if (ac.equals("uncx")) {
			INewsService dao = new NewsService();
			List<News> list = dao.findAll();
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/gfcs.jsp", request, response);

		}
		// 新闻添加
		if (ac.equals("ntj")) {
			INewsService dao = new NewsService();
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String content = request.getParameter("content");
			String filename = request.getParameter("filename");
			News news = new News(title, author, filename, content, date);
			if (dao.insert(news)) {
				go("/CoreServlet?ac=ncx", request, response);
			}
		}

		if (ac.equals("nncx")) {
			INewsService dao = new NewsService();
			int id = Integer.parseInt(request.getParameter("id"));
			News news = dao.find(id);
			request.setAttribute("news", news);
			go("admin/hbnewsxg.jsp", request, response);
		}
		// 新闻修改
		if (ac.equals("nxg")) {
			String str = "";
			INewsService dao = new NewsService();
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String content = request.getParameter("content");
			String filename = request.getParameter("filename");
			News news = new News(title, author, content, filename, date);
			if (dao.update(news, id)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 新闻删除
		if (ac.equals("nsc")) {
			INewsService dao = new NewsService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=ncx", request, response);
			}

		}

		// 单个新闻查询
		if (ac.equals("sidncx")) {
			INewsService dao = new NewsService();
			int id = Integer.parseInt(request.getParameter("id"));
			News news = dao.find(id);
			request.setAttribute("news", news);
			go("/xiang.jsp", request, response);
		}

		// 公告查询
		if (ac.equals("zcx")) {

			IDataDescServics dao = new DataDescService();
			String datatype = request.getParameter("datatype");
			DataDesc data = dao.find(datatype);
			request.setAttribute("data", data);
			if (datatype.equals("网站简介")) {
				go("/wzjj.jsp", request, response);
			}
			if (datatype.equals("关于我们")) {
				go("/gywm.jsp", request, response);
			}
		}

		// 网站 关于 查询
		if (ac.equals("mzcx")) {
			IDataDescServics dao = new DataDescService();
			String datatype = request.getParameter("datatype");
			DataDesc data = dao.find(datatype);
			request.setAttribute("data", data);
			if (datatype.equals("网站简介")) {
				go("/admin/wzjj.jsp", request, response);
			}
			if (datatype.equals("关于我们")) {
				go("/admin/gywm.jsp", request, response);
			}
			if (datatype.equals("网站公告")) {
				go("/admin/wzgg.jsp", request, response);
			}
		}

		// 公告修改
		if (ac.equals("zxg")) {
			IDataDescServics dao = new DataDescService();
			String datatype = request.getParameter("datatype");
			String content = request.getParameter("content");
			DataDesc data = new DataDesc();
			data.setContent(content);
			data.setDatatype(datatype);
			if (dao.update(data)) {
				if (datatype.equals("网站简介")) {
					go("/CoreServlet?ac=mzcx&datatype=网站简介", request, response);
				}
				if (datatype.equals("关于我们")) {
					go("/CoreServlet?ac=mzcx&datatype=关于我们", request, response);
				}
				if (datatype.equals("网站公告")) {
					go("/CoreServlet?ac=mzcx&datatype=网站公告", request, response);
				}
			}
		}
		// 二手交易查询
		if (ac.equals("utwocx")) {
			ITwoHandService dao = new TwoHandService();
			IGoodsSortsService iss = new GoodsSortsService();
			List<TwoHand> list = dao.infoFindAll();
			List<GoodsSorts> gss = iss.findAll();
			String str = "<select name=\"wpfl\" id=\"wpfl\" >";
			for (GoodsSorts gs : gss) {
				str += "<option value=\"" + gs.getTypename() + "\">"
						+ gs.getTypename() + "</option>";
			}
			str += "</select>";
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			request.setAttribute("wpfl", str);
			go("/zxxs.jsp", request, response);
		}
		// 用户名查看信息
		if (ac.equals("untwocx")) {

			ITwoHandService dao = new TwoHandService();
			String name = request.getParameter("uname");
			List<TwoHand> list = dao.infoFindAll(name);
			IGoodsSortsService iss = new GoodsSortsService();
			List<GoodsSorts> gss = iss.findAll();
			String str = "<select name=\"wpfl\" id=\"wpfl\" >";
			for (GoodsSorts gs : gss) {
				str += "<option value=\"" + gs.getTypename() + "\">"
						+ gs.getTypename() + "</option>";
			}
			str += "</select>";
			request.setAttribute("url", url);
			request.setAttribute("wpfl", str);
			request.setAttribute("list", list);
			go("/zxxs.jsp", request, response);
		}

		// 物品类型查看信息
		if (ac.equals("uptwocx")) {
			ITwoHandService dao = new TwoHandService();
			IGoodsSortsService iss = new GoodsSortsService();
			String wptype = request.getParameter("wptype");
			List<TwoHand> list = dao.infoTFindAll(wptype);
			List<GoodsSorts> gss = iss.findAll();
			String str = "<select name=\"wpfl\" id=\"wpfl\" >";
			for (GoodsSorts gs : gss) {
				str += "<option value=\"" + gs.getTypename() + "\">"
						+ gs.getTypename() + "</option>";
			}
			str += "</select>";
			request.setAttribute("wpfl", str);
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/zxxs.jsp", request, response);
		}
		// 物品信息查看
		if (ac.equals("uftwocx")) {
			ITwoHandService dao = new TwoHandService();
			int id = Integer.parseInt(request.getParameter("id"));
			TwoHand twoh = dao.find(id);
			request.setAttribute("twohand", twoh);
			
			go("/fxiang.jsp", request, response);
		}

		// 管理员二手交易查询
		if (ac.equals("mtwocx")) {
			ITwoHandService dao = new TwoHandService();
			List<TwoHand> list = dao.infoFindAll();
			System.out.print(list.size());
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/zxxscx.jsp", request, response);
		}
		// 跳转到二手交易修改
		if (ac.equals("twotoxg")) {
			ITwoHandService ihs = new TwoHandService();
			int id = Integer.parseInt(request.getParameter("id"));
			IGoodsSortsService iss = new GoodsSortsService();
			TwoHand twoh = ihs.find(id);
			List<GoodsSorts> gss = iss.findAll();
			String str = "<select name=\"wpfl\" id=\"wpfl\" >";
			for (GoodsSorts gs : gss) {
				str += "<option value=\"" + gs.getTypename() + "\">"
						+ gs.getTypename() + "</option>";
			}
			str += "</select>";
			request.setAttribute("wpfl", str);
			request.setAttribute("twoh", twoh);
			go("admin/zxxsxg.jsp", request, response);

		}

		// 跳转到二手交易添加
		if (ac.equals("twototj")) {
			IGoodsSortsService iss = new GoodsSortsService();
			List<GoodsSorts> gss = iss.findAll();
			String str = "<select name=\"wpfl\" id=\"wpfl\" >";
			for (GoodsSorts gs : gss) {
				str += "<option value=\"" + gs.getTypename() + "\">"
						+ gs.getTypename() + "</option>";
			}
			str += "</select>";
			request.setAttribute("wpfl", str);
			go("admin/zxxstj.jsp", request, response);

		}

		// 二手交易修改
		if (ac.equals("twoxg")) {
			String str = "";
			ITwoHandService dao = new TwoHandService();
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String wpdes = request.getParameter("wpbei");
			String lxr = request.getParameter("lxr");
			String lxtel = request.getParameter("lxtel");
			String lxaddress = request.getParameter("lxaddrs");
			String lxqq = request.getParameter("lxqq");
			float price = Float.parseFloat(request.getParameter("price"));
			String filename = request.getParameter("filename");
			String wptype = request.getParameter("wptype");
			TwoHand twoh = new TwoHand(title, wpdes, filename, lxr, lxtel,
					lxaddress, lxqq, price, wptype);
			if (dao.update(twoh, id)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 二手交易删除
		if (ac.equals("twosc")) {
			ITwoHandService dao = new TwoHandService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=mtwocx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 二手交易添加
		if (ac.equals("twotj")) {
			String str = "";
			String uname = (String) session.getAttribute("admin");
			ITwoHandService dao = new TwoHandService();
			String title = request.getParameter("title");
			String infotype = "二手交易";
			String wpdes = request.getParameter("wpbei");
			String lxr = request.getParameter("lxr");
			String lxtel = request.getParameter("lxtel");
			String lxaddress = request.getParameter("lxaddrs");
			String lxqq = request.getParameter("lxqq");
			float price = Float.parseFloat(request.getParameter("price"));
			String filename = request.getParameter("filename");
			String wptype = request.getParameter("wpfl");
			TwoHand twoh = new TwoHand(title, wpdes, filename, lxr, lxtel,
					lxaddress, lxqq, price, uname, date, infotype, wptype);
			if (dao.insert(twoh)) {
				request.setAttribute("suc", "");
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}

		}

		// 用户
		// 交易添加
		if (ac.equals("utwotj")) {
			String uname = request.getParameter("user");
			ITwoHandService dao = new TwoHandService();
			String title = request.getParameter("title");
			String infotype = "二手交易";
			String wpdes = request.getParameter("wpbei");
			String lxr = request.getParameter("lxr");
			String lxtel = request.getParameter("lxtel");
			String lxaddress = request.getParameter("lxaddrs");
			String lxqq = request.getParameter("lxqq");
			float price = Float.parseFloat(request.getParameter("price"));
			String filename = request.getParameter("filename");
			String wptype = request.getParameter("wptype");
			TwoHand twoh = new TwoHand(title, wpdes, filename, lxr, lxtel,
					lxaddress, lxqq, price, uname, date, infotype, wptype);
			if (dao.insert(twoh)) {
				go("/CoreServlet?ac=untwocx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}

		}

		// 管理员订单查询
		if (ac.equals("ocx")) {
			IOrdersService dao = new OrdersService();
			List<Orders> list = dao.findAll();
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/sprosorderspcx.jsp", request, response);
		}

		// 管理员订单查询
		if (ac.equals("socx")) {
			IOrdersService dao = new OrdersService();
			String name = request.getParameter("user");
			List<Orders> list = dao.findToAll(name);
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/sprosorderspcx.jsp", request, response);
		}
		// 用户已发订单查询
		if (ac.equals("uocx")) {
			IOrdersService dao = new OrdersService();
			String name = request.getParameter("uname");
			List<Orders> list = dao.findAll(name);
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/yfdd.jsp", request, response);
		}

		// 用户已收单查询
		if (ac.equals("ufocx")) {
			IOrdersService dao = new OrdersService();
			String name = request.getParameter("uname");
			List<Orders> list = dao.findToAll(name);
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/ysdd.jsp", request, response);
		}

		// 发送订单信息
		if (ac.equals("ufoxg")) {
			IOrdersService dao = new OrdersService();
			String name = request.getParameter("uname");
			int id = Integer.parseInt(request.getParameter("id"));
			String status = request.getParameter("status");
			if (dao.update(status, id)) {
				go("/CoreServlet?ac=ufocx&uname=" + name + "", request,
						response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 管理员删除订单
		if (ac.equals("osc")) {
			IOrdersService ios = new OrdersService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (ios.delete(id)) {
				go("/CoreServlet?ac=ocx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 发送订单
		if (ac.equals("ofs")) {
			IGoodsCarService igs = new GoodsCarService();
			String uname = request.getParameter("uname");
			String touname = request.getParameter("touname");
			IUserService ius = new UserService();
			List<GoodsCar> goods = igs.find(uname);
			User user = ius.find(uname);
			request.setAttribute("goods", goods);
			request.setAttribute("user", user);
			request.setAttribute("touname", touname);
			go("/fs.jsp", request, response);
		}
		// 订单添加
		if (ac.equals("otj")) {
			String str = "";
			IGoodsCarService ics = new GoodsCarService();
			IOrdersService dao = new OrdersService();
			String uname = request.getParameter("uname");
			String touname = request.getParameter("touname");
			String ddinfo = request.getParameter("ddinfo");
			String lxr = request.getParameter("lxr");
			String lxtel = request.getParameter("lxtel");
			String lxqq = request.getParameter("lxqq");
			String addrs = request.getParameter("addrs");
			String fkfs = request.getParameter("fkfs");
			String status = "已发送待处理";
			Orders order = new Orders(uname, touname, ddinfo, lxr, lxtel, lxqq,
					addrs, fkfs, status, date);
			if (dao.insert(order)) {
				ics.delete("uname");
				request.setAttribute("suc", "");
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 订单修改
		if (ac.equals("oxg")) {
			IOrdersService dao = new OrdersService();
			String name = request.getParameter("user");
			int id = Integer.parseInt(request.getParameter("id"));
			String status = request.getParameter("status");
			if (dao.update(status, id)) {
				go("/CoreServlet?ac=ocx&user=" + name + "", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 友情链接查询
		if (ac.equals("fcx")) {
			IFriendLinkService dao = new FriendLinkService();
			List<FriendLink> list = dao.findAll();
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/admin/yqljcx.jsp", request, response);
		}

		// 用户友情链接查询
		if (ac.equals("ufcx")) {
			IFriendLinkService dao = new FriendLinkService();
			List<FriendLink> list = dao.findAll();
			request.setAttribute("list", list);
		}

		// 友情链接添加
		if (ac.equals("ftj")) {
			String str = "";
			IFriendLinkService dao = new FriendLinkService();
			String flkname = request.getParameter("ljname");
			String flkurl = request.getParameter("ljurl");
			FriendLink flk = new FriendLink(flkname, flkurl);
			if (dao.insert(flk)) {
				go("/CoreServlet?ac=fcx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 友情链接删除gxg
		if (ac.equals("fsc")) {
			IFriendLinkService dao = new FriendLinkService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=fcx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 友情链接修改
		if (ac.equals("fxg")) {
			String str = "";
			IFriendLinkService dao = new FriendLinkService();
			int id = Integer.parseInt(request.getParameter("id"));
			String flkname = request.getParameter("ljname");
			String flkurl = request.getParameter("ljurl");
			FriendLink flk = new FriendLink(flkname, flkurl);
			if (dao.update(flk, id)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 购物车查询
		if (ac.equals("carcx")) {
			IGoodsCarService dao = new GoodsCarService();
			String uname = request.getParameter("uname");
			List<GoodsCar> list = dao.find(uname);
			request.setAttribute("list", list);
			go("/car.jsp", request, response);
		}

		// 购买添加数量
		if (ac.equals("cartjn")) {
			ITwoHandService dao = new TwoHandService();
			int id = Integer.parseInt(request.getParameter("id"));
			TwoHand two = dao.find(id);
			request.setAttribute("twoh", two);
			go("/num.jsp", request, response);
		}
		// 购物车添加
		if (ac.equals("cartj")) {
			IGoodsCarService dao = new GoodsCarService();
			String id = request.getParameter("id");
			String uname = request.getParameter("uname");
			String toname = request.getParameter("touname");
			String pname = request.getParameter("pname");
			String price = request.getParameter("price");
			String filename = request.getParameter("filename");
			String status = "车内";
			String savetime = date;
			int nums = Integer.parseInt(request.getParameter("nums"));
			GoodsCar car = new GoodsCar(uname, toname, pname, price, filename,
					status, savetime, nums, id);
			if (dao.insert(car)) {
				go("/CoreServlet?ac=utwocx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 购物车删除
		if (ac.equals("carsc")) {
			IGoodsCarService dao = new GoodsCarService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=carcx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 清空购物车
		if (ac.equals("clear")) {
			IGoodsCarService dao = new GoodsCarService();
			String uname = request.getParameter("uname");
			if (dao.delete(uname)) {
				go("/CoreServlet?ac=carcx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 购物修改
		if (ac.equals("carxg")) {
			String str="";
			IGoodsCarService dao = new GoodsCarService();
			String uname = request.getParameter("uname");
			int id = Integer.parseInt(request.getParameter("id"));
			int nums = Integer.parseInt(request.getParameter("num"));
			GoodsCar car = new GoodsCar();
			car.setNums(nums);
			if (dao.update(car, id)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 收藏夹查询
		if (ac.equals("scjcx")) {
			IFavoritesService dao = new FavoritesService();
			String uname = (String) session.getAttribute("admin");
			HashMap<String, Object> map = dao.findAll(uname);
			request.setAttribute("map", map);
			request.setAttribute("url", url);
			go("/scj.jsp", request, response);
		}
		// 收藏夹删除
		if (ac.equals("scjsc")) {
			IFavoritesService dao = new FavoritesService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=scjcx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		
		// 收藏夹添加
		if (ac.equals("scjtj")) {
			IFavoritesService dao = new FavoritesService();
			String sctype = request.getParameter("sctype");
			String uname = request.getParameter("uname");
			String wid = request.getParameter("wid");
			Favorites fav = new Favorites();
			fav.setSctype(sctype);
			fav.setUname(uname);
			fav.setWpid(wid);
			if (dao.insert(fav)) {
				go("/CoreServlet?ac=utwocx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}

		// 留言板查询
		if (ac.equals("msgcx")) {
			IMessagesService dao = new MessagesService();
			List<Messages> list = dao.findAll();
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/admin/messagescx.jsp", request, response);
		}

		// 用户留言板查询
		if (ac.equals("umsgcx")) {
			IMessagesService dao = new MessagesService();
			List<Messages> list = dao.findAll();
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/messages.jsp", request, response);
		}
		// 留言板添加
		if (ac.equals("msgtj")) {
			IMessagesService dao = new MessagesService();
			String content = request.getParameter("content");
			String saver = request.getParameter("uname");
			String savetime = date;
			Messages msg = new Messages();
			msg.setSaver(saver);
			msg.setContent(content);
			msg.setSavetime(savetime);
			if (dao.insert(msg)) {
				go("/CoreServlet?ac=umsgcx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}

		}
		// 留言板删除
		if (ac.equals("msgsc")) {
			IMessagesService dao = new MessagesService();
			int id = Integer.parseInt(request.getParameter("id"));
			if (dao.delete(id)) {
				go("/CoreServlet?ac=msgcx", request, response);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 留言板修改
		if (ac.equals("msgxg")) {
			String str = "";
			IMessagesService dao = new MessagesService();
			int id = Integer.parseInt(request.getParameter("id"));
			String resaver = (String) session.getAttribute("admin");
			String recontent = request.getParameter("recontent");
			Messages msg = new Messages();
			msg.setResaver(resaver);
			msg.setRecontent(recontent);
			msg.setResavetime(date);
			if (dao.update(msg, id)) {
				str += "<script language=\"javascript\">\n";
				str += "alert('操作成功');\n";
				str += "parent.location=parent.location;\n";
				str += "</script>";
				out.println(str);
			} else {
				error += "<script language=\"javascript\">\n";
				error += "alert('操作失败');\n";
				error += "parent.location=parent.location;\n";
				error += "</script>";
				out.println(error);
			}
		}
		// 图片上传
		if (ac.equals("uploadimg")) {
			try {
				String filename = "";
				request.setCharacterEncoding("utf-8");
				RequestContext requestContext = new ServletRequestContext(
						request);
				if (FileUpload.isMultipartContent(requestContext)) {

					DiskFileItemFactory factory = new DiskFileItemFactory();
					factory.setRepository(new File(request
							.getRealPath("/upfile/") + "/"));
					ServletFileUpload upload = new ServletFileUpload(factory);
					upload.setSizeMax(100 * 1024 * 1024);
					List items = new ArrayList();

					items = upload.parseRequest(request);

					FileItem fileItem = (FileItem) items.get(0);
					if (fileItem.getName() != null && fileItem.getSize() != 0) {
						if (fileItem.getName() != null
								&& fileItem.getSize() != 0) {
							File fullFile = new File(fileItem.getName());
							filename = Info.generalFileName(fullFile.getName());
							File newFile = new File(
									request.getRealPath("/upfile/") + "/"
											+ filename);
							try {
								fileItem.write(newFile);
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
						}
					}
				}

				go("/js/uploadimg.jsp?filename=" + filename, request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// 判断是否存在用户名
		if (ac.equals("checkno")) {
			ICheckNoService ics = new CheckNoService();
			String table = request.getParameter("table");
			String col = request.getParameter("col");
			String value = request.getParameter("value");
			if (ics.select(table, col, value)) {
				out.println("Y");
			} else {
				out.println("N");
			}

		}
		
		//订单搜索
		if(ac.equals("oderesSearch")){
			IOrdersService ios=new OrdersService();
			String uname=request.getParameter("uname");
			String ddinfo=request.getParameter("ddinfo");
			List<Orders> list = ios.search(uname,ddinfo);
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/sprosorderspcx.jsp", request, response);
			
		}
		//物品分类搜索
		if(ac.equals("gsSort")){
			IGoodsSortsService igs=new GoodsSortsService();
			String typename=request.getParameter("typename");
			List<GoodsSorts> list = igs.search(typename);
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/wpflcx.jsp", request, response);
			
		}
		//二手搜索
		if(ac.equals("searchTwo")){
			ITwoHandService dao = new TwoHandService();
			String title=request.getParameter("title");
			String uname=request.getParameter("uname");
			List<TwoHand> list = dao.search(title,uname);
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/zxxscx.jsp", request, response);
		}
		//优惠活动搜索
		if(ac.equals("newsSearch")){
			INewsService dao = new NewsService();
			String title=request.getParameter("title");
			String author=request.getParameter("author");
			List<News> list = dao.search(title,author);
			request.setAttribute("url", url);
			request.setAttribute("list", list);
			go("/admin/hbnewscx.jsp", request, response);
		}
		//管理员搜索
		if(ac.equals("userManagerSearch")){
			IUserService dao = new UserService();
			String uname=request.getParameter("username");
			String truename=request.getParameter("truename");
			List<User> list = dao.searchManager(uname,truename);
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/admin/userscx.jsp", request, response);
		}
		//用户搜索
		if(ac.equals("userSearch")){
			IUserService dao = new UserService();
			String uname=request.getParameter("username");
			String truename=request.getParameter("truename");
			List<User> list = dao.searchUser(uname,truename);
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/admin/membercx.jsp", request, response);

		}
		
		//友情链接搜索
		if(ac.equals("flkSearch")){
			IFriendLinkService dao = new FriendLinkService();
			String ljname=request.getParameter("ljname");
			List<FriendLink> list = dao.search(ljname);
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/admin/yqljcx.jsp", request, response);
		}
		//留言搜索
		if(ac.equals("msgSerah")){
			IMessagesService dao = new MessagesService();
			String saver=request.getParameter("saver");
			String content=request.getParameter("content");
			List<Messages> list = dao.search(saver,content);
			request.setAttribute("list", list);
			request.setAttribute("url", url);
			go("/admin/messagescx.jsp", request, response);
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
