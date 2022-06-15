package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

public class NameFactoryTest {

    @Test
    void buildWithErrors(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                NameFactory.build("", "", ""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Name"));
    }
    
    @Test
    void buildWithSuccess(){
        Name name = NameFactory
                .build("test firstName", "test middleName", "test Surname");
        System.out.println(name);
        assertAll(
                () -> assertNotNull(name),
                () -> assertNotNull(name.getFirstName())
        );
    }
}
