package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Alumno;
import beans.Profesor;
import dao.AlumnoDAO;
import dao.ProfesorDAO;

/**
 * Servlet implementation class BuscarProfesorServlet
 */
@WebServlet("/BuscarProfesorServlet")
public class BuscarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProfesorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String param = request.getParameter("parametro"); //cambiar por nombre de Field del formulario

		HttpSession sesion = request.getSession(true);

		Profesor prof = ProfesorDAO.buscar(param); //SEGUIR MODIFICANDO profesorDAO

		sesion.setAttribute("profesor", prof);

		request.getRequestDispatcher("").forward(request, response); // Añadir direccion del JSP final

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
