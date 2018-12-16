package com.cjf.regex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by cjf 15:39 2018/12/16
 * 爬取email
 */
public class EmailSpider {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("h:\\给我留下你的邮箱吧.html"));
//            BufferedReader br = new BufferedReader(new FileReader("h:\\111.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("h:\\email.txt"));
            String regex = "([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})";
//            String regex = "[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+";
//            String regex = "^.{3,10}@.{1,5}\\.com";
            Pattern pattern = Pattern.compile(regex);
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    bw.write(matcher.group());
                    bw.newLine();
                    bw.flush();
                }
            }
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
