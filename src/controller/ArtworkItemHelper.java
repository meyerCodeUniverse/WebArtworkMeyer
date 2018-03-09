package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ArtWorkItem;


public class ArtworkItemHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebArtworkMeyer");

	/** Method to insert new items into the database
	 * @param toAdd
	 */
	public void insertItem(ArtWorkItem toAdd) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	/** Method to show all items currently in the database
	 * @return a list of all items and the details of each
	 */
	public List<ArtWorkItem> showAllItems() {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ArtWorkItem> allResults = em.createQuery("select ai from ArtWorkItem ai", ArtWorkItem.class);
		List<ArtWorkItem> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}

	public void deleteItem(ArtWorkItem toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ArtWorkItem> typedQuery = em.createQuery("select ai from ArtWorkItem ai where ai.artworkArtist = :selectedArtist and ai.artworkTitle = :selectedTitle", ArtWorkItem.class);
		typedQuery.setParameter("selectedArtist", toDelete.getArtworkArtist());
		typedQuery.setParameter("selectedTitle",  toDelete.getArtworkTitle());
		typedQuery.setMaxResults(1);
		ArtWorkItem result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ArtWorkItem searchFortItemsByArtistName(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ArtWorkItem foundItem = em.find(ArtWorkItem.class, idToEdit);
		em.close();
		return foundItem;
	}

	public ArtWorkItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ArtWorkItem foundItem = em.find(ArtWorkItem.class, idToEdit);
		em.close();
		return foundItem;
	}

	public void updateItem(ArtWorkItem toEdit) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
}
	