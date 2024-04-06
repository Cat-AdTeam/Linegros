package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lister {
    public static String[] reader() {
    	String[] folderNames = null;
        String dirPath = "songs/";
        File dir = new File(dirPath);
        
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            
            // �����ļ���
            int count = 0;
            for (File file : files) {
                if (file.isDirectory()) {
                    count++;
                }
            }
            
            // ���������ļ������Ƶ�����
            folderNames = new String[count];
            
            // �����ļ������Ƶ�����
            int index = 0;
            for (File file : files) {
                if (file.isDirectory()) {
                    folderNames[index] = file.getName();
                    index++;
                }
            }
        }
		return folderNames;
    }
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void initSongs() {
    	File file =new File("songs/");    
    	//����ļ��в������򴴽�    
    	if  (!file .exists()  && !file .isDirectory())      
    	{       
    	    Log.log("songs/ Ŀ¼�����ڣ�������songs�ļ���");  
    	    Root.stage.close();
    	    //try {
				//Log.copyDirectory("/songs/", "songs/");
			//} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}  
    	} else   
    	{  
    	    Log.log("songs/ Ŀ¼����");  
    	}
    }
    
}

        

