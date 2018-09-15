package crazy.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import crazy.biz.ServiceBizCommon;

@Component
public class RPCConfig {

	public static boolean clientEnabled = false;
	public static boolean serverEnabled = false;

	@Autowired
	public ServiceBizCommon bizCommon;

}
