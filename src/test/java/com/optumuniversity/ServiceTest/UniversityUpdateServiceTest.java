package com.optumuniversity.ServiceTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.optumuniversity.Controller.UniversityUpdateController;
import com.optumuniversity.Domains.UniversityUpdates;
import com.optumuniversity.Services.IUniversityUpdateService;



@RunWith(MockitoJUnitRunner.class)
public class UniversityUpdateServiceTest {
	
	@Mock
	private IUniversityUpdateService service;
	
	@InjectMocks
	private UniversityUpdateController controller;
	
	
	@Test
	public void testUniversityUpdates() {
		
		when(service.find()).thenReturn(processuniversityUpdateResponse());
		
		List<UniversityUpdates> universityUpdates= controller.find();
		
		assertNotNull(universityUpdates);
		assertEquals(3, universityUpdates.size());
		
	}
	
	private List<UniversityUpdates> processuniversityUpdateResponse(){
		List<UniversityUpdates> updates= new ArrayList<UniversityUpdates>();
		List<UniversityUpdates> update= new ArrayList<UniversityUpdates>();
		
		UniversityUpdates uu1= new UniversityUpdates();
		UniversityUpdates uu2= new UniversityUpdates();
		UniversityUpdates uu3= new UniversityUpdates();
		uu1.setId("1");
		uu1.setMessage("message1");
		uu2.setId("2");
		uu2.setMessage("message2");
		uu3.setId("3");
		uu3.setMessage("message3");
		
		update.add(uu1);
		update.add(uu2);
		update.add(uu3);
		
		updates.addAll(update);
		
		return updates;
		
	}
}
