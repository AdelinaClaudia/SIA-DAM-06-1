package org.app.service.ejb;
import org.app.service.entities.*;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.app.patterns.EntityRepositoryBase;
@Stateless @LocalBean 
public class ContractServiceEJB extends EntityRepositoryBase<Contract> implements ContractService{
	private static Logger logger = Logger.getLogger(ContractServiceEJB.class.getName());
	@PersistenceContext(unitName="MSD")
	private EntityManager em;
	public ContractServiceEJB() {
		
	}
	@PostConstruct 
	public void init() {
		logger.info("POSTCONSTRUCT-INIT : "+ this.em);
	}
	@Override
	 public Contract addContract(Contract contractToAdd) {
		em.persist(contractToAdd);
		em.flush();
		em.refresh(contractToAdd);
		return contractToAdd;
	}
	@Override
	public Contract getByNumarContract(Integer numarContract){

		return em.find(Contract.class, numarContract);
	}
	public Collection<Contract>getContract(){
		List<Contract> contract=em.createQuery("Select co From Contract co", Contract.class).getResultList();
		return contract;
	}
	//custome read 
	public Contract getContractByNumarContract(Integer numar) {
		return em.createQuery("SELECT co from Contract co Where co.numarContract=:numar", Contract.class).setParameter("numarContract", numar).getSingleResult();
	}
	
	public String removeContract(Contract contractToDelete) {
		contractToDelete=em.merge(contractToDelete);
		em.remove(contractToDelete);
		em.flush();
		return "true";
	}
	
	public String getMessage() {
		return "ContractServiceEJB is on ... ";
	}
	
}
