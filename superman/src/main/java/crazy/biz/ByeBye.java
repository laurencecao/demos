package crazy.biz;

import java.io.Serializable;

/**
 * moved from view and implements serializable
 * 
 * @author Laurence Cao
 * @date 2018年9月12日
 *
 */
public class ByeBye implements Serializable {

	private static final long serialVersionUID = 1L;

	protected long ts;
	protected String msg;

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
