package library;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class Report {
    public static void createReport() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Books on Hold Tracker");

        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);

        XSSFRow header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        XSSFCell headerCell = header.createCell(0);
        headerCell.setCellValue("Book");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Author");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Holdee");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("Return Date");
        headerCell.setCellStyle(headerStyle);

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        XSSFRow row = sheet.createRow(1);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("The Adventures of Bob");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("Mr. Bob");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("A fan of Mr. Bob");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("July 12, 2023");
        cell.setCellStyle(style);

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "BooksOnHold.xlsx";

        try {
            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
