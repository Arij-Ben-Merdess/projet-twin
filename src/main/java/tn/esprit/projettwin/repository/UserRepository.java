package tn.esprit.projettwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projettwin.User;

@Repository("UserRepo")
public interface UserRepository extends JpaRepository<User,Long> {
}
