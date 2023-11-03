package hw6_21000699_dangngocquan.exercise003;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void writeToFile(String document) {
        // Create folder if not exist
        String pathDir = System.getProperty("user.dir")
                + "/src/hw6_21000699_dangngocquan/exercise003";
        File dir = new File(pathDir);
        if (!dir.exists()) {
            boolean wasSuccessful = dir.mkdirs();
            if (!wasSuccessful) {
                System.out.println("Create folder was not successful.");
            }
        }

        // Create file if not exist
        String pathFile = pathDir + "/statistic.txt";
        File file = new File(pathFile);
        if (!file.exists()) {
            try {
                boolean wasSuccessful = file.createNewFile();
                if (!wasSuccessful) {
                    System.out.println("Create file was not successful.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Append content to file
        try {
            FileOutputStream f = new FileOutputStream(pathFile , true);
            OutputStreamWriter writer = new OutputStreamWriter(f, StandardCharsets.UTF_8);
            writer.write(document);
            writer.flush();
            writer.close();
            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}