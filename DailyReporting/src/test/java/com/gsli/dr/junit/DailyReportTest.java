/**
 * @Apr 26, 2014
 */
package com.gsli.dr.junit;

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
import com.gsli.dr.domain.service.DailyReportService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DailyReportTest {
	
	private static final GslLogger gslLogger = GslLogger.getGslLogger(DailyReportTest.class);
	
	@Autowired
	private ClientService clientService = null;
	@Autowired
	private DailyReportService dailyReportService = null;
	

	@Test
	@Transactional
	public void launchJob() throws Exception {
		DailyReport t = new DailyReport();
		t.setId(1001L);
		System.out.println(dailyReportService.getEntityRepository().findByEntity(t).get(0).getId());
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
