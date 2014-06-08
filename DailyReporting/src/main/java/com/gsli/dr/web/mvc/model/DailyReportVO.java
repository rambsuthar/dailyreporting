package com.gsli.dr.web.mvc.model;

import java.io.Serializable;

public class DailyReportVO implements Serializable {

	private static final long serialVersionUID = 4133208654184684510L;
	
	private String id;
	private String date;
	private String ravannaNo;
	private String minesId;
	private String minesName;
	private String vehicleId;
	private String vehicleRegNo;
	private String time;
	private String weight;
	private String royalty;
	private String contractorId;
	private String labourName;
	private String clientId;
	private String clientName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRavannaNo() {
		return ravannaNo;
	}
	public void setRavannaNo(String ravannaNo) {
		this.ravannaNo = ravannaNo;
	}
	public String getMinesName() {
		return minesName;
	}
	public void setMinesName(String minesName) {
		this.minesName = minesName;
	}
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}
	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getRoyalty() {
		return royalty;
	}
	public void setRoyalty(String royalty) {
		this.royalty = royalty;
	}
	public String getLabourName() {
		return labourName;
	}
	public void setLabourName(String labourName) {
		this.labourName = labourName;
	}
	public String getClientName() {
		return clientName;
	}
	public String getMinesId() {
		return minesId;
	}
	public void setMinesId(String minesId) {
		this.minesId = minesId;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getContractorId() {
		return contractorId;
	}
	public void setContractorId(String contractorId) {
		this.contractorId = contractorId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((labourName == null) ? 0 : labourName.hashCode());
		result = prime * result
				+ ((minesName == null) ? 0 : minesName.hashCode());
		result = prime * result
				+ ((ravannaNo == null) ? 0 : ravannaNo.hashCode());
		result = prime * result + ((royalty == null) ? 0 : royalty.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result
				+ ((vehicleRegNo == null) ? 0 : vehicleRegNo.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DailyReportVO other = (DailyReportVO) obj;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (labourName == null) {
			if (other.labourName != null)
				return false;
		} else if (!labourName.equals(other.labourName))
			return false;
		if (minesName == null) {
			if (other.minesName != null)
				return false;
		} else if (!minesName.equals(other.minesName))
			return false;
		if (ravannaNo == null) {
			if (other.ravannaNo != null)
				return false;
		} else if (!ravannaNo.equals(other.ravannaNo))
			return false;
		if (royalty == null) {
			if (other.royalty != null)
				return false;
		} else if (!royalty.equals(other.royalty))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (vehicleRegNo == null) {
			if (other.vehicleRegNo != null)
				return false;
		} else if (!vehicleRegNo.equals(other.vehicleRegNo))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	
	

}
