package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IStudentDao;

public interface IStudentService {

	public List<Map<String, Object>> studentListByGrade(int grade);
	public boolean addStudent(String name, int grade);
}
