package filedownload;

import java.io.IOException;

public class yourdown2 {
 
    public static void main(String[] args) {
        String fileURL = "https://unsplash.com/photos/OzAeZPNsLXk/download?force=true&w=640";
        String saveDir = "C:/MyDatabase";
        try {
            yourdown.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
