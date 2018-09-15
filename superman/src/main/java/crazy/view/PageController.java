package crazy.view;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crazy.biz.ByeBye;
import crazy.biz.HelloWorld;
import crazy.biz.ServiceBizCommon;

@RestController
public class PageController {

	@Autowired
	ServiceBizCommon origin;

	@GetMapping("/hello")
	public Map<String, String> hello(@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "title", required = false) String title) {
		if (title == null) {
			title = "WORLD!";
		}
		HelloWorld p = new HelloWorld();
		p.setCreated(new Date());
		p.setName(name);
		p.setTitle(title);
		ByeBye r = origin.hi(p);
		Map<String, String> ret = new HashMap<>();
		ret.put(name, r.getMsg() + "@" + r.getTs());
		return ret;
	}

}
