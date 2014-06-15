package com.gsli.dr.web.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsli.dr.common.util.DateUtil;
import com.gsli.dr.common.util.GSLConstants;
import com.gsli.dr.domain.entity.DailyReport;
import com.gsli.dr.domain.service.DailyReportService;
import com.gsli.dr.web.mvc.model.DailyReportVO;

@Controller
public class ReportsController {
	
	@Autowired
	private DailyReportService dailyReportService;
	
	@RequestMapping(value = "/dailyReports.htm", method = {RequestMethod.POST,RequestMethod.GET})

	public String showDialyReports(HttpServletRequest request, ModelMap model) {
		
		List<DailyReport> dailyReportList = dailyReportService.findAllEntities();
		
		List<DailyReportVO> dailyReportVOList=convertEntityToVO( dailyReportList );
		
		model.addAttribute(GSLConstants.DAILY_REPORT_VO_LIST, dailyReportVOList);
		
		return "dailyReport";
	}
	
	
	private List<DailyReportVO> convertEntityToVO(
			List<DailyReport> dailyReportList) {
		List<DailyReportVO> dailyReportVOList = new ArrayList<>();
		
		for (DailyReport dailyReport : dailyReportList) {
			DailyReportVO vo = new DailyReportVO();
			vo.setId(String.valueOf(dailyReport.getId()));
			vo.setDate(DateUtil.convertDateToFmt(dailyReport.getDrDate(),GSLConstants.MM_DD_YYYY));
			vo.setRavannaNo(String.valueOf(dailyReport.getRavannaNum()));
			vo.setVehicleRegNo(dailyReport.getVehicle().getRegNumber());
			vo.setTime("12:45 PM");
			vo.setWeight(String.valueOf(dailyReport.getWeight()));
			vo.setRoyalty(String.valueOf(dailyReport.getRoyaltyAmount()));
			vo.setLabourName(dailyReport.getContractor().getName());
			vo.setClientName(dailyReport.getClient().getFirmName());
			dailyReportVOList.add(vo);
		}
		
		return dailyReportVOList;
	}

	public DailyReportService getDailyReportService() {
		return dailyReportService;
	}

	public void setDailyReportService(DailyReportService dailyReportService) {
		this.dailyReportService = dailyReportService;
	}

}
