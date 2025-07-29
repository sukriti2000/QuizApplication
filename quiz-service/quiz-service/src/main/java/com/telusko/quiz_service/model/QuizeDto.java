package com.telusko.quiz_service.model;

import lombok.Data;

@Data
public class QuizeDto {
    private String category;
    private Integer num;
    private String title;

    public QuizeDto(String category, Integer num, String title) {
        this.category = category;
        this.num = num;
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


}
