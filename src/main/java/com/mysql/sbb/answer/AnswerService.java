package com.mysql.sbb.answer;


import com.mysql.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService{
    private final AnswerRepository answerRepository;



//    public void create(Question question,String content){
//        Answer answer = new Answer();
//        answer.setContent(content);
//        answer.setCreatedDate(LocalDateTime.now());
//        answer.setQuestion(question);
//        this.answerRepository.save(answer);
//    }
}