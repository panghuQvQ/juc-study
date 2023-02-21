package com.tuling.designpattern.study.observer.version2;

import java.io.File;
import java.io.IOException;

// 收到通知后在日志中记录一条消息
public class LogOpenListener implements EventListener {

    private File log;

    public LogOpenListener(String fileName) throws IOException {

        this.log = new File(fileName);

        // 文件对象创建后，指定的文件或目录不一定物理上存在
        if(!this.log.exists()) {       //A
            this.log.mkdir();          //B
            this.log.createNewFile();  //C
        }
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }

}
