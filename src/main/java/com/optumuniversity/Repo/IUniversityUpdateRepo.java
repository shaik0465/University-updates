package com.optumuniversity.Repo;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

import com.optumuniversity.Domains.UniversityUpdates;



@Repository
public interface IUniversityUpdateRepo extends CosmosRepository<UniversityUpdates, String>{
	
	List<UniversityUpdates> findAll();
}
