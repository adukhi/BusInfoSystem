package data.BusLocationService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "comMsgHeader")
public class ComMsgHeader {
    String errMsg;
    String returnCode;
    
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	
	@Override
	public String toString() {
		return "ComMsgHeader [errMsg=" + errMsg + ", returnCode=" + returnCode + "]";
	}
}
