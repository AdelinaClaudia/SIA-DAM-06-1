package org.app.service.ejb;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.*;
import org.app.patterns.EntityRepositoryBase;
import org.app.service.entities.Angajat;
import org.app.service.entities.Contract;


@Stateless @LocalBean
public class ContracteAngajatDataServiceEJB extends EntityRepositoryBase<Angajat>
implements ContracteAngajatDataService, Serializable {
 private static Logger logger=Logger.getLogger(ContracteAngajatDataServiceEJB.class.getName());
 
 @EJB 
 private AngajatService angajatDataService;

@Override
public Contract createnewContract(Integer nrContract) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Angajat getAngajatbyMarca(Integer marcaA) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getMessage() {
	// TODO Auto-generated method stub
	return null;
}


}
