/**
 * @Apr 26, 2014
 */
package com.gsli.dr.junit;

import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gsli.dr.common.logger.GslLogger;
import com.gsli.dr.domain.entity.Client;
import com.gsli.dr.domain.entity.DailyReport;
import com.gsli.dr.domain.service.ClientService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ClientTest {
	
	private static final GslLogger gslLogger = GslLogger.getGslLogger(ClientTest.class);
	
	@Autowired
	private ClientService clientService = null;
	

	@Test
	@Transactional
	public void launchJob() throws Exception {
		Client t = new Client();
		t.setId(1001L);
		System.out.println(clientService.getEntityRepository().findByEntity(t).get(0).getId());
	}
		
	
	@Test
	public void jsonSerializationTest() throws Exception {
	     DailyReport m = new DailyReport();
	     m.setDrDate(new Date());

	     ObjectMapper mapper = new ObjectMapper();
	     System.out.println(mapper.writeValueAsString(m));
	}


	/**
	 * @return the userActionManager
	 */
	public ClientService getClientService() {
		return clientService;
	}


	/**
	 * @param userActionManager the userActionManager to set
	 */
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
}
