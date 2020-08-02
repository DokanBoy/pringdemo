package pw.zakharov.demo.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import pw.zakharov.demo.exception.UnknownUserException;
import pw.zakharov.demo.model.Answer;
import pw.zakharov.demo.model.Question;
import pw.zakharov.demo.model.User;
import pw.zakharov.demo.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 31.07.2020 11:41
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Long createQuestion(String theme, byte grade, String content, Question.Type type, List<Answer> answers) {
        return questionRepository.save(new Question(null, theme, grade, content, type, answers)).getId();
    }

    @Override
    @SneakyThrows
    public Question getQuestion(Long id) {
        Optional<Question> question = questionRepository.findById(id);

        return question.orElseThrow(() -> new UnknownUserException("Can't find question with this id"));
    }

    @Override
    public List<Question> getQuestions(byte grade) {
        return StreamSupport.stream(questionRepository.findAll().spliterator(), false)
                .filter(question -> question.getGrade() == grade)
                .collect(Collectors.toList());
    }

}
