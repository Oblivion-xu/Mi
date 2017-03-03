package org.bbs.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bbs.pojo.BbsReply;
import org.bbs.pojo.BbsTopic;
import org.bbs.pojo.Pager;
import org.bbs.service.BbsTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("topic")
public class TopicController {
	
	@Autowired
	private BbsTopicService topicService;
	@Autowired
	private HttpSession session;
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/addTopic")
	public String addTopic(BbsTopic topic){
		topicService.addTopic(topic);
		return "redirect:/topic/list.do";
	}
	
	@RequestMapping("/list")
	public String list(){
		Pager pager  = new Pager();
		pager.setPageTotal(topicService.getCount());
		Integer start = pager.getPageSize()*(pager.getPageIndex()-1);
		Integer size = pager.getPageSize();
		Map<String, Integer> conditionMap = new HashMap<String, Integer>();
		conditionMap.put("start", start);
		conditionMap.put("size",size);
		List<BbsTopic> topics = topicService.list(conditionMap);
		request.setAttribute("topics", topics);
		session.setAttribute("pager", pager);
		return "/main";
	}
	
	@RequestMapping("/change")
	public String change(Integer pageIndex){
		Pager pager  = (Pager) session.getAttribute("pager");
		pager.setPageIndex(pageIndex);
		Integer size = pager.getPageSize();
		Integer start = size*(pageIndex-1);
		Map<String, Integer> conditionMap = new HashMap<String, Integer>();
		conditionMap.put("start", start);
		conditionMap.put("size",size);
		List<BbsTopic> topics = topicService.list(conditionMap);
		request.setAttribute("topics", topics);
		session.setAttribute("pager", pager);
		return "/main";
	}
	
	@RequestMapping("/findById")
	public void findById(Integer id,HttpServletResponse res) throws Exception{
				
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		BbsTopic topic = topicService.findById(id);
		
		Gson json = new Gson();

		out.write(json.toJson(topic));
		
		out.flush();
		out.close();
	}
	
	@RequestMapping("/delTopic")
	public String delTopic(Integer id){
		topicService.delTopic(id);
		return "redirect:/topic/list.do";
	}
}
