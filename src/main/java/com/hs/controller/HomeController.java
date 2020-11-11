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
import com.hs.vo.MasterVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject 
	ExcelService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("홈");
		
		
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		logger.info("인덱스");
		
		
		return "index";
	}
	@RequestMapping(value = "/charts", method = RequestMethod.GET)
	public String charts() {
		logger.info("차트");
		
		
		return "charts";
	}
	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String table() {
		logger.info("테이블");
		
		
		
		return "tables";
	}
	
		@RequestMapping(value = "/resultchart", method = RequestMethod.GET)
		public String resultchart() {
			logger.info("최종 결과 차트");
			
			
			
			return "resultchart";
	}


	
}
