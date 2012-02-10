package se.bth.wpl.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadFiles {
public String readf(String path, String filename){
	try {
		if(!path.endsWith("/"))
			path+="/";
        Reader reader = new InputStreamReader(
                    new FileInputStream(path+filename),"UTF-8");
        BufferedReader fin = new BufferedReader(reader);

        String s="";
        String f="";
        while ((s=fin.readLine())!=null) {
        		f=f+s+"\n";
        		
        }
       f= f.substring(0, f.lastIndexOf("\n"));
        //Remember to call close. 
        //calling close on a BufferedReader/BufferedWriter 
        // will automatically call close on its underlying stream 
        fin.close();
        return f;
    } catch (IOException e) {
        e.printStackTrace();
    }
	return null;
	}
public String readf(String fullpath){
	try {
		
        Reader reader = new InputStreamReader(
                    new FileInputStream(fullpath),"UTF-8");
        BufferedReader fin = new BufferedReader(reader);

        String s="";
        String f="";
        while ((s=fin.readLine())!=null) {
        		f=f+s+"\n";
        		
        }
       f= f.substring(0, f.lastIndexOf("\n"));
        //Remember to call close. 
        //calling close on a BufferedReader/BufferedWriter 
        // will automatically call close on its underlying stream 
        fin.close();
        return f;
    } catch (IOException e) {
        e.printStackTrace();
    }
	return null;
	}
}
