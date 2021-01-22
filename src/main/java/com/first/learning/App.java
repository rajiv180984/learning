package com.first.learning;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfilesConfigFile;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;
import com.amazonaws.services.kinesis.model.PutRecordsRequest;
import com.amazonaws.services.kinesis.model.PutRecordsRequestEntry;
import com.amazonaws.services.kinesis.model.PutRecordsResult;
import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	System.out.println("=============== "+System.getenv("AWS_CREDENTIAL_PROFILES_FILE"));
    	
        System.out.println( "Hello World!" );
        
        AmazonKinesis kinesis = CommonUtils.kinesesClient();
        
        try {
        PutRecordsRequest putRecordsRequest  = new PutRecordsRequest();
        putRecordsRequest.setStreamName("KINESIS_ZEROXVM");
        List <PutRecordsRequestEntry> putRecordsRequestEntryList  = new ArrayList<PutRecordsRequestEntry>(); 
        Machine machine = null;
        for (int i = 0; i < 10; i++) {
        	machine = new Machine(i+"", "Champ-Machine-"+i);
        	Gson gson = new Gson();
        	String gsonStr = gson.toJson(machine);
            PutRecordsRequestEntry putRecordsRequestEntry  = new PutRecordsRequestEntry();
            putRecordsRequestEntry.setData(ByteBuffer.wrap(gsonStr.getBytes()));
            putRecordsRequestEntry.setPartitionKey(String.format("partitionKey-%d", i));
            putRecordsRequestEntryList.add(putRecordsRequestEntry);
           /* try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        }

        putRecordsRequest.setRecords(putRecordsRequestEntryList);
        PutRecordsResult putRecordsResult  = kinesis.putRecords(putRecordsRequest);
        
        System.out.println("Put Resul ===============t" + putRecordsResult);
        } catch (Exception e) {
			// TODO: handle exception
        	
        	e.printStackTrace();
		}
    }

	
}
