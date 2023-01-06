package com.kakao.hb9397.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.kakao.hb9397.dto.ItemDTO;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			Document document, PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		// ���޵� ������ ��������
		List<ItemDTO> list = (List<ItemDTO>) model.get("list");
		
		// ���̺� ���
		Table table = new Table(3, list.size() +1);
		table.setPadding(5);
		
		// �ѱ��� ����ϱ� ���ؼ��� �ѱ��� �����Ǵ� ��Ʈ�� ����
		BaseFont bfKorean = BaseFont.createFont(
				request.getRealPath("/")+"/malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bfKorean);
		
		Cell cell = new Cell(new Paragraph("�̸�", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("����", font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("����", font));
		cell.setHeader(true);
		table.addCell(cell);
		table.endHeaders();
		
		// ������ ���
		for (ItemDTO item : list) {
			Cell imsi = new Cell(new Paragraph(item.getItemname(), font));
			table.addCell(imsi);
			
			imsi = new Cell(new Paragraph(item.getDescription(), font));
			table.addCell(imsi);
			
			imsi = new Cell(new Paragraph(item.getPrice() + "��", font));
			table.addCell(imsi);
		}
		document.add(table);
	}

}