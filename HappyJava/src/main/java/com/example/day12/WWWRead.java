package com.example.day12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WWWRead {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.likelion.net/");
            InputStream urlInput =  url.openStream();

            //URL 에서 한 줄 씩 입력 받아서 출력해보세요.
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlInput));

            String msg;
            while((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
