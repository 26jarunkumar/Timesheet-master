package jarun.project.timesheet.service;

import java.util.List;

import jarun.project.timesheet.model.Employee;
import jarun.project.timesheet.model.Manager;
import jarun.project.timesheet.model.Project;

public interface ProjectService {

    List<String> getProjectListByEmployee(Employee employee);

    List<String> getProjectListByManager(Manager manager);

    Project getProjectByName(String name);

    Project findManagerProject();

    Project findManagerProject(String name);

    Long saveNewProject(Project project);

    boolean updateProjectEmployeeList(String projectName, List<String> names);
}