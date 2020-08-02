package pw.zakharov.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pw.zakharov.demo.model.User;

/**
 * Created by: Alexey Zakharov <alexey@zakharov.pw>
 * Date: 30.07.2020 16:53
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
