package org.app.service.ejb.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ejb.EJB;

import org.app.patterns.EntityRepository;

import org.app.service.ejb.ClientService;
import org.app.service.ejb.ClientServiceEJB;

import org.app.service.entities.Client;
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

public class TestClientDataServiceEJBArq {
	private static Logger logger= Logger.getLogger(TestClientDataServiceEJBArq.class.getName());
	@EJB
	private static ClientService service ;
	
/*	@Deployment
	public static Archive<?> createDeployment(){
		return ShrinkWrap.create(WebArchive.class,"SCRUM-SAM6-test.war")
				.addPackage(Client.class.getPackage())
				.addClass(ClientService.class)
				.addClass(ClientServiceEJB.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
				
	}*/
	 @Deployment

     public static Archive<?> createDeployment(){

            return ShrinkWrap.create(WebArchive.class,"msd-test.war")



                         .addPackage(Client.class.getPackage())

                         .addPackage(EntityRepository.class.getPackage())

                         .addPackage(ClientService.class.getPackage())

                         .addPackage(ClientServiceEJB.class.getPackage())

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
	public void test4_getClient() {
		logger.info("DEBUG:Junit TESTING: TestGetClient...");
		Collection<Client> client=service.getClient();
	
		assertTrue("fail to read angajat!",client.size()>0);		
	}
	@Test
	public void test3_addClient() {
		logger.info("DEBUG:Junit TESTING: TestAddClient...");
		Integer clientToAdd=3;
		for(int i=1;i<=clientToAdd;i++)
		{
			service.addClient(new Client(null, "Client_"+(100+i)));
		}
		Collection<Client> client=service.getClient();
	
		assertTrue("fail to add client!",client.size()==clientToAdd);		
	}
	
	@Test
	public void test2_DeleteClient() {
		logger.info("DEBUG:Junit TESTING: TestDeleteClient...");
		Collection<Client> client=service.getClient();
		
		for(Client a:client)
		service.removeClient(a);
		Collection<Client> clientAfterDelete=service.getClient();
		
	
		assertTrue("fail to read client!",clientAfterDelete.size()==0);		
	}
	
	
	
	
}
