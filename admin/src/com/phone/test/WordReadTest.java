package com.phone.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.phone.commons.FileTool;
import com.phone.commons.TiaoKaTool;
import com.phone.commons.WordParseTool;

public class WordReadTest {
	public static List<String> huijun_sell ;
	public static List<String> dad_sell;
	public static List<String> excludes = new ArrayList<String>();
	static{
		try {
			huijun_sell = TiaoKaTool.getPhones("088031", "77080932");
			dad_sell = TiaoKaTool.getPhones("060818", "19651115");
			  
			excludes.add("13711088031");
			excludes.add("13980809363");
			excludes.add("18608013618");
			excludes.add("18123323393");
			excludes.add("18928763115");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
	public static void main(String[] args)throws Exception{
		String a= "E:\\21cn\\wife\\today\\dad.doc";
		List<String> list1 = getNoSellPhones(a);
		Collections.sort(list1);
		FileTool.WriteContext(list1,"E:\\21cn\\wife\\today\\dad_no.txt");
		
		String b= "E:\\21cn\\wife\\today\\wife.doc";
		List<String> list2 = getNoSellPhones(b);
		Collections.sort(list2);
		list2.removeAll(list1);
		FileTool.WriteContext(list2,"E:\\21cn\\wife\\today\\wife_no.txt");
		
		Set<String> set = new HashSet<String>();
		set.addAll(list1);
		set.addAll(list2);
		List<String> list3 = new ArrayList<String>(set);
		Collections.sort(list3);

		FileTool.WriteContext(list3,"E:\\21cn\\wife\\today\\common.txt");
		
		
	}
	
	public static List<String> getNoSellPhones(String wordFilePath)throws Exception{
		List<String> all = WordParseTool.getWordPhoneLines(wordFilePath);
		Set<String> set = new HashSet<String>(all);
		all = new ArrayList<String>();
		all.addAll(set);
		all.removeAll(excludes);
		List<String> some = new ArrayList<String>();
		some.addAll(huijun_sell);
		some.addAll(dad_sell);
		List<String> remains = new ArrayList<String>();
		for(int i=0;i<all.size();i++){
			String L1 = all.get(i);
			for(int j=0;j<some.size();j++){
				String L2 = some.get(j);
				if(L1.indexOf(L2)>=0){
					L1 = "";
					break;
				}
			}
			if(StringUtils.isNotBlank(L1)){
				remains.add(L1);
			}
		}
		return remains;
	}
	
}