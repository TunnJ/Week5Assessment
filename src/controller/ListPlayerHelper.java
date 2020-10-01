package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListPlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	public void insertPlayer(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListItem> showAllPlayers(){
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allPlayers = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allPlayers;
	}
	
	public void deletePlayer(ListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.team = :selectedTeam and li.name = :selectedName", ListItem.class);
		
		typedQuery.setParameter("selectedTeam", toDelete.getTeam());
		typedQuery.setParameter("selectedName", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		ListItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListItem searchForPlayerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return	found;
	}

	public void updatePlayer(ListItem toEdit) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListItem> searchForPlayerByTeam(String teamName) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem>	typedQuery	=	em.createQuery("select li from ListItem	li where li.team =	:selectedTeam", ListItem.class);
		typedQuery.setParameter("selectedTeam",	teamName);
		List<ListItem>	foundItems	=	typedQuery.getResultList();
		em.close();
		return	foundItems;
	}

	public List<ListItem> searchForPlayerByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.name = :selectedName",	ListItem.class);
		typedQuery.setParameter("selectedName",	name);
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
