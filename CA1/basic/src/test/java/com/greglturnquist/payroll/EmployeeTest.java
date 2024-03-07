package com.greglturnquist.payroll;

import com.greglturnquist.payroll.Employee;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void validEmployeeConstructor() {
        //act
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);

        //assert
        assertEquals("Frodo", employee.getFirstName());
        assertEquals("Baggins", employee.getLastName());
        assertEquals("ring bearer", employee.getDescription());
        assertEquals(1, employee.getJobYears());
    }

    @Test
    public void getID_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        Long expectedId = 12345L;
        employee.setId(expectedId);
        //act
        Long foundID = employee.getId();
        //assert
        assertEquals(expectedId, foundID);
    }

    @Test
    public void getFirstName_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        String expectedName = "Frodo";
        //act
        String foundName = employee.getFirstName();
        //assert
        assertEquals(expectedName, foundName);
    }

    @Test
    public void setFirstName_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        String expectedName = "Bilbo";
        //act
        employee.setFirstName(expectedName);
        String foundName = employee.getFirstName();
        //assert
        assertEquals(expectedName, foundName);
    }

    @Test
    public void getLastName_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        String expectedName = "Baggins";
        //act
        String foundName = employee.getLastName();
        //assert
        assertEquals(expectedName, foundName);
    }

    @Test
    public void setLastName_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        String expectedName = "Bilbo";
        //act
        employee.setLastName(expectedName);
        String foundName = employee.getLastName();
        //assert
        assertEquals(expectedName, foundName);
    }

    @Test
    public void getDescription_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        String expectedDescription = "ring bearer";
        //act
        String foundDescription = employee.getDescription();
        //assert
        assertEquals(expectedDescription, foundDescription);
    }

    @Test
    public void setDescription_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        String expectedDescription = "Bilbo";
        //act
        employee.setDescription(expectedDescription);
        String foundDescription = employee.getDescription();
        //assert
        assertEquals(expectedDescription, foundDescription);
    }

    @Test
    public void getJobYears_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        int expectedJobYears = 1;
        //act
        int foundJobYears = employee.getJobYears();
        //assert
        assertEquals(expectedJobYears, foundJobYears);
    }

    @Test
    public void setJobYears_validEmployeeConstructor() {
        //arrange
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer", 1);
        int expectedJobYears = 2;
        //act
        employee.setJobYears(expectedJobYears);
        int foundJobYears = employee.getJobYears();
        //assert
        assertEquals(expectedJobYears, foundJobYears);
    }






}
