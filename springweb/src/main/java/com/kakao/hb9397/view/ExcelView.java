package com.kakao.hb9397.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.kakao.hb9397.dto.ItemDTO;

public class ExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// ��Ʈ ����
		Sheet sheet = createFirstSheet(workbook);
		
		// �÷� �̸� ���
		createColumnLabel(sheet);
		
		// �Ѱ��� �����͸� ������ ���
		List<ItemDTO> list = (List<ItemDTO>) model.get("list");
		
		
		// �ݺ����� �����ؼ� �� ������ ���
		int rowNum = 1;
		for(ItemDTO dto : list) {
			createRow(sheet, dto, rowNum++, workbook);
		}
	}
	
	// ��Ʈ Sheet �� ������ִ� �޼���
	private Sheet createFirstSheet(Workbook workbook) {
		// ���ο� ��Ʈ ����
		Sheet sheet = workbook.createSheet();
		
		// ��Ʈ �̸� ����
		workbook.setSheetName(0, "ITEM");
		sheet.setColumnWidth(1,  256 * 20);
		return sheet;
	}
	
	// �÷� �̸� ����ϴ� �޼���
	private void createColumnLabel(Sheet sheet) {
		// �ϳ��� ���� ����
		Row firstRow = sheet.createRow(0);
		Cell cell = firstRow.createCell(0);
		cell.setCellValue("��ǰ��");
		
		cell = firstRow.createCell(0);
		cell.setCellValue("����");
		
		cell = firstRow.createCell(0);
		cell.setCellValue("����");
	}
	
	// �ϳ��� ���� ������ִ� �޼���
	private void createRow(Sheet sheet, ItemDTO item, int rowNum, Workbook workbook) {
		Row row = sheet.createRow(rowNum);
		
		Cell cell = row.createCell(0);
		cell.setCellValue(item.getItemname());
		
		cell = row.createCell(0);
		cell.setCellValue(item.getDescription());
		
		cell = row.createCell(0);
		cell.setCellValue(item.getPrice());
		
	}
}
