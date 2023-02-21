package com.tuling.designpattern.study;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ChainOfResponsibilityTest.java
 * @Description TODO 责任链模式
 * @createTime 2023年02月20日 17:20:00
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOk(false).loggedOn(false).build();

        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));
        if(requestFrequentHandler.process(request)){
            System.out.println("正常业务处理");
        }else {
            System.out.println("访问异常");
        }
    }

}

// 封装请求数据
class Request {
    private boolean loggedOn; // 是否登录
    private boolean frequentOk; // 访问频率
    private boolean isPermits; // 是否授权
    private boolean containsSensitiveWords; // 是否包含敏感词汇
    private boolean requestBody;

    public Request(boolean loggedOn, boolean frequentOk, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder {
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermits;
        private boolean containsSensitiveWords;

        RequestBuilder loggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }

        RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder isPermits(boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }

        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build() {
            Request request = new Request(loggedOn, frequentOk, isPermits, containsSensitiveWords);
            return request;
        }
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isPermits() {
        return isPermits;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }
}

// 基础验证接口
@Data
abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("访问频率控制.");
        if (request.isFrequentOk()) {
            Handler next = getNext();
            if (next == null) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}

class LoggingHandler extends Handler {

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("登录验证.");
        if (request.isLoggedOn()) {
            Handler next = getNext();
            if (next == null) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
