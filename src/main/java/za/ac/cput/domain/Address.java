package za.ac.cput.domain;
/* Address.java
Entity for the Address
Author: 214258041_Lelihle Gazi
10/06/2022
 */
import java.util.Objects;


public class Address {
    private String unitNumber;
    private String complexName;
    private String streetNumber;
    private String streetName;
    private int postalCode;
    private City city;

    protected Address(){

    }
    public Address(Builder builder){
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.city = builder.city;

    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public City getCity() {
        return city;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return unitNumber.equals(address.unitNumber) && complexName.equals(address.complexName) && streetNumber.equals(address.streetNumber) && streetName.equals(address.streetName) && postalCode==(address.postalCode) && city.equals(address.city);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(unitNumber, complexName, streetNumber, streetName, postalCode, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber=" + unitNumber +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    //Implementing Builder Pattern
    public static class Builder{
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private City city;


        public Address.Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }
        public Address.Builder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Address.Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Address.Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Address.Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address.Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Address.Builder copy(Address address){
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}


