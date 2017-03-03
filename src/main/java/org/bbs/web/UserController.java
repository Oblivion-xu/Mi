package org.bbs.web;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.*;

import org.bbs.pojo.BbsUser;
import org.bbs.service.BbsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class UserController {

	@Autowired
	private BbsUserService userService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;

	@RequestMapping("user/login")
	public String login(BbsUser user, String code) {
		BbsUser bbsUser = userService.login(user);
		if (bbsUser != null) {
			String imgCode = (String) session.getAttribute("code");
			if (imgCode.equals(code)) {
				session.setAttribute("bbsUser", bbsUser);
				return "redirect:/topic/list.do";
			}
			request.setAttribute("errInfo", "验证码错误");
		} else {
			request.setAttribute("errInfo", "用户名或者密码错误");
		}
		return "/index";
	}
	
	@RequestMapping("user/exit")
	public String exit(){
		BbsUser user = (BbsUser) session.getAttribute("user");
		if(user!=null){
			session.setAttribute("user", null);
			session.removeAttribute("user");
			session.setMaxInactiveInterval(0);
		}
		return "/index";
	}

	@RequestMapping("user/reg")
	public String reg(BbsUser user) {
		BbsUser bbsUser = userService.reg(user);
		if (bbsUser == null) {
			return "redirect:/index.jsp";
		}
		session.setAttribute("bbsUser", bbsUser);
		return "redirect://topic/list.do";
	}

	@RequestMapping("user/getName")
	public void getName(String nickname, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Boolean flag = false;
		Gson gson = new GsonBuilder().create();

		flag = userService.list().contains(nickname.toLowerCase());

		out.write(gson.toJson(flag));
		out.flush();
		out.close();
	}

	// 产生随机的字体
	private Font getFont() {
		// 创建random对象用来生成随机数
		Random random = new Random();
		// 创建字体数组，用来装不同的字体的Font对象
		Font font[] = new Font[5];
		font[0] = new Font("Ravie", Font.PLAIN, 25);
		font[1] = new Font("Antique Olive Compact", Font.PLAIN, 25);
		font[2] = new Font("Forte", Font.PLAIN, 25);
		font[3] = new Font("Wide Latin", Font.PLAIN, 25);
		font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, 25);
		return font[random.nextInt(5)];
	}

	/**
	 * 获取验证码
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("getCode")
	public void getCode(HttpServletResponse response) throws Exception {
		// 设置响应头 Content-type类型
		response.setContentType("image/jpeg");

		OutputStream os = response.getOutputStream();

		// 建立指定宽、高和BufferedImage对象
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics(); // 该画笔画在image上
		Color c = g.getColor(); // 保存当前画笔的颜色

		// 填充矩形
		g.fillRect(0, 0, 80, 30);

		char[] ch = "abcdefghjkmnpqrstuvwxyz2345678901".toCharArray();
		int length = ch.length; // 随即字符串的长度
		String sRand = ""; // 保存随即产生的字符串
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			g.setFont(getFont()); // 设置字体
			String rand = new Character(ch[random.nextInt(length)]).toString(); // 随即生成0-9的数字
			sRand += rand;
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))); // 设置随机颜色
			g.drawString(rand, 20 * i + 6, 25);
		}
		// 产生随即干扰点
		for (int i = 0; i < 20; i++) {
			int x1 = random.nextInt(80);
			int y1 = random.nextInt(30);
			g.drawOval(x1, y1, 2, 2);
		}

		g.setColor(c); // 将画笔的颜色再设置回去

		g.dispose(); // 释放此图形的上下文以及它使用的所有系统资源

		session.setAttribute("code", sRand); // 将验证码记录到session

		ImageIO.write(image, "JPEG", os); // 输出图像到页面
	}
}
