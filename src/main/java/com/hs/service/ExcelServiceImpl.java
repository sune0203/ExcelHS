package com.hs.service;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hs.dao.ExcelDao;
import com.hs.vo.AAVO;
import com.hs.vo.MasterVO;

@Service
public class ExcelServiceImpl implements ExcelService {

	@Inject
	ExcelDao dao;
	
	/*			 master item			 */
	@Override
	public void insert(MasterVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(vo);
		
	}
	@Override
	public List<MasterVO> selectms() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectms();
	}
	
	@Override
	public void mdelete() throws Exception {
		// TODO Auto-generated method stub
		dao.mdelete();
	}
	
	@Override
	public void minc() throws Exception {
		// TODO Auto-generated method stub
		dao.minc();
	}
	
	
	/* 			aa item			 */
	
	@Override
	public void insert(AAVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(vo);	
	}
	@Override
	public List<AAVO> selectaa() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectaa();
	}
	
	@Override
	public void adelete() throws Exception {
		// TODO Auto-generated method stub
		dao.adelete();
	}
	
	@Override
	public void ainc() throws Exception {
		// TODO Auto-generated method stub
		dao.ainc();
	}
	
//	//Calcu
//	
//	@Override
//	public List<CalVO> selectjoin() throws Exception {
//		// TODO Auto-generated method stub
//		return dao.selectjoin();
//	}
	
	 
}