package jarun.project.timesheet.repository;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jarun.project.timesheet.config.DataAccessConfig;
import jarun.project.timesheet.config.DataSourceConfig;
import jarun.project.timesheet.model.Employee;
import jarun.project.timesheet.repository.EmployeeRepository;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataAccessConfig.class,
        DataSourceConfig.class})
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.properties")
public class EmployeeRepositoryTest {

    @Resource
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindByUsername() {
        Employee employee = employeeRepository.findByUsername("emp1");
        assertEquals(1l, employee.getEmployeeId());
    }

    @Test
    public void testFindEmployeeListByProject() {
        List<Employee> list = employeeRepository.findEmployeeListByProject("bsscores");
        assertEquals(2, list.size());
    }

    @Test
    public void testFindEmployeeByFirstAndLastName() {
        Employee employee = employeeRepository.findByFirstAndLastName("Mike", "Young");
        assertEquals(Long.valueOf(2l), employee.getUser().getUserId());
    }
}
