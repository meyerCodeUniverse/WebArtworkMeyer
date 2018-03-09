package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArtWorkItem;

/**
 * Servlet implementation class editArtworkInventoryServlet
 */
@WebServlet("/editArtworkInventoryServlet")
public class editArtworkInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtworkInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		
		ArtworkItemHelper awh = new ArtworkItemHelper();
		String act = request.getParameter("doThisToItem");
		
		if (act == null) {
				// no button has been selected
			getServletContext().getRequestDispatcher("/vewAllArtworkServlet").forward(request, response);
		} else if (act.equals("Delete Selected Item")) {
			Integer tempID = Integer.parseInt(request.getParameter("id"));
			ArtWorkItem itemToDelete = awh.searchForItemById(tempID);
			awh.deleteItem(itemToDelete);
					
			getServletContext().getRequestDispatcher("/vewAllArtworkServlet").forward(request, response);
		} else if (act.equals("Edit Selected Item")) {
			Integer tempID = Integer.parseInt(request.getParameter("id"));
			ArtWorkItem itemToEdit = awh.searchForItemById(tempID);
			request.setAttribute("itemToEdit", itemToEdit);
			
			getServletContext().getRequestDispatcher("/edit-Artwork.jsp").forward(request, response);
		} else if (act.equals("Add New Item")) {
			getServletContext().getRequestDispatcher("/addArtwork.html").forward(request, response);
		}
	}

}
