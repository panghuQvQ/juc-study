package com.tuling.designpattern.study.observer.version2;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 基础发布者
public class EventManager {

    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation,new ArrayList<>());
        }
    }

    // 订阅
    public void subscribe(String eventType,EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    // 退订
    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    // 通知
    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
