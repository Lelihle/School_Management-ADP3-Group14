package za.ac.cput.domain;

import org.apache.tomcat.jni.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class StudentAddress  {

    @NotNull
    @Id
    private String studentId;

    @Embedded
    private Address address;

    protected StudentAddress() {}

    private StudentAddress (Builder builder){
        this.studentId = builder.studentId;
    }

    public String getStudentId() {return studentId;}

    public Address getAddress() {return address;}

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress that = (StudentAddress) o;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    public static class Builder{
        private String studentId;

        public StudentAddress.Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentAddress.Builder copy(StudentAddress studentAddress){
            this.studentId= studentAddress.studentId;
            return this;
        }

        public StudentAddress build(){ return new StudentAddress(this);}

    }
}




