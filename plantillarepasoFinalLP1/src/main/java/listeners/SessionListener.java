package listeners;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.DAOFactory;
import entidades.Student;
import entidades.Subject;
import interfaces.StudentInterface;
import interfaces.SubjectInterface;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	public static List<Subject> dataSubject;

	/**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("cualquiera");
    	
    	DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
    	SubjectInterface dao = daoFactory.getSubject();
    	StudentInterface daoStudent = daoFactory.getStudent();
    	
    	dataSubject = dao.listSubjects();
    	List<Student> dataStudent = daoStudent.listStudents();
    	
    	System.out.println(dataSubject);
    	System.out.println(dataStudent);
    	
    	se.getSession().setAttribute("listSubject", dataSubject);
    	se.getSession().setAttribute("listStudent", dataStudent);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	
    	se.getSession().invalidate();
    }
	
}
