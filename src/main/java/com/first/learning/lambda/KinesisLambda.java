package com.first.learning.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent.KinesisEventRecord;

public class KinesisLambda implements RequestHandler<KinesisEvent, String>{


	   public String handleRequest(KinesisEvent event, Context context)
	  {
	    for(KinesisEventRecord rec : event.getRecords()) {
	      System.out.println(new String(rec.getKinesis().getData().array()));
	  }
	  return "SUCCESS";
	  }

}
