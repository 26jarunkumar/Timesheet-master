package jarun.project.timesheet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jarun.project.timesheet.config.DataAccessConfig;
import jarun.project.timesheet.config.DataSourceConfig;
import jarun.project.timesheet.constant.Constants;
import jarun.project.timesheet.model.Manager;
import jarun.project.timesheet.model.User;
import jarun.project.timesheet.repository.ManagerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataAccessConfig.class,
        DataSourceConfig.class})
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.properties")
public class ManagerRepositoryTest {

    @Resource
    private ManagerRepository managerRepository;

    @Test
    public void testSaveManager() {
        Manager manager = new Manager();
        User user = new User("managerTest", "password", Constants.ROLE_EMPLOYEE);
        manager.setUser(user);
        manager = managerRepository.save(manager);
        assertNotNull(manager.getManagerId());
    }

    @Test
    public void testGetManagerByUserId() {
        Manager manager = managerRepository.findByUsername("manager");
        assertEquals(1l, manager.getManagerId());
    }
}
