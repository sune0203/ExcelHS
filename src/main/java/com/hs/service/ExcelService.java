package com.hs.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hs.vo.AAVO;
import com.hs.vo.MasterVO;

public interface ExcelService {

	// master item
	public void insert(MasterVO vo) throws Exception;
	public List<MasterVO> selectms() throws Exception;
	public void minc() throws Exception;
	public void mdelete() throws Exception;

	// aa item
	public void insert(AAVO vo) throws Exception;
	public List<AAVO> selectaa() throws Exception;
	public void ainc() throws Exception;
	public void adelete() throws Exception;
	
//	//join calcu
//	public List<CalVO> selectjoin() throws Exception;
}
