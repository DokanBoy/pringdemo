package pw.zakharov.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 17:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "answers")
public class Answer implements Serializable {

    private static final long serialVersionUID = 4702956931745093412L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "correct")
    private boolean correct;

}
