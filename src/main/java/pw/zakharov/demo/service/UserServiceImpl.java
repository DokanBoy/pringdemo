package pw.zakharov.demo.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import pw.zakharov.demo.exception.UnknownUserException;
import pw.zakharov.demo.model.User;
import pw.zakharov.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 17:23
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long createUser(byte grade) {
        return userRepository.save(new User(null, null, null, grade)).getId();
    }

    @Override
    @SneakyThrows
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new UnknownUserException("Can't find user with this id"));
    }

    @Override
    public List<User> getUsers(byte grade) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user -> user.getGrade() == grade)
                .collect(Collectors.toList());
    }

    @Override
    public void addQuestion(Long userId, Long questionId) {
        Optional<User> user = userRepository.findById(userId);

        
    }

}
