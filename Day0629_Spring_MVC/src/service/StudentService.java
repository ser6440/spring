package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IStudentDao;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	IStudentDao  studentDao;

	@Override
	public List<Map<String, Object>> studentListByGrade(int grade) {
		return studentDao.selectStudentsByGrade(grade);
	}

	@Override
	public boolean addStudent(String name, int grade) {
		//파라미터로 넘어온 데이터를 Map으로 만들고 dao에 인자로 넘겨준다.
		Map<String, Object> param  = new HashMap<String, Object>();
		param.put("name", name);
		param.put("grade", grade);
		
		System.out.println("num1 : " + param.get("num"));
		
		int result = studentDao.insertStudent(param);
		//insert후에, 자동으로 생성된 num을 어떻게 가져오나??
		System.out.println("num2 : " + param.get("num"));
		
		if(result > 0 ) {
			return true;
		}else {
			return false;
		}
	}
}






