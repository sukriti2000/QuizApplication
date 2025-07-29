package com.telusko.quiz_service.service;


import com.telusko.quiz_service.Feign.QuizInterface;
import com.telusko.quiz_service.dao.QuizDao;
import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.Quiz;
import com.telusko.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int num, String title) {

        List<Integer> Questions = quizInterface.generateQuestionsForQuiz(category,num).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(Questions);
        quizDao.save(quiz);
        return new ResponseEntity("SUCCESS", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds=quiz.getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questionForUser=quizInterface.getQuestionsFromIds(questionIds);
        return questionForUser;
    }

    public ResponseEntity<Integer> CalculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
