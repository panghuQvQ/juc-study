package com.tuling.designpattern.study.observer.version2;

import java.io.File;

// 观察者接口
public interface EventListener {
    void update(String eventType, File file);

}
