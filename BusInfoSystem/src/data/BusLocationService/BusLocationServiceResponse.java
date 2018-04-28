package data.BusLocationService;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "response")
public class BusLocationServiceResponse {
	ComMsgHeader comMsgHeader;
	MsgHeader msgHeader;
	List<BusLocationList> msgBody = new ArrayList<>();
	public ComMsgHeader getComMsgHeader() {
		return comMsgHeader;
	}
	public void setComMsgHeader(ComMsgHeader comMsgHeader) {
		this.comMsgHeader = comMsgHeader;
	}
	public MsgHeader getMsgHeader() {
		return msgHeader;
	}
	public void setMsgHeader(MsgHeader msgHeader) {
		this.msgHeader = msgHeader;
	}
	
	@XmlElementWrapper(name="msgBody")
	@XmlElement(name="busLocationList")
	public List<BusLocationList> getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(List<BusLocationList> msgBody) {
		this.msgBody = msgBody;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("BusLocationServiceResponse [" + "\n");
		strBuf.append("\t" + comMsgHeader.toString() + "\n");
		strBuf.append("\t" + msgHeader.toString() + "\n");
		
		strBuf.append("\tmsgBody [\n");
		for (BusLocationList busLocation : msgBody) {
			strBuf.append("\t\t" + busLocation.toString() + "\n");
		}
		strBuf.append("\t]" + "\n");
				
		strBuf.append("]");
		return strBuf.toString();
	}
	
}
