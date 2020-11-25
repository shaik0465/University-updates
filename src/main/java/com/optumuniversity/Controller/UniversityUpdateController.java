package com.optumuniversity.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.optumuniversity.Domains.UniversityUpdates;
import com.optumuniversity.Services.IUniversityUpdateService;



@CrossOrigin("*")
@RestController
@RequestMapping("/get")
public class UniversityUpdateController {
	
	static Logger log=LoggerFactory.getLogger(UniversityUpdateController.class);
	
	@Autowired
	private IUniversityUpdateService service;
	
	
	@RequestMapping(method = RequestMethod.GET,path = "/updates")
	public List<UniversityUpdates> find(){
		log.info("find() method is invoked on UniversityUpdateController");
		
		List<UniversityUpdates> fuu=service.find();
		
		log.info("service ruturned the university updates:"+fuu.size());
		return fuu;
		
	}

}
