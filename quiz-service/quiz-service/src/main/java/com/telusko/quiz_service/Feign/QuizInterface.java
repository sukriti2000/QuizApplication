package com.telusko.quiz_service.Feign;

import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions);

    @PostMapping("question/getQuestionsById")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> Ids);


    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
