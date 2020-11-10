package com.hs.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hs.vo.AAVO;
import com.hs.vo.MasterVO;

@Repository
public class ExcelUp {
	

	 public List<MasterVO> masterUP(MultipartFile excelFile){
	        List<MasterVO> list = new ArrayList<MasterVO>();
	        try {
	            OPCPackage opcPackage = OPCPackage.open(excelFile.getInputStream());
	            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
	            
	            // (?) 시트 불러오기
	            XSSFSheet sheet = workbook.getSheetAt(3);
	            
	            for(int i=1; i<sheet.getLastRowNum() + 1; i++) {
	                MasterVO vo = new MasterVO();
	                int realRow = i + sheet.getFirstRowNum();
	                XSSFRow row = sheet.getRow(realRow);
	                
	                // 행이 존재하기 않으면 패스
	                if(null == row) {
	                    continue;
	                }
	                
	                // 행의 두번째 열(이름부터 받아오기) 
	                XSSFCell cell = row.getCell(1);
	                if(null != cell)
	                	cell.setCellType(CellType.STRING);
	                	vo.setCode(cell.getStringCellValue());
	                // 행의 세번째 열 받아오기
	                cell = row.getCell(2);
	                if(null != cell) 
	                	cell.setCellType(CellType.STRING);
	                	vo.setSellers(cell.getStringCellValue());
	                // 행의 네번째 열 받아오기
	                cell = row.getCell(3);
	                if(null != cell) 
	                	cell.setCellType(CellType.STRING);
	                	vo.setSupplier(cell.getStringCellValue());
	                // 행의 다섯번째 열 받아오기
	                cell = row.getCell(4);
	                if(null != cell) 
	                	cell.setCellType(CellType.STRING);
	                	vo.setNcode(cell.getStringCellValue());
	                // 행의 여섯번째 열 받아오기
	                cell = row.getCell(5);
	                if(null != cell) 
	                	cell.setCellType(CellType.STRING);
	                	vo.setPname(cell.getStringCellValue());
	                // 행의 일곱번째 열 받아오기
	                cell = row.getCell(6);
	                if(null != cell) 
	                	cell.setCellType(CellType.NUMERIC);
	                	vo.setBox((int)cell.getNumericCellValue());
	                // 행의 여덟번째 열 받아오기
	                cell = row.getCell(7);
	                if(null != cell) 
	                	cell.setCellType(CellType.NUMERIC);
	                	vo.setPar((int)cell.getNumericCellValue());
	                
	                list.add(vo);
	                
	                
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	 
	 
	 
	 public List<AAVO> aaUP(MultipartFile excelFile){
	        List<AAVO> list = new ArrayList<AAVO>();
	        try {
	            OPCPackage opcPackage = OPCPackage.open(excelFile.getInputStream());
	            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
	            
	            // (?) 시트 불러오기
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            for(int i=6; i<sheet.getLastRowNum() + 1; i++) {
	                AAVO vo = new AAVO();
	                
	                int realRow = i + sheet.getFirstRowNum();
	                
	                XSSFRow row = sheet.getRow(realRow);
	                
	                // 행이 존재하지 않으면 패스
	                if(null == row) {
	                    continue;
	                }
	                
	                // 행의 네번째 열 받아오기
	                XSSFCell cell = row.getCell(2);
	                if(null != cell) 
	                	cell.setCellType(CellType.STRING);
	                	vo.setSupplier(cell.getStringCellValue());
	                	
	                // 행의 다섯번째 열 받아오기
	                cell = row.getCell(3);
	                if(null != cell) 
	                	cell.setCellType(CellType.STRING);
	                	vo.setNcode(cell.getStringCellValue());
	                	
	                // 행의 여섯번째 열 받아오기
	                cell = row.getCell(4);
	                if(null != cell) 
	                	cell.setCellType(CellType.STRING);
	                	vo.setPname(cell.getStringCellValue());
	                	
	                // 행의 일곱번째 열 받아오기
	                cell = row.getCell(5);
	                if(null != cell) 
	                	cell.setCellType(CellType.NUMERIC);
	                	vo.setDay1((int)cell.getNumericCellValue());
	                	
	                // 행의 일곱번째 열 받아오기
	                cell = row.getCell(6);
	                if(null != cell) 
	                	cell.setCellType(CellType.NUMERIC);
	                vo.setDay2((int)cell.getNumericCellValue());
	                
	                // 행의 일곱번째 열 받아오기
	                cell = row.getCell(7);
	                if(null != cell) 
	                	cell.setCellType(CellType.NUMERIC);
	                vo.setDay3((int)cell.getNumericCellValue());
	                
	                // 행의 여덟번째 열 받아오기
	                cell = row.getCell(8);
	                if(null != cell) 
	                	cell.setCellType(CellType.NUMERIC);
	                vo.setDay4((int)cell.getNumericCellValue());
	                
	                list.add(vo);
	                
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return list;
	    }


//	public static ArrayList<masterVO> makeEx(String[] code, String[] sellers, String[] supplier, String[] ncode ,String[] pname,int[] box, 
//	int[] par) {
//		ArrayList<masterVO> list = new ArrayList<masterVO>();
//		for (int i = 0; i < code.length; i++) {
//			masterVO master = new masterVO(code[i], sellers[i], supplier[i],ncode[i],pname[i],box[i],par[i]);
//			list.add(master);
//		}
//		return list;
//	}
//
//	/**
//	 * 과일 리스트를 간단한 엑셀 워크북 객체로 생성
//	 * 
//	 * @param list
//	 * @return 생성된 워크북
//	 */
//	public SXSSFWorkbook makeSimpleFruitExcelWorkbook(List<masterVO> list) {
//		SXSSFWorkbook workbook = new SXSSFWorkbook();
//
//		// 시트 생성
//		SXSSFSheet sheet = workbook.createSheet("master");
//
//		// 시트 열 너비 설정
//		sheet.setColumnWidth(0, 1500);
//		sheet.setColumnWidth(0, 3000);
//		sheet.setColumnWidth(0, 3000);
//		sheet.setColumnWidth(0, 1500);
//
//		// 헤더 행 생
//		Row headerRow = sheet.createRow(0);
//		// 해당 행의 첫번째 열 셀 생성
//		Cell headerCell = headerRow.createCell(0);
//		headerCell.setCellValue("해외법인코드");
//		// 해당 행의 두번째 열 셀 생성
//		headerCell = headerRow.createCell(1);
//		headerCell.setCellValue("");
//		// 해당 행의 세번째 열 셀 생성
//		headerCell = headerRow.createCell(2);
//		headerCell.setCellValue("가격");
//		// 해당 행의 네번째 열 셀 생성
//		headerCell = headerRow.createCell(3);
//		headerCell.setCellValue("수량");
//
//		// 과일표 내용 행 및 셀 생성
//		Row bodyRow = null;
//		Cell bodyCell = null;
//		for (int i = 0; i < list.size(); i++) {
//			masterVO fruit = list.get(i);
//
//			// 행 생성
//			bodyRow = sheet.createRow(i + 1);
//			// 데이터 번호 표시
//			bodyCell = bodyRow.createCell(0);
//			bodyCell.setCellValue(i + 1);
//			// 데이터 이름 표시
//			bodyCell = bodyRow.createCell(1);
//			bodyCell.setCellValue(fruit.getName());
//			// 데이터 가격 표시
//			bodyCell = bodyRow.createCell(2);
//			bodyCell.setCellValue(fruit.getPrice());
//			// 데이터 수량 표시
//			bodyCell = bodyRow.createCell(3);
//			bodyCell.setCellValue(fruit.getQuantity());
//		}
//
//		return workbook;
//	}
//
//	/**
//	 * 생성한 엑셀 워크북을 컨트롤레에서 받게해줄 메소
//	 * 
//	 * @param list
//	 * @return
//	 */
//	public SXSSFWorkbook excelFileDownloadProcess(List<masterVO> list) {
//		return this.makeSimpleFruitExcelWorkbook(list);
//	}
}
