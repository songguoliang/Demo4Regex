package com.songguoliang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式知识
 * @date 2016-04-15 10:14:48
 * @author sgl
 */
public class Demo01 {
	/**
	 * 正则表达式基础
	 * @date 2016-04-15 10:23:56
	 * @author sgl
	 */
	public static void regexBase(){
		// .表示除换行符以外的任意字符
		System.out.println("a".matches("."));//输出true
		System.out.println("1".matches("."));//输出true
		System.out.println(" ".matches("."));//输出true
		System.out.println("\t".matches("."));//输出true
		System.out.println("abc".matches(".bc"));//输出true
		
		// \d匹配数字[0-9]  digit单词的首字符，小写表示是，大写表示非
		System.out.println("1".matches("\\d"));//输出true
		System.out.println("a".matches("\\d"));//输出false
		
		// \D匹配非数字[^0-9]
		System.out.println("1".matches("\\D"));//输出false
		System.out.println("a".matches("\\D"));//输出true
		
		// \s匹配空白字符[ \t\n\x0B\f\r]  space单词的首字符，小写表示是，大写表示非
		System.out.println(" ".matches("\\s"));//输出true
		System.out.println("\t".matches("\\s"));//输出true
		System.out.println("\n".matches("\\s"));//输出true
		System.out.println("a".matches("\\s"));//输出false
		
		// \S匹配非空白字符[^\s]
		System.out.println("------");
		System.out.println(" ".matches("\\S"));//输出false
		System.out.println("\t".matches("\\S"));//输出false
		System.out.println("\n".matches("\\S"));//输出false
		System.out.println("a".matches("\\S"));//输出true
		
		// \w匹配单词字符[a-zA-Z_0-9]   word单词的首字符，小写表示是，大写表示非
		System.out.println("------");
		System.out.println(" ".matches("\\w"));//输出false
		System.out.println("a".matches("\\w"));//输出true
		System.out.println("1".matches("\\w"));//输出true
		System.out.println("A".matches("\\w"));//输出true
		System.out.println("\t".matches("\\w"));//输出false
		
		// ^匹配行的开头
		//匹配以a开头的字符串
		System.out.println("abc".matches("^a.*"));//输出true
		System.out.println("abc".matches("^b.*"));//输出false
		
		// $匹配行的开头
		//匹配以a结尾的字符串
		System.out.println("bca".matches(".*a$"));//输出true
		System.out.println("bca".matches(".*b$"));//输出false
		
		// *匹配前面的子表达式零次或多次
		System.out.println("bca".matches(".*"));//输出true
		System.out.println("bca".matches("b.*"));//输出true
		System.out.println("bca".matches("d*bca"));//输出true
		
		// +匹配前面的子表达式一次或多次
		System.out.println("bca".matches(".+ca"));//输出true
		System.out.println("bca".matches("b.+"));//输出true
		System.out.println("bca".matches("d+bca"));//输出false
		
		// ?匹配前面的子表达式零次或一次
		System.out.println("aab".matches("a?aab"));//输出true
		System.out.println("aab".matches("a?ab"));//输出true
		System.out.println("aab".matches("a?b"));//输出false
		
		// {n}匹配前面的子表达式确定的 n次,n是一个非负整数。
		System.out.println("aab".matches("a{2}b"));//输出true
		System.out.println("aab".matches("a{1}ab"));//输出true
		System.out.println("aab".matches("a{1}b"));//输出false
		
		// {n,}匹配前面的子表达式至少n次,n是一个非负整数。
		System.out.println("aab".matches("a{2,}b"));//输出true
		System.out.println("aab".matches("a{1,}ab"));//输出true
		System.out.println("aab".matches("a{1,}b"));//输出true
		System.out.println("aaaaaab".matches("a{1,}b"));//输出true
		
		// {n,m}匹配前面的子表达式至少n次且最多m次,n和m都是非负整数,其中n <= m
		System.out.println("aab".matches("a{1,2}b"));//输出true
		System.out.println("aab".matches("a{1,2}ab"));//输出true
		System.out.println("aaab".matches("a{1,2}b"));//输出false
		System.out.println("aaaaaab".matches("a{1,2}b"));//输出false
		
		// | 或者，如：x|y匹配x或者y
		System.out.println("a".matches("a|b"));//输出true
		System.out.println("b".matches("a|b"));//输出true
		System.out.println("c".matches("a|b"));//输出false
		
		// []字符集合，匹配所包含的任意一个字符，如[xyz]匹配x或y或z
		System.out.println("a".matches("[abc]"));//输出true
		System.out.println("b".matches("[abc]"));//输出true
		System.out.println("c".matches("[abc]"));//输出true
		System.out.println("d".matches("[abc]"));//输出false
		
		// [^]非字符集合,匹配未包含的任意字符,如[xyz]匹配不是x并且不是y并且不是z的字符
		System.out.println("a".matches("[^abc]"));//输出false
		System.out.println("b".matches("[^abc]"));//输出false
		System.out.println("c".matches("[^abc]"));//输出false
		System.out.println("d".matches("[^abc]"));//输出true
		
		// [a-z]字符范围,匹配指定范围内的任意字符
		System.out.println("a".matches("[a-c]"));//输出true
		System.out.println("b".matches("[a-c]"));//输出true
		System.out.println("c".matches("[a-c]"));//输出true
		System.out.println("d".matches("[a-c]"));//输出false
		
		// [^a-z]非字符范围,匹配任何不在指定范围内的任意字符
		System.out.println("a".matches("[^a-c]"));//输出false
		System.out.println("b".matches("[^a-c]"));//输出false
		System.out.println("c".matches("[^a-c]"));//输出false
		System.out.println("d".matches("[^a-c]"));//输出true
		
		// \b匹配单词边界,也就是指单词和空格间的位置。 boundary单词的首字符，小写表示是，大写表示非
		System.out.println("name".matches(".*me\\b"));//输出true
		System.out.println("mean".matches(".*me\\b"));//输出false
		
		// \B匹配非单词边界,也就是指不匹配单词和空格间的位置。
		System.out.println("name".matches(".*me\\B.*"));//输出false
		System.out.println("mean".matches(".*me\\B.*"));//输出true
		
	}
	/**
	 * 贪婪模式、非贪婪模式
	 * @date 2016-04-20 14:29:52
	 * @author sgl
	 */
	public static void greedMode(){
		//提取td元素里的内容
		String str="<table><tr><td>hello world</td><td>hello regex</td></tr></table>";
		
		//贪婪模式  * + {n,} 默认情况是贪婪模式匹配
		System.out.println("====贪婪模式=====");
		//编译正则表达式到模式对象
		Pattern p=Pattern.compile("<td>.*</td>");
		//得到匹配器
		Matcher m=p.matcher(str);
		//通过find方法查找匹配，找到就返回true，否则返回false
		while(m.find()){
			//通过group方法获取前面find查找到的子字符串，start、end方法获取子字符串开始和结束位置
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		//非贪婪模式，?跟在 * + {n,} 等的后面时，表示非贪婪模式，注意和子表达式后面的?区分开，子表达式后的?表示匹配0次或1次
		System.out.println("====非贪婪模式=====");
		p=Pattern.compile("<td>.*?</td>");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
	}
	/**
	 * 匹配时忽略大小写
	 * @date 2016-04-20 14:49:09
	 * @author sgl
	 */
	public static void caseInsensitive(){
		String str="Hello world,hello java";
		
		System.out.println("===========区分大小写===========");
		Pattern p=Pattern.compile("hello");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		System.out.println("===========不区分大小写===========");
		p=Pattern.compile("hello",Pattern.CASE_INSENSITIVE);
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
	}
	/**
	 * 匹配单词边界
	 * @date 2016-04-20 15:00:01
	 * @author sgl
	 */
	public static void wordBoundary(){
		String str="the cat scattered his food catch mcat";
		
		System.out.println("----不设置边界-----");
		Pattern p=Pattern.compile("cat");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		// \b匹配单词边界，换句话说，\b是匹配一个位置，这个位置位于一个能够用来构成单词的字符
		// (字母、数字和下划线，也就是\w相匹配的字符)和一个不能用来构成单词的字符(也就是与\W相匹配的字符)之间。
		System.out.println("----两边都设置边界-----");
		p=Pattern.compile("\\bcat\\b");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		System.out.println("----左边设置边界-----");
		p=Pattern.compile("\\bcat");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		System.out.println("----右边设置边界-----");
		p=Pattern.compile("cat\\b");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		
	}
	/**
	 * 匹配字符串，并且是以该字符串开头或结尾
	 * 字符串边界的元字符有两个：一个是用来匹配字符串开头的^，另一个是用来匹配字符串结尾的$
	 * @date 2016-04-20 15:19:14
	 * @author sgl
	 */
	public static void stringBoundary(){
		String str="hello world,hello java,hello java";
		
		System.out.println("===========匹配字符串===========");
		//匹配str中所有字符串hello，这时str中3个hello都能匹配上，通过下面打印的匹配上的字符串的位置可以看出
		Pattern p=Pattern.compile("hello");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println("===========匹配字符串，并且该字符串是在开头的位置===========");
		// ^表示匹配字符串的开头，但是如何在[]里面则表示非，如[^a-f] 不匹配a-f
		// "hello"和"^hello"的区别就是：前者匹配时不管是不是在开头位置，只要能匹配就行，后者则是不但要能匹配而且还要是在开头的位置。这时str中3个hello只有第1个能匹配上。
		p=Pattern.compile("^hello");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		System.out.println("===========匹配字符串===========");
		//这时str中两个java都能匹配上
		p=Pattern.compile("java");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println("===========匹配字符串，并且是该字符串是在末尾的位置===========");
		//这时str中两个java只有第2个才能匹配上
		p=Pattern.compile("java$");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
	}
	/**
	 * 多行模式
	 * @date 2016-04-20 15:31:19
	 * @author sgl
	 */
	public static void multiline(){
		//注意里面的换行符
		String str="hello world\r\nhello java\r\nhello java";
		
		System.out.println("===========匹配字符串开头(多行模式)===========");
		Pattern p=Pattern.compile("^hello",Pattern.MULTILINE);
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		System.out.println("===========匹配字符串结尾(多行模式)===========");
		p=Pattern.compile("java$",Pattern.MULTILINE);
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
	}
	/**
	 * 子表达式
	 * 子表达式是一个更大的表达式的一部分，子表达式必须用小括号()括起来，要当成一个独立元素来使用
	 * @date 2016-04-20 15:53:40
	 * @author sgl
	 */
	public static void subexpression(){
		//注意里面的空格&nbsp;，假如要匹配两个&nbsp;以上的空格
		String str="hello&nbsp;&nbsp;world,hello&nbsp;&nbsp;&nbsp;java";
		
		//不使用子表达式，匹配不到值，因为&nbsp;{2,}匹配类似于&nbsp;;;;;;;的字符串，而不是&nbsp;&nbsp;
		//{2,}只对前面的;分号有效
		Pattern p=Pattern.compile("&nbsp;{2,}");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		//使用子表达式,将&nbsp;作为一个整体
		p=Pattern.compile("(&nbsp;){2,}");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		//匹配ip地址(这里我不考虑大于255的情况，只要是1-3个数字都匹配)
		str="121.22.125.32,1.212.5.132";
		System.out.println("==========匹配IP地址==========");
		//普通方式匹配
		System.out.println("----------普通方式----------");
		p=Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		//子表达式方式匹配
		System.out.println("----------子表达式方式----------");
		//由于上面的正则表达式中\\d{1,3}\\.重复了3次，所以可以用子表达式简化，匹配结果与上面相同
		p=Pattern.compile("(\\d{1,3}\\.){3}\\d{1,3}");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		//上面匹配&nbsp;空格和匹配IP的两个例子，都使用了子表达式，子表达式其中一个用途就是把多个元字符或字符用小括号
		//括起来，作为一个整体(可以当成一个字符理解)，方便使用* + {n,m}等规则
		//子表达式也可以嵌套使用，下面还是通过匹配IP(不匹配大于255的IP)的例子来说明
		
		//合法IP地址的规则：
		//1、任何一个1位或2为的数字，即0-99
		//2、任何一个以1开头的3位数字，即100-199
		//3、任何一个以2开头并且第2位数字在0-4之间的3位数字，即200-249
		//4、任何一个以25开头并且第3位数字在0-5之间的3位数字，即250-255
		System.out.println("----------匹配合法的IP地址----------");
		str="121.22.125.32,10.212.5.132,260.33.22.44,23.45.600.4";
		//这里IP两边增加了边界匹配，如果不加类似于260.33.22.44可以匹配到60.33.22.44
		p=Pattern.compile("\\b((\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])\\b");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		
	}
	/**
	 * 分组
	 * @date 2016-04-20 17:02:22
	 * @author sgl
	 */
	public static void group(){
		//提取身份证号里的所属地区编号和出生日期
		String str="411421199203048877,433421199304057583";
		Pattern p=Pattern.compile("(\\d{6})(\\d{8})\\d{4}");
		Matcher m=p.matcher(str);
		while(m.find()){
			//m.group() 整个匹配结果
			//m.group(1)第一个子表达式表达式
			//m.group(2)第二个子表达式表达式
			System.out.println("身份证号："+m.group()+" 所属地区编号："+m.group(1)+" 出生日期："+m.group(2));
		}
		
		System.out.println("-----子表达式取值顺序------");
		//判断第几个表达式时，只看左括号的顺序，如下面
		//第一个表达式为((\\d{6})(\\d{8}))
		//第二个表达式为(\\d{6})
		//第三个表达式为(\\d{8})
		p=Pattern.compile("((\\d{6})(\\d{8}))\\d{4}");
		m=p.matcher(str);
		while(m.find()){
			//m.group() 整个匹配结果
			//m.group(1)第一个子表达式表达式
			//m.group(2)第二个子表达式表达式
			System.out.println("身份证号："+m.group()+" 所属地区编号+出生日期："+m.group(1)+" 所属地区编号："+m.group(2)+" 出生日期："+m.group(3));
		}
		
		
	}
	
	/**
	 * 回溯引用，前后一致匹配
	 * @date 2016-04-20 16:48:07
	 * @author sgl
	 */
	public static void backreference(){
		String str="上上海市市市";
		
		System.out.println("===========找出重复字===========");
		Pattern p=Pattern.compile("(.)\\1+");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		System.out.println("===========找出重复字母===========");
		str="aafdfdttffjjj";
		p=Pattern.compile("([a-z]+)\\1+");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		//匹配html里的标题
		str="<h1>标题1</h1><h2>标题2</h2><h3>标题3</h3><h4>标题4</h5>";
		
		System.out.println("===========匹配标题(非回溯方法)===========");
		//<h4>标题4</h5>这个不符合的标题也会被匹配
		p=Pattern.compile("<h[1-6]>.*?</h[1-6]>");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		System.out.println("===========匹配标题(回溯方法)===========");
		//<h4>标题4</h5>这个不符合的标题不会被匹配
		// \1表示前面第一个子表达式，\2表示前面第2个子表达式，依此类推
		p=Pattern.compile("<h([1-6])>.*?</h\\1>");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		
	}
	/**
	 * 替换
	 * @date 2016-04-20 18:09:00
	 * @author sgl
	 */
	public static void replace(){
		System.out.println("------将数字替换成*--------");
		String str="2013hello04world20";
		//将数字替换成*
		System.out.println(str.replaceAll("\\d","*"));
		//将连续的数字替换成*
		System.out.println(str.replaceAll("\\d+","*"));
		//将手机号后四位替换成*
		System.out.println("------将手机号后四位替换成*--------");
		str="15200001111";
		System.out.println(str.replaceAll("\\d{4}$","****"));
		
		Pattern p=Pattern.compile("\\d{4}$");
		Matcher m=p.matcher(str);
		System.out.println(m.replaceAll("****"));
		
		//给链接地址增加a标签转换成超链接
		System.out.println("--------给链接地址增加a标签转换成超链接---------");
		str="http://www.baidu.com,http://www.google.com";
		//下面这个正则只是针对上面两个网址举例使用，因此这里不考虑复杂的网址
		p=Pattern.compile("(http://www\\..*?\\.com)");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		//$1表示正则表达式里的第一个分组,$2表示第二个分组，依此类推
		System.out.println(m.replaceAll("<a href='$1'>$1</a>"));
		
		//日期格式调整成yyyy-MM-dd格式
		System.out.println("-----日期格式调整成yyyy-MM-dd格式------");
		str="我的生日是01/21/2001，你的生日是10/15/1999";
		p=Pattern.compile("(\\d{1,2})/(\\d{1,2})/(\\d{4})");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"] 年："+m.group(3)+" 月："+m.group(1)+" 日："+m.group(2));
		}
		System.out.println(m.replaceAll("$3-$1-$2"));
		
