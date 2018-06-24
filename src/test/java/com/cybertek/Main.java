package com.cybertek;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main{

public static void main(String[] args)  {
	List<String> list = new ArrayList<>();
	try  (
		FileReader fr = new FileReader("Language.txt");
		BufferedReader br = new BufferedReader(fr); )
	
	{
		
			String line = "";
			while ((line = br.readLine()) != null) {
				list.add(line);
		}
		} catch (IOException e) {
			e.printStackTrace();}
			Translate.translating(list);
		}

	}



















