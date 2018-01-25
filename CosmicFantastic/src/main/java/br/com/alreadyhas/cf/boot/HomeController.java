package br.com.alreadyhas.cf.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@ResponseBody
	@RequestMapping("/")
	public String home(){
		return "Nothing yet.";
	}

}
