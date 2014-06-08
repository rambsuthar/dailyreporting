package com.gsli.dr.junit;

import org.codehaus.jackson.map.ObjectMapper;

import com.gsli.dr.common.util.DateUtil;
import com.gsli.dr.common.util.GSLConstants;
import com.gsli.dr.web.mvc.model.DailyReportVO;

public class JSONTest {

	public static void main(String[] args) {
		try {
			DateUtil.getDatefromString("06/08/2014", GSLConstants.MM_DD_YYYY);
		    ObjectMapper mapper=new ObjectMapper();
		    //serialize
		    String json="{\"id\":1,\"date\":1,\"ravannaNo\":1,\"minesId\":1}";
		    //deserialize
		    DailyReportVO login2 = mapper.readValue(json, DailyReportVO.class);
		} catch (Exception e) {
		    e.printStackTrace();
		}


	}

}
