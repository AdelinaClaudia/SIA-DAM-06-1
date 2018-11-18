package org.app.service.ejb;
import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.*;

@Remote
public interface PenalizareService {
	//create
		Penalizare addPenalizare(Penalizare penalizareToAdd);
	   
	//delete
	String removePenalizare(Penalizare penalizareToDelete);
	
	Penalizare getPenalizareByIdPenalizare(Integer idPenalizare);
	Collection<Penalizare> getPenalizare();
	
	String getMessage();
	
	Collection<Penalizare>toCollection();
	Penalizare getByIdPenalizare(Integer idP);
}
