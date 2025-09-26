package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.entity.Message;
import org.springframework.stereotype.Repository;

// import io.micrometer.core.instrument.MultiGauge.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Repository
public class MessageRepository {
 private static final String FILE_PATH = "contact-messages.xlsx";

    // Save message to Excel
    public synchronized void save(Message message) throws IOException {
        File file = new File(FILE_PATH);
        Workbook workbook;
        Sheet sheet;
        int sno = 1;

        if (!file.exists()) {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("ContactMessages");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("S.No.");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");
            header.createCell(3).setCellValue("Phone");
            header.createCell(4).setCellValue("Message");
            header.createCell(5).setCellValue("Date & Time");

        } else {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            sno = sheet.getLastRowNum() + 1;
            fis.close();
        }

        Row row = sheet.createRow(sno);
        row.createCell(0).setCellValue(sno);
        row.createCell(1).setCellValue(message.getSenderName());
        row.createCell(2).setCellValue(message.getSenderEmail());
        row.createCell(3).setCellValue(message.getSenderPhoneNo());
        row.createCell(4).setCellValue(message.getSenderMessage());
        row.createCell(5).setCellValue(message.getCreatedAt());

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    // Read all messages
    public synchronized List<Message> findAll() throws IOException {
        List<Message> messages = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return messages;

        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            Message msg = new Message();
            msg.setMessageId ((int) row.getCell(0).getNumericCellValue());
            msg.setSenderName(row.getCell(1).getStringCellValue());
            msg.setSenderEmail(row.getCell(2).getStringCellValue());
            msg.setSenderPhoneNo(row.getCell(3).getStringCellValue());
            msg.setSenderMessage(row.getCell(4).getStringCellValue());
            msg.setCreatedAt(row.getCell(5).getStringCellValue());
            messages.add(msg);
        }

        workbook.close();
        fis.close();
        return messages;
    }
}
