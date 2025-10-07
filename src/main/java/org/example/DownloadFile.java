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
            String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);

            File dir = new File(outputFile);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File fullPath = new File(dir, fileName).getAbsoluteFile();

            try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
                FileOutputStream out = new FileOutputStream(fullPath)) {

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
                fullPath.delete();
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
