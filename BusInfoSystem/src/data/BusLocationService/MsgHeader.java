package data.BusLocationService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "msgHeader")
public class MsgHeader {
	String queryTime;
	String resultCode;
	String resultMessage;
	public String getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	@Override
	public String toString() {
		return "MsgHeader [queryTime=" + queryTime + ", resultCode=" + resultCode + ", resultMessage=" + resultMessage
				+ "]";
	}
}
