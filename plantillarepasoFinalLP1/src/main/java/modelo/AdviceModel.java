package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidades.Advice;
import interfaces.AdviceInterface;
import util.MySqlConexion;

public class AdviceModel implements AdviceInterface {

	@Override
	public int createAdvice(Advice advice) {
		// TODO Auto-generated method stub
		int value = 0;
		Connection cn=null;
		PreparedStatement psm=null;
		try {
			cn = MySqlConexion.getConexion();
			
			String sql = "INSERT INTO Advice VALUES (null,?,?,now())";
			psm=cn.prepareStatement(sql);
			
			psm.setString(1, advice.getCodeStudent());
			psm.setString(2, advice.getCodeSubject());
			
			value=psm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(psm!=null) psm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return 0;
	}

}
