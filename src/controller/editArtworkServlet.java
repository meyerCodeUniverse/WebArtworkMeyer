package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArtWorkItem;

/**
 * Servlet implementation class editArtworkServlet
 */
@WebServlet("/editArtworkServlet")
public class editArtworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtworkServlet() {
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
		ArtworkItemHelper dao = new ArtworkItemHelper();
		
		String artworkTitle = request.getParameter("Title");
		String artworkArtist = request.getParameter("Artist");
		String artworkMedia = request.getParameter("Media");
		String artworkYear = request.getParameter("Year");
		double artworkValue = Double.parseDouble(request.getParameter("Value"));
		Integer tempID = Integer.parseInt(request.getParameter("id"));
		
		ArtWorkItem itemToUpdate = dao.searchForItemById(tempID);
		itemToUpdate.setArtworkTitle(artworkTitle);
		itemToUpdate.setArtworkArtist(artworkArtist);
		itemToUpdate.setArtworkMedia(artworkMedia);
		itemToUpdate.setArtworkYear(artworkYear);
		itemToUpdate.setArtworkValue(artworkValue);
		
		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/vewAllArtworkServlet").forward(request, response);
	}

}
