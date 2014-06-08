package com.gsli.dr.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gsli.dr.common.util.DateUtil;
import com.gsli.dr.common.util.GSLConstants;
import com.gsli.dr.domain.entity.Client;
import com.gsli.dr.domain.entity.Contractor;
import com.gsli.dr.domain.entity.DailyReport;
import com.gsli.dr.domain.entity.Vehicle;
import com.gsli.dr.domain.generic.GenericEntityServiceImpl;
import com.gsli.dr.domain.generic.GenericRepository;
import com.gsli.dr.domain.repository.DailyReportRepository;
import com.gsli.dr.web.mvc.model.DailyReportVO;

public class DailyReportServiceImpl extends GenericEntityServiceImpl<DailyReport, Long> implements DailyReportService{
	
	@Autowired
	private DailyReportRepository dailyReportRepository;

	public DailyReportRepository getDailyReportRepository() {
		return dailyReportRepository;
	}

	public void setDailyReportRepository(DailyReportRepository dailyReportRepository) {
		this.dailyReportRepository = dailyReportRepository;
	}

	@Override
	public GenericRepository<DailyReport, Long> getEntityRepository() {
		return getDailyReportRepository();
	}

	@Override
	public boolean validateEntity(DailyReport paramT) {
		return true;
	}
	
	@Transactional
	@Override
	public DailyReport create(DailyReportVO dailyReportVO) {
		DailyReport dr = getEntityFromVO(dailyReportVO);
		dr=getEntityRepository().saveAndFlush(dr);
		return dr;
	}

	private DailyReport getEntityFromVO(DailyReportVO dailyReportVO) {
		DailyReport dr = new DailyReport();
		Client client = new Client();
		Contractor contractor =  new Contractor();
		Vehicle vehicle = new Vehicle();
		client.setId(Long.parseLong(dailyReportVO.getClientId()));
		vehicle.setId(Long.parseLong(dailyReportVO.getVehicleId()));
		contractor.setId(Long.parseLong(dailyReportVO.getContractorId()));
		
		dr.setClient(client);
		dr.setVehicle(vehicle);
		dr.setContractor(contractor);
		dr.setDrDate(DateUtil.getDatefromString(dailyReportVO.getDate(), GSLConstants.MM_DD_YYYY));
		dr.setRavannaNum(Long.parseLong(dailyReportVO.getRavannaNo()));
		dr.setWeight(Long.parseLong(dailyReportVO.getWeight()));
		dr.setRoyaltyAmount(Long.parseLong(dailyReportVO.getRoyalty()));
		
		
		return null;
	}

}
