package com.first.learning;

import java.io.File;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfilesConfigFile;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;

public class CommonUtils {
	public static AmazonKinesis kinesesClient() {
		File configFile = new File(System.getProperty("user.home"), "/ZeroxVM/AWS/credentials");
        AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider(
                new ProfilesConfigFile(configFile), "default");
        
        //ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();  
        //credentialsProvider.getCredentials();
        
      
        AmazonKinesis  kinesis = AmazonKinesisClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion("ap-south-1")
                .build();
		return kinesis;
	}
}
