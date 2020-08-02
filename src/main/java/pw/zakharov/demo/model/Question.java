package pw.zakharov.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 16:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "questions")
public class Question implements Serializable {

    private static final long serialVersionUID = -9030799252097324883L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "grade")
    private byte grade;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private Type type;

    @OneToMany
    @Column(name = "answers")
    private List<Answer> answers;

    public enum Type {
        FIND_PAIRS,
        SELECT_FROM_TWO
    }

}
