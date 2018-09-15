package crazy.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.duitang.service.karma.boot.ServerBootstrap;

import crazy.biz.ServiceBizCommon;
import crazy.view.BizCommon;

@Component
public class RPCDeployer {

	@Autowired
	RPCConfig config;

	ServerBootstrap boot;

	@Bean
	Object exporter() throws Exception {
		System.out.println("initialization: server enabled: " + RPCConfig.serverEnabled);
		if (RPCConfig.serverEnabled) {
			boot = new ServerBootstrap();
			boot.addService(ServiceBizCommon.class, new BizCommon());
			boot.startUp(9999);
		}
		return new Object();
	}

}
