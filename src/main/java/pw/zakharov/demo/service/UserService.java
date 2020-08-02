package pw.zakharov.demo.service;

import pw.zakharov.demo.model.User;

import java.util.List;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 17:22
 */
public interface UserService {

    Long createUser(byte grade);

    User getUser(Long id);

    List<User> getUsers(byte grade);

    void addQuestion(Long userId, Long questionId);
}
