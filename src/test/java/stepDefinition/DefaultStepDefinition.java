package stepDefinition;

import java.util.Map;

import java.io.FileInputStream;
import java.util.*;

import io.cucumber.java.en.Given;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DefaultStepDefinition {
    private static List<Map<String, String>> sheetData;
    private static Map<String, String> currentIterationMap;

    @Given("a workbook named {string} and sheet name {string} is read")
    public void aWorkbookNamedAndSheetNameIsRead(String workbookName, String sheetName) {
        DefaultStepDefinition.readExcel(workbookName, sheetName);
    }

    /**
     * Reads the given .xlsx under src/test/resources/data/
     * and populates sheetData.
     */
    public static void readExcel(String workbookName, String sheetName) {
        sheetData = new ArrayList<>();
        String path = "src/test/resources/data/" + workbookName + ".xlsx";
        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheet(sheetName);
            Row header = sheet.getRow(0);

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                Map<String, String> rowData = new HashMap<>();
                for (int c = 0; c < header.getLastCellNum(); c++) {
                    String key = header.getCell(c).getStringCellValue();
                    String val = row.getCell(c).getStringCellValue();
                    rowData.put(key, val);
                }
                sheetData.add(rowData);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel: " + path, e);
        }
    }

    /**
     * Finds the row whose TestCaseID matches and stores it
     * as the "current iteration".
     */
    public static void selectTestCase(String testCaseId) {
        if (sheetData == null) {
            throw new IllegalStateException("You must call readExcel() first");
        }
        currentIterationMap = sheetData.stream()
                .filter(m -> testCaseId.equals(m.get("TestCaseID")))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("No row found for TestCaseID=" + testCaseId));
    }

    /** Anywhere you need data: */
    public static Map<String, String> getCurrentIterationMap() {
        if (currentIterationMap == null) {
            throw new IllegalStateException("You must call selectTestCase() first");
        }
        return currentIterationMap;
    }

}
