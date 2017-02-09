package com.nupt.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args){
		String content[] = {"王浩宇","再见","张萌萌","二货","吴兵","大蠢货"};
		File file = new File("E:/file/userInformation","registerInfo.txt");
//		if(!file.exists()){
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		try {
//			FileWriter fw = new FileWriter(file,true);
//			BufferedWriter bw = new BufferedWriter(fw);
//			for(int i = 0 ;i < content.length; i+=2){
//				String str = content[i]+"     "+content[i+1];
//				
//				bw.write(str);
//				bw.newLine();
//				
//			}			
//			bw.close();
//			fw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while((str=br.readLine()) != null){
				String[] result = str.split("  ") ;
				for(int i = 0;i< result.length;i++){
					System.out.println(result[i]);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
