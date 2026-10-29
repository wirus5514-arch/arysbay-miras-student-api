
package kz.arysbay.studentapi.service;

import kz.arysbay.studentapi.model.Student;
import kz.arysbay.studentapi.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE - Add a new student
    public Student createStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    // READ - Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ - Get a student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with ID: " + id
                ));
    }

    // UPDATE - Update an existing student
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setSurname(updatedStudent.getSurname());
        existingStudent.setGroup(updatedStudent.getGroup());

        return studentRepository.save(existingStudent);
    }

    // DELETE - Delete a student
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}


