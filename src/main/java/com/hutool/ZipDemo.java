package com.hutool;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author cjf on 2020/2/19 19:24
 */
public class ZipDemo {

    public static void main(String[] args) throws Exception {
//        String fileName1 = "测试1.xls";
//        String fileName2 = "测试2.xls";
        String path = "d:\\test";
        File file1 = new File(path);
        File[] files = file1.listFiles();
        String filePath = "d:\\test\\测试.zip";
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(filePath));
        FileInputStream fis = null;
        for (File file : files) {
            String fileName = file.getName();
            fis = new FileInputStream(file);
            ZipEntry entry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(entry);
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fis.read(buffer)) != -1) {
                zipOutputStream.write(buffer, 0, len);
            }
        }
        fis.close();
        zipOutputStream.close();
    }


    @Test
    public void fun() {
        String filePath = "d:\\test\\";
        String zipName = filePath + "test.zip";
        File file = new File(filePath);
        File[] files = file.listFiles();
        ArrayList<File> files1 = new ArrayList<>();
        for (File file1 : files) {
            files1.add(file1);
        }

        boolean zip = zip(zipName, files1);
        System.out.println(zip);
    }

    private boolean zip(String zipName, ArrayList<File> files) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipName));
            FileInputStream fis = null;
            for (File file : files) {
                fis = new FileInputStream(file);
                ZipEntry entry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(entry);
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = fis.read(buffer)) != -1) {
                    zipOutputStream.write(buffer, 0, len);
                }
            }
            if (fis != null) {
                fis.close();
            }
            zipOutputStream.close();
            return true;

        } catch (Exception e) {
        }
        return false;
    }

    @Test
    public void fun1() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        int i = Math.abs(Integer.MAX_VALUE + 1);
        System.out.println(i < 0);
        System.out.println(-i);
        System.out.println(Math.abs(-5));
        System.out.println(Math.abs(Integer.MAX_VALUE));

    }

    @Test
    public void fun2() {
        final char NAME_VALUE_SEPARATOR = 1;
        final char PROPERTY_SEPARATOR = 2;
        System.out.println(NAME_VALUE_SEPARATOR);
        System.out.println(PROPERTY_SEPARATOR);
    }

}
