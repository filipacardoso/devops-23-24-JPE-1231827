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





}
