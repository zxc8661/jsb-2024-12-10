package com.mysql.sbb.question;


import com.mysql.sbb.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.mysql.sbb.question.QuestionForm;

import java.util.List;
import java.util.Optional;


@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }

    @PostMapping("/create")
    public String QuestionCreate(@Valid QuestionForm questionForm,
                                 BindingResult bindingResult)
    {

        if(bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.createQuestion(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/question/list";
    }
}