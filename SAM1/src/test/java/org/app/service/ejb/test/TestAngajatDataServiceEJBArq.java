package org.app.service.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ejb.EJB;

import org.app.service.ejb.AngajatService;
import org.app.service.ejb.AngajatiServiceEJB;
import org.app.service.entities.Angajat;
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
public class TestAngajatDataServiceEJBArq {
	private static Logger logger= Logger.getLogger(TestAngajatDataServiceEJBArq.class.getName());
	@EJB
	private static AngajatService service ;
	
	@Deployment
	public static Archive<?> createDeployment(){
		return ShrinkWrap.create(WebArchive.class,"SCRUM-S3-test.war")
				.addPackage(Angajat.class.getPackage())
				.addClass(AngajatService.class)
				.addClass(AngajatiServiceEJB.class)
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
	public void test4_getAngajati() {
		logger.info("DEBUG:Junit TESTING: TestGetAngajati...");
		Collection<Angajat> angajati=service.getAngajati();
	
		assertTrue("fail to read angajat!",angajati.size()>0);		
	}
	@Test
	public void test3_addAngajat() {
		logger.info("DEBUG:Junit TESTING: TestAddAngajati...");
		Integer angajatiToAdd=3;
		for(int i=1;i<=angajatiToAdd;i++)
		{
			service.addAngajat(new Angajat(null, "Angajat_"+(100+i)));
		}
		Collection<Angajat> angajati=service.getAngajati();
	
		assertTrue("fail to add angajat!",angajati.size()==angajatiToAdd);		
	}
	
	@Test
	public void test2_DeleteAngajat() {
		logger.info("DEBUG:Junit TESTING: TestDeleteAngajati...");
		Collection<Angajat> angajati=service.getAngajati();
		
		for(Angajat a:angajati)
		service.removeAngajat(a);
		Collection<Angajat> angajatiAfterDelete=service.getAngajati();
		
	
		assertTrue("fail to read angajat!",angajatiAfterDelete.size()==0);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
