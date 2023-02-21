package com.tuling.designpattern.study.observer.version2;

import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {
        Editor editor = new Editor();

        // 订阅
        editor.events.subscribe("open", new LogOpenListener("D:\\Development project\\demo\\juc-demo1107\\src\\main\\java\\com\\tuling\\designpattern\\study\\observer\\version2\\log\\file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

