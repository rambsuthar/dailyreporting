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
import com.gsli.dr.common.util.DateUtil;
import com.gsli.dr.common.util.GSLConstants;
import com.gsli.dr.domain.entity.Client;
import com.gsli.dr.domain.entity.Contractor;
import com.gsli.dr.domain.entity.DailyReport;
import com.gsli.dr.domain.entity.Vehicle;
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
		
	@Test
	@Transactional
	public void insertJob() throws Exception {
	DailyReport dr = new DailyReport();
	Client client = new Client();
	Contractor contractor =  new Contractor();
	Vehicle vehicle = new Vehicle();
	client.setId(1001L);
	vehicle.setId(1001L);
	contractor.setId(1001L);
	dr.setId(1100L);
	dr.setClient(client);
	dr.setVehicle(vehicle);
	dr.setContractor(contractor);
	dr.setDrDate(DateUtil.getDatefromString("06/08/2014", GSLConstants.MM_DD_YYYY));
	dr.setRavannaNum(Long.parseLong("12345"));
	dr.setWeight(Long.parseLong("12345"));
	dr.setRoyaltyAmount(Long.parseLong("12345"));
	dr.setCreatedBy("Ram Bhagat,Suthar");
	dr.setUpdatedBy("Ram Bhagat,Suthar");
	
	try{
		dailyReportService.saveEntity(dr);
	}catch(Exception e){
		e.printStackTrace();
	}
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
