package StudentsAPI.StudentsAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentsService {
    @Autowired
    private studentsRepository thestudentsRepository;
    public List<Students> getallStudents(){
        return thestudentsRepository.findAll();
    }
    public Optional<Students> getstudentsByID(int id){
        return thestudentsRepository.findById(id);
    }
    public Students saveStudent(Students student){
        return thestudentsRepository.save(student);
    }
    public void deleteStudent(int id){
        thestudentsRepository.deleteById(id);

    }

}
