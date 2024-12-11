package com.mysql.sbb.answer;


import org.springframework.ui.Model;
import com.mysql.sbb.question.Question;
import com.mysql.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;


//    @PostMapping("/create/{id}")
//    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content){
//        Question question = this.questionService.getQuestion(id);
//        this.answerService.create(question,content);
//        return String.format("redirect:/question/detail/%s",id);
//    }
}