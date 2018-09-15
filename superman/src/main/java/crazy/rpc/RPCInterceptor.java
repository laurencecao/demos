package crazy.rpc;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duitang.service.karma.client.KarmaClient;

@Aspect
@Component
public class RPCInterceptor {

	@Autowired
	RPCConfig config;

	@Around("@annotation(crazy.rpc.RPCDecorator)")
	public Object rpcBridge(ProceedingJoinPoint jp) throws Throwable {
		if (!config.clientEnabled) {
			return jp.proceed();
		}
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Object obj = jp.getTarget();
		Method method = signature.getMethod();
		Class api = signature.getDeclaringType();
		KarmaClient cli = KarmaClient.createKarmaClient(api, Arrays.asList("localhost:9999"));
		Object[] args = jp.getArgs();
		return cli.invoke(obj, method, args);
	}

}
