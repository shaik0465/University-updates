package com.optumuniversity.Domains;


import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "university-collection")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityUpdates {
	
	private String id;
	@PartitionKey
	private String message;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "UniversityUpdates [id=" + id + ", message=" + message + "]";
	}
	
	

}
