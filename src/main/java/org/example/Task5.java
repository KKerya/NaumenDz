package org.example;

import javax.print.attribute.standard.DocumentName;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Task5 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ссылку на файл: ");
        String url = scanner.nextLine();
        System.out.print("Введите место сохранения: ");
        String output = scanner.nextLine();
        DownloadFile downloadFile = new DownloadFile(url, output);
        downloadFile.start();

        downloadFile.stop();
    }

}

class DownloadFile implements Task{

    private final String fileUrl;
    private final String outputFile;
    private boolean running = false;

    public DownloadFile(String fileUrl, String outputFile){
        this.fileUrl = fileUrl;
        this.outputFile = outputFile;
    }

    public void start(){
        if (!running){
            running = true;
            File file = new File(outputFile);

            try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
                FileOutputStream out = new FileOutputStream(outputFile)) {

                byte[] buffer = new byte[1024];
                int bytesRead = in.read(buffer);

                while (bytesRead != -1) {
                    out.write(buffer, 0, bytesRead);
                    bytesRead = in.read(buffer);
                }
            }
            catch (IOException e){
                System.out.println("Ошибка при скачивании: " + e);
                file.delete();
            }
            finally {
                running = false;
            }
        }
    }

    public void stop(){
        running = false;
    }
}
