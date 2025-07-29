package com.telusko.question_service.dao;

import com.telusko.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT id FROM questions WHERE category = :category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(@Param("category") String category, @Param("num") int num);

}
