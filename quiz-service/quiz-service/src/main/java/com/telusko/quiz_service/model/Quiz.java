package com.telusko.quiz_service.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Quiz")
public class Quiz {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;

    @ElementCollection
    private List<Integer> questionsIds;

    public Quiz(Integer id, List<Integer> questionsIds, String title) {
        this.id = id;
        this.questionsIds = questionsIds;
        this.title = title;
    }

    public Quiz() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestionsIds() {
        return questionsIds;
    }

    public void setQuestionsIds(List<Integer> questionsIds) {
        this.questionsIds = questionsIds;
    }
}
