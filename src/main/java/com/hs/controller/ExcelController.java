package com.hs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.security.Principal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hs.service.ExcelService;
import com.hs.util.ExcelUp;
import com.hs.vo.AAVO;
import com.hs.vo.MasterVO;

@Controller
@RequestMapping("/excel/*")
public class ExcelController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);
	
	@Inject 
	ExcelService service;
	
	@Inject
	ExcelUp exup;
	
	
	 @RequestMapping(value = "/master", method = RequestMethod.GET)
	    public String masterup() throws Exception {
	     
	        return "upload/masterup";
	    }
	
	 @RequestMapping(value = "/masterup", method = RequestMethod.POST)
	    public String masterup(MultipartHttpServletRequest request, Model model) throws Exception {
	      
		 MultipartFile file = null;
	        Iterator<String> iterator = request.getFileNames();
	        
	        if(iterator.hasNext()) {
	            file = request.getFile(iterator.next());
	        }
	        
	        List<MasterVO> list = exup.masterUP(file);
	        
	        service.mdelete();// 기존 데이터 삭제
	        service.minc(); //(PK)num autoinc 초기화
	        for(MasterVO vo : list) {
	        service.insert(vo);
	        }
	        
	        System.out.println(list.size());
	        
	        model.addAttribute("list", list);
	        
	        return "redirect:/";
	    }
	 
	 
	 @RequestMapping(value = "/aa", method = RequestMethod.GET)
	    public String aaup() throws Exception {
	     
	        return "upload/aaup";
	    }
	 
	 @RequestMapping(value = "/aaup", method = RequestMethod.POST)
	 public String aaup(MultipartHttpServletRequest request, Model model) throws Exception {
		 
		 MultipartFile file = null;
		 Iterator<String> iterator = request.getFileNames();
		 
		 if(iterator.hasNext()) {
			 file = request.getFile(iterator.next());
		 }
		 
		 List<AAVO> list = exup.aaUP(file);
		 
		 service.adelete();// 기존 데이터 삭제
		 service.ainc(); //(PK)num autoinc 초기화
		 
		 for(AAVO vo : list) {
			 service.insert(vo);
		 }
		 
		 System.out.println(list.size());
		 
		 model.addAttribute("list", list);
		 
		 return "redirect:/";
	 }
	 
	 
	 @RequestMapping(value = "/tables", method = RequestMethod.GET)
	 public String gettables(HttpServletRequest req) throws Exception {
		 List<MasterVO> list  = service.selectms();

		 HttpSession session = req.getSession();
		 session.setAttribute("mlist", list);
		
//		 System.out.println(list.get(0));
		 
		 return "redirect:/tables";
	 }
	 
	 @RequestMapping(value = "/charts", method = RequestMethod.GET)
	 public String getcharts(HttpServletRequest req) throws Exception {
		 List<AAVO> list  = service.selectaa();
		 
		 HttpSession session = req.getSession();
		 session.setAttribute("alist", list);
//		 System.out.println(list.get(0));
		 
		 return "redirect:/charts";
	 }
	 
	 @RequestMapping(value = "/resultchart", method = RequestMethod.GET)
	 public String getresultchart(HttpServletRequest req) throws Exception {
		 List<AAVO> list  = service.selectaa();
		 List<MasterVO> mlist  = service.selectms();
		 
		 HttpSession session = req.getSession();
		 session.setAttribute("alist", list);
		 session.setAttribute("mlist", mlist);
//		 System.out.println(list.get(0));
		 
		 return "redirect:/resultchart";
	 }
	 
		
		@RequestMapping(value = "/getch", method = RequestMethod.GET)
		public @ResponseBody List<AAVO> getch() throws Exception {
			logger.info("list json");
			service.selectaa(); // DB에서 정보를 받아 와야함

			//json 형태로 출력
			return service.selectaa() ;
		}
	 

	 
	 
	 


	
}
