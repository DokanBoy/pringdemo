package pw.zakharov.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pw.zakharov.demo.model.Question;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 16:57
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
