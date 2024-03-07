package com.greglturnquist.payroll;

import com.greglturnquist.payroll.Employee;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void validEmployeeConstructor() throws InstantiationException {
        //act
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");

        //assert
        assertEquals("Frodo", employee.getFirstName());
        assertEquals("Baggins", employee.getLastName());
        assertEquals("ring bearer", employee.getDescription());
        assertEquals(1, employee.getJobYears());
    }

    @Test
    public void getID_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        Long expectedId = 12345L;
        employee.setId(expectedId);
        //act
        Long foundID = employee.getId();
        //assert
        assertEquals(expectedId, foundID);
    }

    @Test
    public void getFirstName_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        String expectedName = "Frodo";
        //act
        String foundName = employee.getFirstName();
        //assert
        assertEquals(expectedName, foundName);
    }

    @Test
    public void setFirstName_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        String expectedName = "Bilbo";
        //act
        employee.setFirstName(expectedName);
        String foundName = employee.getFirstName();
        //assert
        assertEquals(expectedName, foundName);
    }

    @Test
    public void getLastName_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        String expectedName = "Baggins";
        //act
        String foundName = employee.getLastName();
        //assert
        assertEquals(expectedName, foundName);
    }

    @Test
    public void setLastName_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        String expectedName = "Bilbo";
        //act
        employee.setLastName(expectedName);
        String foundName = employee.getLastName();
        //assert
        assertEquals(expectedName, foundName);
    }

    @Test
    public void getDescription_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        String expectedDescription = "ring bearer";
        //act
        String foundDescription = employee.getDescription();
        //assert
        assertEquals(expectedDescription, foundDescription);
    }

    @Test
    public void setDescription_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        String expectedDescription = "Bilbo";
        //act
        employee.setDescription(expectedDescription);
        String foundDescription = employee.getDescription();
        //assert
        assertEquals(expectedDescription, foundDescription);
    }

    @Test
    public void getJobYears_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        int expectedJobYears = 1;
        //act
        int foundJobYears = employee.getJobYears();
        //assert
        assertEquals(expectedJobYears, foundJobYears);
    }

    @Test
    public void setJobYears_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        int expectedJobYears = 2;
        //act
        employee.setJobYears(expectedJobYears);
        int foundJobYears = employee.getJobYears();
        //assert
        assertEquals(expectedJobYears, foundJobYears);
    }

    @Test
    public void nullFirstName_invalidEmployeeConstructor() throws InstantiationException {
        // arrange
        String expectedMessage = "Invalid arguments";

        // act
        Exception exception = assertThrows( InstantiationException.class, () ->
                new Employee(null, "Baggins", "ring bearer", 1, "email@email.com")
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void nullLastName_invalidEmployeeConstructor() throws InstantiationException {
        // arrange
        String expectedMessage = "Invalid arguments";

        // act
        Exception exception = assertThrows( InstantiationException.class, () ->
                new Employee("Frodo", null, "ring bearer", 1, "email@email.com")
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void nullDescriptionName_invalidEmployeeConstructor() throws InstantiationException {
        // arrange
        String expectedMessage = "Invalid arguments";

        // act
        Exception exception = assertThrows( InstantiationException.class, () ->
                new Employee("Frodo", "Baggins", null, 1, "email@email.com")
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void negativeJobYearsName_invalidEmployeeConstructor() throws InstantiationException {
        // arrange
        String expectedMessage = "Invalid arguments";

        // act
        Exception exception = assertThrows( InstantiationException.class, () ->
                new Employee("Frodo", "Baggins", "ring bearer", -1, "email@email.com")
        );

        // assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



    @Test
    public void getEmail_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        String expectedEmail = "email@email.com";
        //act
        String foundEmail = employee.getEmail();
        //assert
        assertEquals(expectedEmail, foundEmail);
    }

    @Test
    public void setEmail_validEmployeeConstructor() throws InstantiationException {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1, "email@email.com");
        String expectedEmail = "newEmail@email.com";
        //act
        employee.setEmail(expectedEmail);
        String foundEmail = employee.getEmail();
        //assert
        assertEquals(expectedEmail, foundEmail);
    }

}
