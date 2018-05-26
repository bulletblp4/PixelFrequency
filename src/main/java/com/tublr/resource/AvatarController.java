package com.tublr.resource;


import java.util.List;
import java.util.Map.Entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tumblr.process.PixelCounter;

@RestController
@EnableAutoConfiguration
public class AvatarController {
 

	    @RequestMapping(value = "avatar/pixel/blogName/{blogName}/count/{count}", method = RequestMethod.GET)
	    @ResponseBody
	    public List<Entry<String, Integer>> getFoosBySimplePathWithPathVariables
	      (@PathVariable String blogName, @PathVariable int count) throws Exception {
	    	
	    	PixelCounter counter = new PixelCounter(blogName, count);
	    	return counter.retreiveAvatarData();
	        
	    }
	    
	    
	    @RequestMapping("/")
	    String home(){
	    	return "hello world!";
	    }
	    
	    public static void main(String[] args) {
	        SpringApplication.run(AvatarController.class, args);
	    }
}
