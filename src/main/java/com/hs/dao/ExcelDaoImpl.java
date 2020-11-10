package com.hs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hs.vo.AAVO;
import com.hs.vo.MasterVO;

@Repository
public class ExcelDaoImpl implements ExcelDao{

	@Inject 
	SqlSession sql;
	
	/* Master table */
	@Override
	public void insert(MasterVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("itemMapper.insertms",vo);
	}
	@Override
	public List<MasterVO> selectms() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("itemMapper.selectms");
	}
	
	@Override
	public void mdelete() throws Exception {
		// TODO Auto-generated method stub
		sql.delete("itemMapper.mdelete");
		
	}
	@Override
	public void minc() throws Exception {
		// TODO Auto-generated method stub
		sql.update("itemMapper.minc");
		}
	
	/* AA table */
	@Override
	public void insert(AAVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("itemMapper.insertaa",vo);
	}
	@Override
	public List<AAVO> selectaa() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("itemMapper.selectaa");
	}
		
	@Override
	public void adelete() throws Exception {
		// TODO Auto-generated method stub
		sql.delete("itemMapper.adelete");
		
	}
	@Override
	public void ainc() throws Exception {
		// TODO Auto-generated method stub
		sql.update("itemMapper.ainc");
		
	}
	
//	//Calcu
//	
//	@Override
//	public List<CalVO> selectjoin() throws Exception {
//		// TODO Auto-generated method stub
//		sql.selectList("itemMapper.calcu");
//		return null;
//	}

}
