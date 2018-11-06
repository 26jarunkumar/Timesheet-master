package jarun.project.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jarun.project.timesheet.model.User;

/**
 * Created by jarun on 5/23/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);

    User findByUsername(String username);

    @SuppressWarnings("unchecked")
    User save(User user);

}
