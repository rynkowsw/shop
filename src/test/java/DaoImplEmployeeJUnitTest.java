/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.cudlax.dao.impl.EmployeeDAOImpl;
import pl.cudlax.dao.impl.ProductDAOImpl;
import pl.cudlax.domain.Employee;
import pl.cudlax.domain.Product;

/**
 *
 * @author arekb
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DaoImplEmployeeJUnitTest {
    
    
    private Employee employee;
    public DaoImplEmployeeJUnitTest() {
        employee = new Employee();
        employee.setEmployeeId((long) 1);
        employee.setFunction("function");
        employee.setType("WORKER");
        employee.setUser(null);
        employee.setActive(true);
    }
    
    @Autowired
    public EmployeeDAOImpl employeeDAOImpl;

    
    public void setEmployeeDAOImpl(EmployeeDAOImpl employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }

       @Test
     public void eigthTest() {//TEST-SPRAWDZENIE POPRAWNOSCI INICJALIZACJI OBIEKTU DAO
        assertEquals((long) 1,(Object)employee.getEmployeeId());
        assertEquals("function",employee.getFunction());
        assertEquals("WORKER",employee.getType());
        assertEquals(null,employee.getUser());
    }
      @Test
     public void ninthTest() {//TEST-SPRAWDZENIE FUNKCJI DODANIA NOWEGO PRACOWNIKA
          employeeDAOImpl.addEmployee(employee);
          int id = employeeDAOImpl.getEmployees().size() - 1;
          assertEquals("function", employeeDAOImpl.getEmployees().get(id).getFunction());
          assertEquals("WORKER", employeeDAOImpl.getEmployees().get(id).getType());
          assertEquals(null, employeeDAOImpl.getEmployees().get(id).getUser());
         
     }
     @Test
     public void tenthTest() {//TEST-SPRAWDZENIE FUNKCJI UPDATE
          
         employee.setFunction("newFunction");
         employeeDAOImpl.updateEmployee(employee);
         assertEquals(employee.getFunction(), employeeDAOImpl.getEmployees().get(0).getFunction());
         employee.setFunction("function");
         employeeDAOImpl.updateEmployee(employee);
     }
      @Test
     public void eleventhTest() {//TEST-SPRAWDZENIE FUNKCJI REMOVE
          int employeeListSizeExpected=employeeDAOImpl.getEmployees().size()-1;
          employee.setEmployeeId((long) employeeDAOImpl.getEmployees().get(employeeListSizeExpected).getEmployeeId());
          employeeDAOImpl.removeEmployee(employee);
          int employeeListSizeGot = employeeDAOImpl.getEmployees().size();
          assertEquals(employeeListSizeExpected, employeeListSizeGot);
     }

}