		//把手机号中间几个数字替换成*
		System.out.println("----把手机号中间几个数字替换成*-----");
		str="15200001111,13932333232";
		p=Pattern.compile("(\\d{3})(\\d{4})(\\d{4})");
		m=p.matcher(str);
		System.out.println(m.replaceAll("$1****$3"));
		
	}
	/**
	 * 前后查找(环视)
	 * 前后查找中的前、后指模式与被查找文本的相对位置而言，左为前，右为后
	 * (?=) 肯定正序环视，向右
	 * (?!) 否定正序环视，向右
	 * (?<=)肯定逆序环视，向左
	 * (?<!)否定逆序环视，向左
	 * !表示否定，=表示肯定，<表示向左
	 * 向前查找模式的长度是可变的，它们可以包含.和+之类的元字符，向后查找模式只能是固定长度
	 * @date 2016-04-21 16:30:17
	 * @author sgl
	 */
	public static void lookaround(){
		String str="hello123world45hello678java9";
		//匹配数字
		//匹配左边不是数字的数字
		System.out.println("------左边不是数字  使用(?<=)------");
		Pattern p=Pattern.compile("(?<=\\D)\\d+");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println("------左边不是数字  使用(?<!)------");
		p=Pattern.compile("(?<!\\d)\\d+");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println("------左右两边都是数字 ------");
		p=Pattern.compile("(?<=\\d)\\d+(?=\\d)");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println("------左右两边都不是数字 ------");
		p=Pattern.compile("(?<!\\d)\\d+(?!\\d)");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		//提取url里的协议名
		System.out.println("-----提取url里的协议名-------");
		str="http://www.baidu.com,https:www.apharbor.com,ftp://ftp.apharbor.com";
		//通过分组提取方式
		System.out.println("+++++++++++通过分组提取方式++++++++++++");
		p=Pattern.compile("(\\w+):");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"] 协议名："+m.group(1));
		}
		//通过前后查找(环视)方式,通过与上面的比较，可以发现前后查找的好处是只返回需要的内容，不需要的内容不再返回
		System.out.println("+++++++++++通过前后查找(环视)方式++++++++++++");
		p=Pattern.compile("\\w+(?=:)");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		//严格的说，前后查找匹配是有返回结果的，只是这个结果是一个位置(字节长度永远是0)而已，如上面的正则匹配的位
		//置是http的p字母和:之间的位置，通过下面的例子可以清楚看出
		System.out.println("++++++++++++查找一个位置并替换成*+++++++++++");
		//查找一个位置并替换成*，这个位置的前面是单词字符并且后面是:
		p=Pattern.compile("(?<=\\w+)(?=:)");
		m=p.matcher(str);
		while(m.find()){
			//注意m.group()获取的内容为空，m.start()和m.end()值一样
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println(m.replaceAll("*"));
		
		
		System.out.println("--------匹配五位数的电话---------");
		str="电话号码：15230022100,15236622140中国电信10000中国联通10010消费者投诉12315建设银行95533招商银行95555";
		//匹配五位数的电话,即匹配一个5位数，这个数左面不是数字右面也不是数字
		p=Pattern.compile("(?<!\\d)\\d{5}(?!\\d)");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		
		System.out.println("--------将金额用逗号分开---------");
		str="123456789";//123,456,789
		//str="3456789";//3,456,789
		//将金额用逗号分开,即匹配一个位置，将逗号放到这个位置，实现方法分析如下：
		//1、找一个位置，这个位置右面有n个数字，即：\d+ 并且都是3的倍数，即：(\d{3})+  所以总的表达式为(?=(\d{3})+)
		p=Pattern.compile("(?=(\\d{3})+)");
		m=p.matcher(str);
		while(m.find()){
			//789一组找到一个位置，678一组找到一个位置....123一组找到一个位置
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println(m.replaceAll(","));//输出,1,2,3,4,5,6,789
		
		//2、上一步结果为,1,2,3,4,5,6,789，说明最后一个位置找对了，之所以还出现上面的情况是因为"123456789"中678也是三个数字
		//只是678后面还是数字，为了方便先把7前的位置加个逗号，str="123456,789"，现在我们要找到第二个位置即3和4之间，观察会发现
		//456这一组数字后面不是数字，789后面也不是数字，所以我们给上面正则再加个条件即位置的右面有n个数字，并且都是3的倍数，并且
		//这n个数字后面不能是数字
		p=Pattern.compile("(?=(\\d{3})+(?!\\d))");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println(m.replaceAll(","));
		
		//3、第2步结果为,123,456,789，说明后两个位置都对了，但第一个逗号不应该有，也就是说如果该位置左侧要有数字,所以再加一个条件
		p=Pattern.compile("(?<=\\d)(?=(\\d{3})+(?!\\d))");
		m=p.matcher(str);
		while(m.find()){
			System.out.println(m.group()+"   位置：["+m.start()+","+m.end()+"]");
		}
		System.out.println(m.replaceAll(","));
		
	}
	
	public static void main(String[] args) {
		//Demo01.regexBase();
		//Demo01.greedMode();
		//Demo01.caseInsensitive();
		//Demo01.wordBoundary();
		Demo01.stringBoundary();
		//Demo01.multiline();
		//Demo01.subexpression();
		//Demo01.group();
		//Demo01.backreference();
		//Demo01.replace();
		//Demo01.lookaround();
		
		
		
		
	}
}

