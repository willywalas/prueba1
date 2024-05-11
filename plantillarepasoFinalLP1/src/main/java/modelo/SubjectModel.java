package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Subject;
import interfaces.SubjectInterface;
import util.MySqlConexion;

public class SubjectModel implements SubjectInterface {

	@Override
	public List<Subject> listSubjects() {
		// TODO Auto-generated method stub
		List<Subject> listSubject = new ArrayList<Subject>();
		Connection cn= null;
		PreparedStatement psm =null;
		ResultSet rs=null;
		
		try {
			cn= MySqlConexion.getConexion();
			String sql="SELECT * FROM Subject";
			psm = cn.prepareStatement(sql);
			rs=psm.executeQuery();
			
			while(rs.next()) {
				Subject subj = new Subject();
				
				subj.setId(rs.getString("idSubject"));
				subj.setName(rs.getString("name"));
				subj.setAvailable(rs.getInt("available"));
				
				listSubject.add(subj);
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
		
		return listSubject;
	}

}
