package com.optumuniversity.Services;

import java.util.List;

import com.optumuniversity.Domains.UniversityUpdates;

import reactor.core.publisher.Flux;

public interface IUniversityUpdateService {
	
	List<UniversityUpdates> find();

}
