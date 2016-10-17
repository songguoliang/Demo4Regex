package com.songguoliang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		//提取td元素里的内容  
		String str="<table><tr>\r\n<td>hello world</td><td>hello regex</td></tr></table>";  
		Pattern p=Pattern.compile("(<td)|(tr)",Pattern.MULTILINE);
		Matcher matcher = p.matcher(str);
		while(matcher.find()){
			System.out.println(matcher.group());
		}
		System.out.println(matcher.groupCount());
	}
}
