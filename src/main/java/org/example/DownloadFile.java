package org.example;

import java.io.*;
import java.net.URL;



class DownloadFile implements Task{
    private final String fileUrl;
    private final String outputFile;

    private Thread thread;
    private volatile boolean running = false;
    private volatile boolean stoppedByUser = false;

    public DownloadFile(String fileUrl, String outputFile){
        this.fileUrl = fileUrl;
        this.outputFile = outputFile;
    }

    @Override
    public void start(){
        if (running) {
            System.out.println("Скачивание уже запущено");
            return;
        }

        running = true;

        thread = new Thread(() -> {
            String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);

            File dir = new File(outputFile);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File fullPath = new File(dir, fileName).getAbsoluteFile();

            try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
                 FileOutputStream out = new FileOutputStream(fullPath)) {

                System.out.println("Начало скачивания");

                byte[] buffer = new byte[1024];

                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    if (!running) {
                        break;
                    }
                    out.write(buffer, 0, bytesRead);
                }

                if(running && !stoppedByUser) {
                    System.out.println("Успешно завершено");
                }
                else{
                    System.out.println("Скачивание остановлено");
                    fullPath.delete();
                }

            } catch (IOException e) {
                System.out.println("Ошибка при скачивании: " + e);
                fullPath.delete();
            } finally {
                running = false;
            }
        });

        thread.start();
    }

    @Override
    public void stop(){
        running = false;
        stoppedByUser = true;
        if (thread != null) {
            thread.interrupt();
        }
    }
}
