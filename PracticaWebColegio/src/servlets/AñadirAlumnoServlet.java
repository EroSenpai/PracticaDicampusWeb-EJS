package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Alumno;
import dao.AlumnoDAO;

/**
 * Servlet implementation class AñadirAlumnoServlet
 */
@WebServlet("/AñadirAlumnoServlet")
public class AñadirAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AñadirAlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomAp = request.getParameter("nombreApellidos"); 
		String dir = request.getParameter("dirección"); 
		String email = request.getParameter("email"); 
		int tel = Integer.parseInt(request.getParameter("telefono")); 
		
		String n = nomAp.substring(0, nomAp.indexOf(" "));
		String a = nomAp.substring(nomAp.indexOf(" "));

		Alumno al = new Alumno(n,a,tel,dir,email);

		AlumnoDAO.añadir(al);

		request.getRequestDispatcher("agregar-alumnos.jsp").forward(request, response); // Añadir direccion del JSP final
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
