package se.bth.wpl.filesystem;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import se.bth.wpl.utils.ReadFiles;



/*
 * directory1/altrofile.img
 * directory2/
 * file.txt ( "mamma" )
 * 
 */

public class CreateZip  implements ICreateZip{
	private ArrayList<ZC> fzp;
	private String zipName;
	final Logger log = Logger.getLogger(CreateZip.class.getName());
	public String getZipName() {
		return zipName;
	}
	public void setZipName(String zipName) {
		this.zipName = zipName;
	}
	public CreateZip(String zipName){
		fzp=new ArrayList<ZC>();
		this.zipName=zipName;
	}
	public void addFileToZip(String path,String filename, String content){
		fzp.add(new ZT(path,filename,content));
	}
	public void addImageToZip(String path,String filename,String pathS, String filenameS){
		fzp.add(new ZI(path,filename,pathS,filenameS));
	}

	public void createZip(HttpServletResponse response) throws IOException  {

		// ..... process request

		// ..... then respond

		response.setContentType("application/x-zip-compressed");
		response.setStatus(HttpServletResponse.SC_OK);
		
		// note : intentionally no content-length set, automatic chunked transfer if stream is larger than the internal buffer of the response
		if(zipName!=""){
//			response.setHeader("Content-Disposition","inline; filename="+zipName);
			response.addHeader("Content-Disposition", "attachment; filename="+zipName+".zip");
		}
		else{
			response.addHeader("Content-Disposition", "attachment; filename=Webline.zip");
		}
		ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
		byte[] buffer = new byte[1024 * 32];
		try {


			Iterator<ZC> fzpi=fzp.iterator();
			while(fzpi.hasNext()){
				ZC zc= fzpi.next();

				InputStream in = new BufferedInputStream(zc.getInputStream());
				try {

					String fullpath= zc.getPath()+zc.getFileName();


					zipOut.putNextEntry(new ZipEntry(fullpath));

					int length = 0;
					while((length = in.read(buffer)) > 0) {
						zipOut.write(buffer, 0, length);
					}

					zipOut.closeEntry();
					log.warning("added zip entry: "+fullpath);

				} finally {
					in.close();
				}
			}


		}finally
		{ 
			zipOut.close();
			log.warning("created zip: "+zipName);
		}
	}

	public void addFolderToZip(String path, String pathS) {

		String [] suff= {"jpg","png","gif"};
		String files="";
		File folder = new File(pathS);
		
		
			File[] listOfFiles=folder.listFiles(); 
			ReadFiles rf= new ReadFiles();
			for (int i = 0; i < listOfFiles.length; i++) 
			{
				if(listOfFiles[i].getName()!=null || listOfFiles[i].getName()!=""){
					if(!listOfFiles[i].getName().contains(".svn")){
						if (listOfFiles[i].isFile() ) 
						{
							files = listOfFiles[i].getName();
							boolean im=false;
							for (int j = 0; j < suff.length; j++) {
								if(files.endsWith(suff[j])){
									im=true;
								}
							}
							if(im){
					
								String p2 =  listOfFiles[i].getPath().substring(0, listOfFiles[i].getPath().lastIndexOf("/"))+"/";
								addImageToZip(path,listOfFiles[i].getName(),p2 , listOfFiles[i].getName());
								
							}
							else {
								addFileToZip(path, listOfFiles[i].getName(), rf.readf(listOfFiles[i].getParentFile().getPath()+"/", listOfFiles[i].getName()) );
							}
	
	
						}
						else if (listOfFiles[i].isDirectory() && !listOfFiles[i].getName().contains(".svn")&& listOfFiles[i].getName()!=null) {
						
							addFolderToZip(path+"/"+listOfFiles[i].getName(),listOfFiles[i].getPath());
						}
					}
				}
			}

		}


	
}

