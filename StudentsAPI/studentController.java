package StudentsAPI.StudentsAPI;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class studentController {
    @Autowired
    private studentsService studentsService;
    //Firstly is to get all
    //Secondly is find by ID
    //Thirdly is to save the P
    //Fourth we have updating it
    //Lastly deleting
    @GetMapping("/allStudents")
    public List<Students> findallStudents(){
        return studentsService.getallStudents();
    }
    @GetMapping("/findStudentByID/{studentID}")
    public Optional<Students> findStudentByID(@PathVariable int studentID){
       Optional<Students> students=studentsService.getstudentsByID(studentID);
       if (students.isEmpty()){
           throw new RuntimeException("Student with that ID isnt found change it fam");
       }
       else {
           return students;
       }
    }
    @PostMapping("/saveStudent")
    public ResponseEntity<Object> addStudent(@Valid @RequestBody Students students, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }
        students.setId(0);
        return ResponseEntity.ok(studentsService.saveStudent(students));
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable int id, @Valid @RequestBody Students students, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }
        Optional<Students> existingStudent = studentsService.getstudentsByID(id);
        if (existingStudent.isEmpty()) {
            throw new RuntimeException("Student with that ID can never be found");
        } else {
            Students newStudents = existingStudent.get();
            newStudents.setId(students.getId());
            newStudents.setFirstName(students.getFirstName());
            newStudents.setLastName(students.getLastName());
            newStudents.setEmail(students.getEmail());
            newStudents.setDate(students.getDate());
            return ResponseEntity.ok(studentsService.saveStudent(newStudents));
        }
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){

        Optional<Students> studenttobedeleted=studentsService.getstudentsByID(id);
        if (studenttobedeleted.isEmpty()){
            throw new RuntimeException("Student with that ID can never be found bruv");
        }
        else {
            studentsService.deleteStudent(id);
        }
        return "Your student has been deleted";


    }


}
