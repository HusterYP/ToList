package com.example.yuanping.todolist.bean;

public class Events {
    private String title;
    private String content;
    private boolean complete;

    public Events(String title, String content, boolean complete) {
        this.title = title;
        this.content = content;
        this.complete = complete;
    }

    public Events() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
