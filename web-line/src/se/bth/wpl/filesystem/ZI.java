package se.bth.wpl.filesystem;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZI extends ZC{
	
	String pathS,filenameS;
		public ZI(String path, String filename,String pathS, String fileNameS) {
		// TODO Auto-generated constructor stub
			setPath(path);
			setFileName(filename);
			
				if(pathS.endsWith("/"))
					this.pathS = pathS;
				else
					this.pathS=pathS+"/";
			filenameS=fileNameS;
	}

		public InputStream getInputStream() throws IOException {

			return new BufferedInputStream(new FileInputStream(pathS+filenameS));
    		
		
		}
}
