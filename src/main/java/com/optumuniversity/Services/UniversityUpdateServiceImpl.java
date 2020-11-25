package com.optumuniversity.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.optumuniversity.Domains.UniversityUpdates;
import com.optumuniversity.Repo.IUniversityUpdateRepo;


@Service
//@EnableReactiveCosmosRepositories("com.optumuniversity.*")
//@EnableCosmosRepositories("com.optumuniversity.*")

public class UniversityUpdateServiceImpl implements IUniversityUpdateService{
	
	static Logger log=LoggerFactory.getLogger(UniversityUpdateServiceImpl.class);
	@Autowired
	private IUniversityUpdateRepo repo;

	@Override
	public List<UniversityUpdates> find() {
		log.info("find() method is connecting to Azure");
		List<UniversityUpdates> fuu=repo.findAll();
		log.info("Azure cosmosdb returned the list of updates:"+fuu.size());
		
		return fuu;
	}
	
	
	

}
