package se.bth.wpl.filesystem;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public interface ICreateZip {
	public void addFileToZip(String path,String filename, String content);
	/**
	 * @param path to the zip file where the image will be stored
	 * @param filename to the zip file where the image will be stored
	 * @param pathS of the source file where the image will be loaded
	 * @param filenameS of the source file where the image will be loaded
	 */
	public void addImageToZip(String path,String filename,String pathS, String filenameS);
	public void createZip(HttpServletResponse response)throws IOException;
	public String getZipName();
	public void setZipName(String zipName);
	public void addFolderToZip(String path,String pathS);
}
