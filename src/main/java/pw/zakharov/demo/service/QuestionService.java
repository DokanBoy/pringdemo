package pw.zakharov.demo.service;

import pw.zakharov.demo.model.Answer;
import pw.zakharov.demo.model.Question;

import java.util.List;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 31.07.2020 11:40
 */
public interface QuestionService {

    Long createQuestion(String theme, byte grade, String content, Question.Type type, List<Answer> answers);

    Question getQuestion(Long id);

    List<Question> getQuestions(byte grade);

}
