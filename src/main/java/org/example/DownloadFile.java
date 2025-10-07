package org.example;

import java.io.*;
import java.net.URL;



class DownloadFile implements Task{
    private final String fileUrl;
    private final String outputFile;
    private boolean running = false;

    public DownloadFile(String fileUrl, String outputFile){
        this.fileUrl = fileUrl;
        this.outputFile = outputFile;
    }

    @Override
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

                System.out.println("Успешно завершено");
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

    @Override
    public void stop(){
        running = false;
    }
}
