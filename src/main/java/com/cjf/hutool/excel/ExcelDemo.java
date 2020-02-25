package com.cjf.hutool.excel;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author cjf on 2020/2/21 12:02
 */
public class ExcelDemo {

    public static void main(String[] args) {
        BigExcelWriter bigWriter = ExcelUtil.getBigWriter("d:\\test\\test.xlsx");

    }

    @Test
    public void fun1() throws Exception {
        InputStream is = new FileInputStream(new File("d:\\test\\明细报表_20200221.xlsx"));
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);

//        Sheet sheet = workbook.getSheetAt(0);
//        int lastRowNum = sheet.getLastRowNum();
//        System.out.println(lastRowNum);
        for (Sheet sheet : workbook) {
            System.out.println(sheet.getSheetName());
            for (Row r : sheet) {
                for (Cell c : r) {
                    System.out.println(c.getStringCellValue());
                }
            }

        }
    }

    @Test
    public void fun() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 16));
    }
}
