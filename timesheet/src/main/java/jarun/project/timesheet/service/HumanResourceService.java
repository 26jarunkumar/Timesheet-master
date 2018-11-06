package jarun.project.timesheet.service;

import java.util.List;

import jarun.project.timesheet.model.Employee;
import jarun.project.timesheet.model.Manager;
import jarun.project.timesheet.model.User;

public interface HumanResourceService {

    Manager getCurrentManager();

    Long registerNewEmployee(User user);

    Employee getEmployeeByUsername(String employeeName);

    Employee getEmployeeByRealName(String name);

    List<String> getEmployeeNameListByProjectName(String projectName);
}