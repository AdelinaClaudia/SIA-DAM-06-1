package org.app.service.ejb;
import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.*;
@Remote
public interface ClientService {
	Client addClient(Client clientToAdd);
	//delete
	String removeClient(Client clientToDelete);
	
	Client getClientByIdClient(Integer idClient);
	Collection<Client> getClient();
	
	String getMessage();
	
	Collection<Client>toCollection();
	Client getByIdClient(Integer id);
}
