package cn.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name){
		String url = "http://provider-user/hello/" + name;
		return this.restTemplate.getForObject(url, String.class);
	}
	
	@RequestMapping("/sidecar/")
	public String home(){
		String url = "http://sidecar/";		//通过Zuul调用Nodejs的服务
		return this.restTemplate.getForObject(url, String.class);
	}
}
