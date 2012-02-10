package se.bth.wpl.filesystem;

import java.io.IOException;
import java.io.InputStream;


public class ZC {
	 String path;
	 String filename;
	

	public  void setFileName(String fileName) {
		this.filename = fileName;
	}

	public InputStream getInputStream() throws IOException {
//		  // Get a file service
//		  FileService fileService = FileServiceFactory.getFileService();
//
//		  // Create a new Blob file with mime-type "text/plain"
//		  AppEngineFile file = fileService.createNewBlobFile("text/plain");
//
//		  // Open a channel to write to it
//		  boolean lock = false;
//		  FileWriteChannel writeChannel = fileService.openWriteChannel(file, lock);
//
//		  // Different standard Java ways of writing to the channel
//		  // are possible. Here we use a PrintWriter:
//		  PrintWriter out = new PrintWriter(Channels.newWriter(writeChannel, "UTF8"));
//		  out.println(content);
//		  // Close without finalizing and save the file path for writing later
//		  out.close();
//		  String path = file.getFullPath();
//
//		  // Write more to the file in a separate request:
//		  file = new AppEngineFile(path);
//
//		  // This time lock because we intend to finalize
//		  lock = true;
//		  writeChannel = fileService.openWriteChannel(file, lock);
//
//		  // This time we write to the channel using standard Java
////		  writeChannel.write(ByteBuffer.wrap
////		            ("And miles to go before I sleep.".getBytes()));
//
//		  // Now finalize
//		  writeChannel.closeFinally();
//
//		  // Later, read from the file using the file API
//		  lock = false; // Let other people read at the same time
//		  FileReadChannel readChannel = fileService.openReadChannel(file, false);
//
//		  // Again, different standard Java ways of reading from the channel.
//		  BufferedReader reader =
//		          new BufferedReader(Channels.newReader(readChannel, "UTF8"));  
//		  String line="";
//		  String linet="";
//		  while((linet=reader.readLine())!=null)
//		        line=line+linet+"\n";
//		  line=line.substring(0, line.lastIndexOf("\n")-1);
//		  // line = "The woods are lovely dark and deep."
//
//		  readChannel.close();
//
//		  // Now read from the file using the Blobstore API
////		  BlobKey blobKey = fileService.getBlobKey(file);
////		  BlobstoreService blobStoreService = BlobstoreServiceFactory.getBlobstoreService();
////		  String segment = new String(blobStoreService.fetchData(blobKey, 30, 40));
//		  
//		return new ByteArrayInputStream(line.getBytes());
//		
//	
		return null;
	}

	public  String getPath() {
		// TODO Auto-generated method stub
		return this.path;
	}

	public   String getFileName() {
		// TODO Auto-generated method stub
		return this.filename;
	}

	public  void setPath(String path) {
		if(path.endsWith("/"))
			this.path = path;
		else
			this.path=path+"/";
	}

}
