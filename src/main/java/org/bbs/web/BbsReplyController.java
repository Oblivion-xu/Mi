package org.bbs.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bbs.pojo.BbsReply;
import org.bbs.pojo.BbsUser;
import org.bbs.pojo.Pager;
import org.bbs.service.BbsReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reply")
public class BbsReplyController {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BbsReplyService replyService;
	
	@RequestMapping("/addReply")
	public String addReply(BbsReply reply){
		replyService.addReply(reply);
		return "redirect:/reply/findById.do?id="+reply.getTopic().getId();
	}
	
	@RequestMapping("/findById")
	public String list(Integer id){
		Pager pager = new Pager();
		pager.setPageTotal(replyService.getCount(id));
		Integer size = pager.getPageSize();	
		Integer start = size*(pager.getPageIndex()-1);
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("start", start);
		condition.put("size", pager.getPageSize());
		condition.put("id", id);
		List<BbsReply> replys = replyService.list(condition);
		request.setAttribute("replys", replys);
		session.setAttribute("pager", pager);
		return "/listTopics";
	}
	
	@RequestMapping("/change")
	public String change(Integer tid,Integer pageIndex){
		Pager pager = (Pager) session.getAttribute("pager");
		pager.setPageIndex(pageIndex);
		pager.setPageIndex(pageIndex);
		Integer size = pager.getPageSize();
		Integer start = size*(pageIndex-1);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("start", start);
		condition.put("size",size);
		condition.put("id", tid);
		List<BbsReply> replys = replyService.list(condition);
		request.setAttribute("replys", replys);
		session.setAttribute("pager", pager);
		return "/listTopics";
	}
	
	@RequestMapping("/delReply")
	public String del(Integer id,Integer tid){
		replyService.delReply(id);
		return "redirect:/reply/findById.do?id="+tid;
	}

}
