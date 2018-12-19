package com.cjf.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by cjf 23:33 2018/12/15
 */
public class Demo1 {

    public static void main(String[] args) {
//    	//1.hello regex
//		p("abc".matches("..."));
//		p("a8729a".replaceAll("\\d", "-"));
//
//		String regex = "[a-z]{3}";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher("fgh");
//		p(m.matches());
//		p("fgha".matches("[a-z]{3}"));

        //2.学习 * + ？
		/*
		p("a".matches("."));
		p("aa".matches("aa"));
		p("aaaa".matches("a*"));
		p("aaaa".matches("a+"));
		p("".matches("a*"));
		p("aaaa".matches("a?"));
		p("".matches("a?"));
		p("a".matches("a?"));
		p("214523145234532".matches("\\d{3,100}"));
		p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		p("192".matches("[0-2][0-9][0-9]"));
		*/

        //3.范围 [] | &&
		/*
		p("a".matches("[abc]"));
		p("ab".matches("[^abc]"));
		p("A".matches("[a-zA-Z]"));
		p("Ab".matches("[a-z]|[A-Z]"));
		p("A".matches("[a-z[A-Z]]")); //和|语义一样，都是或的意思
		p("a".matches("[A-Z&&[RFG]]"));
		*/

        //4.认识 \s 匹配任何空白字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]
        //    \w 匹配包括下划线的任何单词字符。等价于“[A-Za-z0-9_]”
        //    \d 匹配一个数字字符。等价于[0-9]
        //    \ 将下一个字符标记为一个特殊字符、或一个原义字符、或一个向后引用、或一个八进制转义符。例如，“n”匹配字符“n”。“\n”匹配一个换行符。串行“\\”匹配“\”而“\(”则匹配“(”
		/*
		p(" \n\r\t".matches("\\s{4}"));
		p(" ".matches("\\S"));
		p("a_8".matches("\\w{3}"));
		p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
		p("\\".matches("\\\\"));
		*/

        //5.POSIX Style
        //p("a".matches("\\p{Lower}"));

        //6.boundary
		/*
		p("hello sir".matches("^h.*"));
		p("hello sir".matches(".*ir$"));
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		//white lines
		p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));

		p("aaa 8888c".matches(".*\\d{4}."));
		p("aaa 8888c".matches(".*\\b\\d{4}."));
		p("aaa8888c".matches(".*\\d{4}."));
		p("aaa8888c".matches(".*\\b\\d{4}."));
		*/

        //7.匹配email地址练习 840003625@qq.com
//		String regex = "^.{3,10}@.{1,5}\\.com";
//		p("840003625@qq.com".matches(regex));
//		p("asdfasdfsafsf@dsdfsdf.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));

        //8.matches find lookingAt
		/*
		String regex = "\\d{3,5}";
		Pattern p = Pattern.compile(regex);
		String s = "123-34345-234-00";
		Matcher m = p.matcher(s);
		//尝试将整个区域与模式进行匹配。
		p(m.matches());
		//重设此匹配器
		m.reset();
		//尝试找到匹配模式的输入序列的下一个子序列。
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
//		p(m.start() + "-" + m.end());
		//尝试将输入序列从区域开头开始与模式相匹配
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		*/

        //9.replacement
		/*
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		//p(m.replaceAll("JAVA"));
		//单双数的替换
		StringBuffer buf = new StringBuffer();
		int i=0;
		while(m.find()) {
			i++;
			if(i%2 == 0) {
				m.appendReplacement(buf, "java");
			} else {
				m.appendReplacement(buf, "JAVA");
			}
		}
		//实施终端附加和替换步骤
		m.appendTail(buf);
		p(buf);
		*/

        //10.group
		/*
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group(1));
		}
		*/

        //11.qulifiers 贪婪 非贪婪  默认是贪婪模式；在量词后面直接加上一个问号？就是非贪婪模式。
        Pattern p = Pattern.compile(".{3,10}+[0-9]");
        String s = "aaaa5bbbb6";
        Matcher m = p.matcher(s);
        if (m.find()) {
            p(m.start() + "-" + m.end());
        } else {
            p("not match!");
        }

        //12.non-capturing groups
		/*
		Pattern p = Pattern.compile(".{3}(?=a)");
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());
		}
		*/

        //13.back refenrences
		/*
		Pattern p = Pattern.compile("(\\d(\\d))\\2");
		String s = "122";
		Matcher m = p.matcher(s);
		p(m.matches());
		*/

        //14.flags
//        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        p("Java".matches("(?i)(java)"));//同上面的写法
    }

    public static void p(Object o) {
        System.out.println(o);
    }

    /**
     * 1.纯数字
     * 2.不包含t，T，d，D的字母
     * 以上两种不入黑名单，其他的都入黑名单
     */
    @Test
    public void testRegex() {
        String content = "123";
        String content1 = "abc";
        String content2 = "abc1";
        String content3 = "abct";

        String regex = "[0-9]*|[^tTdD]*";
        System.out.println(content.matches(regex));
        System.out.println(content1.matches(regex));
        System.out.println(content2.matches(regex));
        System.out.println(content3.matches(regex));
    }

    @Test
    public void fun() {
        System.out.println("abc".matches("[^tTdD]*"));
    }

}
