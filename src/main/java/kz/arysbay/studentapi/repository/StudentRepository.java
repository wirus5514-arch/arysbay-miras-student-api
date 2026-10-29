
package kz.arysbay.studentapi.repository;

import kz.arysbay.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}


