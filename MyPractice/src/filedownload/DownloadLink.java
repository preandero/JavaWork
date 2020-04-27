package filedownload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadLink  {
	public static String fileUrl = "https://unsplash.com/photos/OzAeZPNsLXk/download?force=true&w=640";
	public static String saveDir = "C:/MyDatabase";
	
	public static void downloadFile(String fileURL, String saveDir) throws IOException {
		URL url = new URL(fileUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		System.out.println(con.getResponseCode());
		
		String disposition = con.getHeaderField("Content-Disposition");
		String fileName = "";
		if (disposition != null) {
            // extracts file name from header field
            int index = disposition.indexOf("filename=");
            if (index > 0) {
                fileName = disposition.substring(index + 10,
                        disposition.length() - 1);
            }
        } else {
            // extracts file name from URL
            fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                    fileURL.length());
        }
		
		// opens input stream from the HTTP connection
		InputStream inputStream = con.getInputStream();
		String saveFilePath = saveDir + File.separator + fileName;

		// opens an output stream to save into file
		FileOutputStream outputStream = new FileOutputStream(saveFilePath);

		int bytesRead = -1;
		byte[] buffer = new byte[1024];
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		outputStream.close();
		inputStream.close();

		System.out.println("File downloaded");
		con.disconnect();
	
	}
	public static void main(String[] args) throws IOException  {

		downloadFile(fileUrl, saveDir);
	}

	

}

//class IdealBlockSize {
//    // You could alternatively use BufferedInputStream and System.in .
//    private static class MyBufferedOS extends BufferedOutputStream {
//        public MyBufferedOS() { super(System.out); }
//        public MyBufferedOS(OutputStream out) { super(out); }
//        public int bufferSize() { return buf.length; }
//        
//    }
//    
//
//    public static int VALUE = new IdealBlockSize.MyBufferedOS().bufferSize();
//    }
