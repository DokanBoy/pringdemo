package pw.zakharov.demo.controller;

import org.springframework.data.domain.Range;
import org.springframework.web.bind.annotation.*;
import pw.zakharov.demo.model.User;
import pw.zakharov.demo.service.UserService;

import java.util.List;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 16:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public Long createUser(@RequestParam(value = "grade") byte grade) {
        if (!Range.closed(1, 11).contains((int) grade)) {
            throw new IllegalArgumentException("So big");
        }
        return userService.createUser(grade);
    }

    @GetMapping(value = "/get")
    public User getUser(@RequestParam(value = "id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping(value = "/list")
    public List<User> getAll(@RequestParam(value = "grade", required = false, defaultValue = "all") String grade) {
        if (grade.equalsIgnoreCase("all")) {
            return userService.getUsers();
        }
        return userService.getUsers(Byte.parseByte(grade));
    }

    @PostMapping(value = "/addQuestion")
    public void addQuestion(@RequestParam(value = "questionId") Long userId,
                            @RequestParam(value = "questionId") Long questionId) {
        userService.updateQuestions(userId, questionId);
    }

}
