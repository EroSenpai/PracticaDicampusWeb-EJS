package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Alumno;
import beans.Asignatura;
import dao.AlumnoDAO;
import dao.AsignaturaDAO;

/**
 * Servlet implementation class BuscarAsignaturaServlet
 */
@WebServlet("/BuscarAsignaturaServlet")
public class BuscarAsignaturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarAsignaturaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param = request.getParameter("busqueda");
		
		HttpSession sesion = request.getSession(true);

		Asignatura asig = AsignaturaDAO.buscar(param);

		sesion.setAttribute("asignatura", asig);

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
