package za.ac.cput.domain;

import javax.lang.model.element.Name;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Student {

    @NotNull
    @Id
    private String studentId;
    @NotNull private String email;

    @Embedded
    private Name name;

    protected Student(){};

    private Student(Builder builder){
        this.studentId = builder.studentId;
        this.email = builder.email;
    }

    public String getStudentId() {return studentId;}

    public String getEmail() {return email;}

    public Name getName() {return name;}


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId) && email.equals(student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, email);
    }

    public static class Builder{
        private String studentId;
        private String email;

        public Student.Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Student.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Student student){
            this.studentId= student.studentId;
            this.email = student.email;
            return this;
        }

        public Student build(){ return new Student(this);}

    }


}
