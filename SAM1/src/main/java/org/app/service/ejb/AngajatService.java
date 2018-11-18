package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.*;

@Remote
public interface AngajatService {
	//create
	Angajat addAngajat(Angajat angajatToAdd);
	//delete
	String removeAngajat(Angajat angajatToDelete);
	
	Angajat getAngajatByMarcaAngajat(Integer marcaAngajat);
	Collection<Angajat> getAngajati();
	
	String getMessage();
	
	Collection<Angajat>toCollection();
	Angajat getByMarcaAngajat(Integer marca);
}
