package StudentsAPI.StudentsAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentsRepository extends JpaRepository<Students,Integer> {

}
