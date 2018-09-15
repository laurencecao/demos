package crazy.view;

import crazy.Application;
import crazy.biz.ByeBye;
import crazy.biz.HelloWorld;
import crazy.biz.ServiceBizCommon;
import crazy.rpc.RPCDecorator;

public class BizCommon implements ServiceBizCommon {

	@RPCDecorator
	public ByeBye hi(HelloWorld world) {
		ByeBye ret = new ByeBye();
		ret.setTs(world.getCreated().getTime());
		ret.setMsg(world.getName() + "," + world.getTitle() + "@" + Application.host);
		return ret;
	}

}
