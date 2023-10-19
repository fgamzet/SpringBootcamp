package yte.intern.springapplication.common.response;

import yte.intern.springapplication.student.entity.Student;


public record StudentResponse(
        String name,
        String surname,
        String email,
        String tcKimlikNo,
        String studentNumber
) {
    public StudentResponse(Student student) {
     this(student.getName(),student.getSurname(),student.getEmail(),student.getTcKimlikNo(),student.getStudentNumber());
    }
}
