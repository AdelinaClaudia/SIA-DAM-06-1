package org.app.service.ejb;

import java.util.Collection;


import javax.ejb.Remote;


import org.app.service.entities.*;
@Remote
public interface ContractService {
	Contract addContract(Contract contractToAdd);
	//delete
	String removeContract(Contract contractToDelete);
	
	Contract getContractByNumarContract(Integer numarContract);
	Collection<Contract> getContract();
	
	String getMessage();
	
	Collection<Contract>toCollection();
	Contract getByNumarContract(Integer numar);
}
