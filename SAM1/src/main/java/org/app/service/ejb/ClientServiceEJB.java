package org.app.service.ejb;

import java.util.Collection;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.app.patterns.EntityRepositoryBase;
import org.app.service.entities.Client;
@Stateless @LocalBean 

public class ClientServiceEJB extends EntityRepositoryBase<Client> implements ClientService {
	private static Logger logger = Logger.getLogger(ClientServiceEJB.class.getName());
	@PersistenceContext(unitName="MSD")
	private EntityManager em;
	public ClientServiceEJB() {
		
	}
	@PostConstruct 
	public void init() {
		logger.info("POSTCONSTRUCT-INIT : "+ this.em);
	}
	@Override
	 public Client addClient(Client clientToAdd) {
		em.persist(clientToAdd);
		em.flush();
		em.refresh(clientToAdd);
		return clientToAdd;
	}
	@Override
	public Client getByIdClient(Integer idClient){

		return em.find(Client.class, idClient);
	}
	public Collection<Client>getClient(){
		List<Client> client=em.createQuery("Select c From Client c", Client.class).getResultList();
		return client;
	}
	//custome read 
	public Client getClientByIdClient(Integer id) {
		return em.createQuery("SELECT c from Client c Where c.idClient=:id", Client.class).setParameter("idClient", id).getSingleResult();
	}
	
	public String removeClient(Client clientToDelete) {
		clientToDelete=em.merge(clientToDelete);
		em.remove(clientToDelete);
		em.flush();
		return "true";
	}
	
	public String getMessage() {
		return "ClientServiceEJB is on ... ";
	}
	
	
	
}
