package dao;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
	//학생정보
	public int insertStudent(Map<String, Object> params);
	
	public int updateStudent(Map<String, Object> params);
	
	public int deleteStudent(int snum);
	
	public Map<String, Object> selectOne(int snum);
	
	public List<Map<String, Object>> selectAll();
	
	public List<Map<String, Object>> selectStudentsByGrade(int grade);
	
	
}
