package com.first.learning.consumer;

import java.util.List;

import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.model.GetRecordsRequest;
import com.amazonaws.services.kinesis.model.GetRecordsResult;
import com.amazonaws.services.kinesis.model.GetShardIteratorRequest;
import com.amazonaws.services.kinesis.model.GetShardIteratorResult;
import com.amazonaws.services.kinesis.model.Record;
import com.first.learning.CommonUtils;
import com.google.gson.Gson;

public class KinesisConsumer {
  public static void main(String[] args) {
	  String shardIterator;
	  AmazonKinesis client = CommonUtils.kinesesClient();
	  GetShardIteratorRequest getShardIteratorRequest = new GetShardIteratorRequest();
	  getShardIteratorRequest.setStreamName("KINESIS_ZEROXVM");
	  getShardIteratorRequest.setShardId("shardId-000000000000");
	  getShardIteratorRequest.setShardIteratorType("TRIM_HORIZON");

	  GetShardIteratorResult getShardIteratorResult = client.getShardIterator(getShardIteratorRequest);
	  shardIterator = getShardIteratorResult.getShardIterator();
	  
	  GetRecordsRequest getRecordsRequest = new GetRecordsRequest();
	  getRecordsRequest.setShardIterator(shardIterator);
	  getRecordsRequest.setLimit(100);

	  GetRecordsResult getRecordsResult = client.getRecords(getRecordsRequest);
	  List<Record> records = getRecordsResult.getRecords();
	  Gson gson = new Gson();
	  for(Record record : records) {
		  String str=new String(record.getData().array());
		 
		  System.out.println( str);
		  
	  }
}
}
