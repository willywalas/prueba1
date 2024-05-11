package dao;

import interfaces.AdviceInterface;
import interfaces.StudentInterface;
import interfaces.SubjectInterface;
import modelo.AdviceModel;
import modelo.StudentModel;
import modelo.SubjectModel;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public SubjectInterface getSubject() {
		// TODO Auto-generated method stub
		return new SubjectModel();
	}

	@Override
	public StudentInterface getStudent() {
		// TODO Auto-generated method stub
		return new StudentModel();
	}

	@Override
	public AdviceInterface getAdvice() {
		// TODO Auto-generated method stub
		return new AdviceModel();
	}

}
