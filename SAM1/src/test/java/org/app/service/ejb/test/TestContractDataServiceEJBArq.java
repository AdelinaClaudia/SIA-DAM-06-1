package org.app.service.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ejb.EJB;

import org.app.service.ejb.AngajatService;
import org.app.service.ejb.AngajatiServiceEJB;
import org.app.service.ejb.ContractService;
import org.app.service.ejb.ContractServiceEJB;
import org.app.service.entities.Client;
import org.app.service.entities.Contract;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestContractDataServiceEJBArq {
	private static Logger logger= Logger.getLogger(TestContractDataServiceEJBArq.class.getName());
	@EJB
	private static ContractService service ;
	
	@Deployment
	public static Archive<?> createDeployment(){
		return ShrinkWrap.create(WebArchive.class,"SCRUM-S3-test.war")
				.addPackage(Contract.class.getPackage())
				.addClass(ContractService.class)
				.addClass(ContractServiceEJB.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
				
	}
	
	@Test
	public void test1_getMessage() {
		logger.info("DEBUG:Junit TESTING: getMessage ...");
		String response=service.getMessage();
		assertNotNull("Data Service failed!",response);
		logger.info("DEBUG EJB Response ..."+response);
		
	}
	
	@Test
	public void test4_getContract() {
		logger.info("DEBUG:Junit TESTING: TestGetContract...");
		Collection<Contract> contracte=service.getContract();
	
		assertTrue("fail to read angajat!",contracte.size()>0);		
	}
	@Test
	public void test3_addContract() {
		logger.info("DEBUG:Junit TESTING: TestAddContract...");
		Integer contractToAdd=3;
		for(int i=1;i<=contractToAdd;i++)
		{
			service.addContract(new Contract(null, "Contract_"+(100+i), null));

		}
		Collection<Contract> contract=service.getContract();
	
		assertTrue("fail to add contract!",contract.size()==contractToAdd);		
	}
	
	@Test
	public void test2_DeleteContract() {
		logger.info("DEBUG:Junit TESTING: TestDeleteContract...");
		Collection<Contract> contract=service.getContract();
		
		for(Contract c:contract)
		service.removeContract(c);
		Collection<Contract> contractAfterDelete=service.getContract();
		
	
		assertTrue("fail to read contract!",contractAfterDelete.size()==0);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}