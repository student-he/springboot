package lesson.file;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Mr He
 */
@Slf4j
public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\Study\\Java\\springboot\\src\\main\\resources\\file\\a.txt");
            fileOutputStream = new FileOutputStream("fileoutputstream.txt");
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] bytesInfo = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytesInfo)) != -1) {
                bufferedOutputStream.write(bytesInfo, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
            }
        }

    }
}
