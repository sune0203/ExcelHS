package com.hs.dao;

import java.util.List;

import com.hs.vo.AAVO;
import com.hs.vo.MasterVO;

public interface ExcelDao {

	// master table
	public void insert(MasterVO vo) throws Exception;
	public List<MasterVO> selectms() throws Exception;
	public void mdelete() throws Exception;
	public void minc() throws Exception;
	
	//aa table
	public void insert(AAVO vo) throws Exception;
	public List<AAVO> selectaa() throws Exception;
	public void adelete() throws Exception;
	public void ainc() throws Exception;
	
//	//join calcu
//	public List<CalVO> selectjoin() throws Exception;
}
