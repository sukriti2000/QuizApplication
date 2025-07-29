package com.telusko.question_service.service;

import com.telusko.question_service.dao.QuestionDao;
import com.telusko.question_service.model.Question;
import com.telusko.question_service.model.QuestionWrapper;
import com.telusko.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
         questionDao.save(question);
         return new ResponseEntity<>("saved",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> Ids = questionDao.findRandomQuestionByCategory(categoryName,numQuestions);
        return new ResponseEntity<>(Ids,HttpStatus.OK) ;
        }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> Ids) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(Integer id : Ids){
            questions.add(questionDao.findById(id).get());
        }

        for(Question question : questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }
    public ResponseEntity<Integer> getScore(List<Response> responses) {


        int right = 0;

        for(Response response : responses){
            Question question = questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
