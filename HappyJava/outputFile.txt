package com.example.day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        // System.out.println(System.getProperty("user.dir"));
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");
        int n;
        int cnt = 0;

        // 바이트 크기 배열만큼 읽어와서 출력하는 예제
//        byte[] bytes = new byte[1024];
//        while((n = fis.read(bytes)) != -1) {
//            String str = new String(bytes, 0, n);
//            String str2 = new String(bytes);
//            System.out.println(str);
//            System.out.println(str2);
//            System.out.println(n);
//            cnt++;
//            fos.write(bytes);
//        }

        // 한 바이트씩 읽어서 출력하는 예제
        while((n = fis.read()) != -1) {
            System.out.println((char)n);
            cnt++;
            fos.write(n);
        }
        System.out.println(cnt);
        fos.close();
    }
}
