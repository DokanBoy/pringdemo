package pw.zakharov.demo.controller;

import org.springframework.web.bind.annotation.*;
import pw.zakharov.demo.model.Answer;
import pw.zakharov.demo.model.Question;
import pw.zakharov.demo.service.QuestionService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 31.07.2020 11:37
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(value = "/create")
    public Long createQuestion(@RequestParam(value = "theme") String theme,
                               @RequestParam(value = "grade") byte grade,
                               @RequestParam(value = "content") String content,
                               @RequestParam(value = "type") String type,
                               @RequestParam(value = "answer") Answer[] answers) {
        return questionService.createQuestion(theme, grade, content, Question.Type.valueOf(type), Arrays.asList(answers));
    }

    @GetMapping(value = "/get")
    public Question getUser(@RequestParam(value = "id") Long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping(value = "/list")
    public List<Question> getAll(@RequestParam(value = "grade") byte grade) {
        return questionService.getQuestions(grade);
    }

}
