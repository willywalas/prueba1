package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Student;
import interfaces.StudentInterface;
import util.MySqlConexion;

public class StudentModel implements StudentInterface{

	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		Connection cn=null;
		PreparedStatement psm=null;
		ResultSet rs=null;
		
		try {
			cn = MySqlConexion.getConexion();
			String sql= "SELECT * FROM Student";
			psm=cn.prepareStatement(sql);
			rs=psm.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setIdStudent(rs.getString("idEstudent"));
				student.setName(rs.getString("name"));
				student.setLastname(rs.getString("lastname"));
				students.add(student);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) rs.close();
				if(psm!=null) psm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return students;
	}

}
