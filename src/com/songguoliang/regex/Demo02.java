package com.songguoliang.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 读取网页中邮件
 * @date 2016-04-27 10:28:11
 * @author sgl
 */
public class Demo02 {
	/**
	 * 根据url读取网页内容
	 * @date 2016-04-27 10:34:13
	 * @author sgl
	 * @param urlStr
	 * @return
	 */
	public static String readHtml(String urlStr){
		StringBuffer sb=new StringBuffer("");
		BufferedReader br=null;
		try {
			URL url=new URL(urlStr);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			InputStream in=conn.getInputStream();
			br=new BufferedReader(new InputStreamReader(in));
			String line=null;
			while((line=br.readLine())!=null){
				sb.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return sb.toString();
	}
	/**
	 * 从字符串中找出邮件地址
	 * @date 2016-04-27 10:35:27
	 * @author sgl
	 * @param str
	 * @return
	 */
	public static List<String>findEmail(String str){
		Pattern p=Pattern.compile("[\\w-]+@[\\w\\.-]*\\w+\\.\\w{2,6}");
		Matcher m=p.matcher(str);
		List<String>list=new ArrayList<String>();
		while(m.find()){
			list.add(m.group());
		}
		return list;
	}
	
	public static void main(String[] args) {
		String htmlTxt=Demo02.readHtml("http://blog.sina.com.cn/s/blog_515617e60101e151.html");
		List<String>list=Demo02.findEmail(htmlTxt);
		for(String email:list){
			System.out.println(email);
		}
		System.out.println(list.size());
	}
}

