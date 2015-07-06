package com.bbs.main;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.Domain.BbsVo;
import com.bbs.Service.BbsService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name="bbsService")
	BbsService service;
	
	@RequestMapping(value = "/BBS", method = RequestMethod.GET)
	public String home(
			@RequestParam(value="PAGENUM",defaultValue="1")int PAGENUM,
			@RequestParam(value="SEARCH_TYPE",required=false)String SEARCH_TYPE,
			@RequestParam(value="KEYWORD",required=false)String KEYWORD,
			Model model) {
		logger.info("display BBS main");
		
		Map<String,Object> map = service.RowPrintService(SEARCH_TYPE, KEYWORD, PAGENUM);
		
		model.addAttribute("BBS",map.get("BBS"));
		model.addAttribute("START_PAGENUM",map.get("START_PAGENUM"));
		model.addAttribute("END_PAGENUM",map.get("END_PAGENUM"));
		model.addAttribute("MAX_PAGE",map.get("MAX_PAGE"));
		model.addAttribute("SEARCH_TYPE",map.get("KEYWORD"));
		model.addAttribute("PAGENUM",PAGENUM);
		model.addAttribute("SEARCH_TYPE", SEARCH_TYPE);
		model.addAttribute("KEYWORD", KEYWORD);
		
		return "BBS";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String AddBbs(@ModelAttribute("bbsVo")BbsVo bbs,
			Model model){
		logger.info("insert Bbs");
		
		this.service.addBbs(bbs);
		
		return "redirect:BBS";
	}
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String AddFormBbs(@ModelAttribute("bbsVo")BbsVo bbs,
			Model model){
		logger.info("display bbs write form");
		
		return "writeForm";
	}
	
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public String ViewBbs(@RequestParam("BBS_NUM")int BBS_NUM,
			Model model){
		logger.info("display bbs View");
		
		model.addAttribute("BBS",service.Read_Bbs(BBS_NUM));
		
		return "writeView";
	}
	
	@RequestMapping(value = "/UpdateForm", method = RequestMethod.GET)
	public String UpdateBbsForm(
			@RequestParam("BBS_NUM")int BBS_NUM,
			Model model){
		logger.info("display bbs Update Form");
		
		model.addAttribute("BBS", this.service.Read_Bbs(BBS_NUM));
		model.addAttribute("BBS_NUM", BBS_NUM);
		
		return "UpdateForm";
	}
	
	@RequestMapping(value = "/Update", method=RequestMethod.POST)
	public String UpdateBbs(
			@RequestParam("BBS_NUM")int BBS_NUM,
			@ModelAttribute("bbsVo")BbsVo bbs,
			Model model){
		logger.info("display bbs Update");
		
		this.service.Update(bbs);
		
		return "redirect:writeView?BBS_NUM="+BBS_NUM;
	}
	
	@RequestMapping(value = "/ReplyForm", method=RequestMethod.GET)
	public String ReplyForm(
			@RequestParam("BBS_NUM")int BBS_NUM,
			Model model){
		logger.info("display bbs Reply Form");
		
		model.addAttribute("TITLE", this.service.Read_Bbs(BBS_NUM).getTITLE());
		model.addAttribute("BBS_NUM",BBS_NUM);
		
		return "ReplyForm";
	}
	
	@RequestMapping(value = "/Reply", method = RequestMethod.POST)
	public String ReplyBbs(
			@ModelAttribute("bbsVo")BbsVo bbs,
			Model model){
		logger.info("display bbs Reply");
		
		this.service.Reply(bbs);
		
		return "redirect:BBS";
	}
	
	@RequestMapping(value = "/Check_Pass", method = RequestMethod.GET)
	public String Check_Pass(
			@RequestParam("BBS_NUM")int BBS_NUM,
			@RequestParam("BBS_TYPE")String BBS_TYPE,
			@RequestParam(value="PASSWORD",required=false)String PASSWORD,
			Model model){
		logger.info("display Check Pass");
		
		if(PASSWORD == null){
			model.addAttribute("CHECK_PASS","");
			model.addAttribute("BBS_NUM",BBS_NUM);
			model.addAttribute("BBS_TYPE",BBS_TYPE);
			return "CheckPass";
		}
		
		if(this.service.Check_Pass(BBS_NUM, PASSWORD)){
			switch (BBS_TYPE){
			case "UPDATE":
				model.addAttribute("CHECK_PASS","update");
				model.addAttribute("url", "UpdateForm?BBS_NUM="+BBS_NUM);
				return "CheckPass";
			case "DELETE":
				this.service.Delete(BBS_NUM);
				model.addAttribute("CHECK_PASS","delete");
				return "CheckPass";
			default:
				return "";
			}
		}else{
			model.addAttribute("CHECK_PASS","fail");
			model.addAttribute("BBS_NUM",BBS_NUM);
			model.addAttribute("BBS_TYPE",BBS_TYPE);
			return "CheckPass";
		}
	}
}
