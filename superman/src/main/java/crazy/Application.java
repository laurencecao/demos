package crazy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import crazy.biz.ServiceBizCommon;
import crazy.rpc.RPCConfig;
import crazy.view.BizCommon;

@SpringBootApplication
public class Application {

	public static String host = "default";

	public static void main(String[] args) {
		String rpcserver = System.getProperties().getProperty("rpcserver");
		String rpcclient = System.getProperties().getProperty("rpcclient");
		String host = System.getProperties().getProperty("host");

		if (rpcserver != null) {
			RPCConfig.serverEnabled = true;
		}
		if (rpcclient != null) {
			RPCConfig.clientEnabled = true;
		}
		if (host != null) {
			Application.host = host;
		}

		SpringApplication.run(Application.class, args);
	}

	@Bean(name = "origin")
	public ServiceBizCommon bizCommon() {
		BizCommon ret = new crazy.view.BizCommon();
		return ret;
	}

}
