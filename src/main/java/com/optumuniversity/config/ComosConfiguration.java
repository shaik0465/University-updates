package com.optumuniversity.config;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.azure.data.cosmos.ConnectionMode;
import com.azure.data.cosmos.ConnectionPolicy;
import com.azure.data.cosmos.RetryOptions;
import com.microsoft.azure.spring.data.cosmosdb.config.AbstractCosmosConfiguration;
import com.microsoft.azure.spring.data.cosmosdb.config.CosmosDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableCosmosRepositories;

@Configuration 
 @EnableCosmosRepositories(basePackages = "com.optumuniversity.*") 
@EnableConfigurationProperties(CosmosDbProperties.class) 

public class ComosConfiguration extends AbstractCosmosConfiguration {
	 private static final Logger LOGGER = LogManager.getLogger(ComosConfiguration.class);
  @Value("${azure.cosmosdb.uri}") 
 String cosmosDbUri; 
  @Value("${azure.cosmosdb.key}") 
    String cosmosDbKey; 

 
   @Value("${azureconnectionPolicy.requestTimeoutInMillis}") 
    private int requestTimeoutInMillis; 
   @Value("${azureconnectionPolicy.maxPoolSize}") 
    private int maxPoolSize; 
     @Value("${azureconnectionPolicy.idleConnectionTimeoutInMillis}") 
   private int idleConnectionTimeoutInMillis; 
   @Value("${azureconnectionPolicy.maxRetryAttemptsOnThrottledRequests}") 
     private int maxRetryAttemptsOnThrottledRequests; 
     @Value("${azureconnectionPolicy.maxRetryWaitTimeInSeconds}") 
     private int maxRetryWaitTimeInSeconds; 
     @Value("${azureconnectionPolicy.connectionMode}") 
     private String connectionMode; 
    
     @Bean
     @Primary
       public CosmosDBConfig cosmosDbConfig(CosmosDbProperties properties) { 
     
             return CosmosDBConfig.builder(cosmosDbUri,cosmosDbKey, properties.getDatabase()) 
                     .connectionPolicy(getConnectionPolicy()) 
                  .build(); 
     } 
    
      
    protected ConnectionPolicy getConnectionPolicy() { 
            ConnectionPolicy policy = new ConnectionPolicy(); 
    
      
           try { 
    
      
                policy.connectionMode(ConnectionMode.valueOf(connectionMode)); 
                policy.requestTimeoutInMillis(requestTimeoutInMillis); 
                policy.maxPoolSize(maxPoolSize); 
                 policy.idleConnectionTimeoutInMillis(idleConnectionTimeoutInMillis); 
     
      
              RetryOptions retryOptions = new RetryOptions(); 
             retryOptions.maxRetryAttemptsOnThrottledRequests(maxRetryAttemptsOnThrottledRequests); 
                  retryOptions.maxRetryWaitTimeInSeconds(maxRetryWaitTimeInSeconds); 
                policy.retryOptions(retryOptions); 
             } catch (Exception e) { 
                  LOGGER.error("Excepetion occured during configuring the connection policy for CosmosDB:" + e.getMessage()); 
             } 
    
      
             return policy; 
        } 
     
}
