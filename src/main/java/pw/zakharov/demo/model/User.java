package pw.zakharov.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 16:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 8378383228112195034L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @Column(name = "answered_questions")
    private List<Question> answeredQuestions;

    @OneToMany
    @Column(name = "active_questions")
    private List<Question> activeQuestions;

    @Column(name = "grade")
    private byte grade;

}
