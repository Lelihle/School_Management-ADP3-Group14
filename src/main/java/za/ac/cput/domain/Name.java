package za.ac.cput.domain;

import java.util.Objects;

public class Name {
    private final String firstName, middleName, surname;
    private Name(Name.Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.surname = builder.surname;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }
    public static class Builder{
        private String firstName, middleName, surname;

        public Builder firstName (String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder middleName (String middleName){
            this.middleName = middleName;
            return this;
        }

        public Builder surname (String surname){
            this.surname = surname;
            return this;
        }

        public Builder copy (Name name){
            this.firstName = name.firstName;
            this.middleName = name.middleName;
            this.surname = name.surname;
            return this;
        }

        public Name build(){
            return new Name(this);
        }
    }

    public static class NameId{
        private String firstName, middleName, surname;

        public NameId(String firstName, String middleName,  String surname) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.surname = surname;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public int hashCode (){return Objects.hash(firstName, middleName, surname);}

        @Override
        public String toString(){
            return "Name{" +
                    "firstName='" + firstName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", surname='" + surname + '\'' +
                    ']';
        }

    }
}

