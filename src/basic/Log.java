package basic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;

public class Log {
	public static String filePath="log.txt";
	public static boolean isFirst=true;
	static FileWriter writer;
    public static void toNull(String x) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            //for (int i = 0; i < 10; i++) { // ��������Ҫд��10��
                bufferedWriter.write(x); // д������
                //bufferedWriter.newLine(); // д�뻻�з�
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    public static void log(String x) {
    	// ��ȡ��ջ׷��
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // ��ȡֱ�ӵ���printMethodName������Ԫ��
        StackTraceElement callerElement = stackTrace[2];
        // ��ӡ������
        System.out.println("time:["+getTime()+"] , method:["+callerElement.getMethodName()+"] , INFO:"+x);
    	write("time:["+getTime()+"] , method:["+callerElement.getMethodName()+"] , INFO:"+x);
    }
    public static void write(String x ) {
    	appendToFile(filePath, x);
    }
    public static void appendToFile(String filePath, String content) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
            bufferedWriter.newLine(); // д��һ������
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @deprecated
     * @param sourceFile
     * @param targetDir
     * @throws IOException
     */
    public static void copyDirectory(String sourceFile, String targetDir) throws IOException {

        try {
            File fileToCopy = new File(sourceFile);
            File targetDirectory = new File(targetDir);

            // ���Ŀ��Ŀ¼�Ƿ���ڣ�����������򴴽�
            if (!targetDirectory.exists()) {
                targetDirectory.mkdirs();
            }

            // ʹ��Files���copy���������ļ�
            Path sourcePath = Paths.get(fileToCopy.toURI());
            Path targetPath = Paths.get(targetDirectory.toURI());
            Files.copy(sourcePath, targetPath.resolve(sourcePath.getFileName()));

            System.out.println("�ļ������ɹ���");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

