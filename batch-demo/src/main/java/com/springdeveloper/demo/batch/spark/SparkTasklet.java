package com.springdeveloper.demo.batch.spark;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.spark.deploy.SparkSubmit;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparkTasklet implements Tasklet {

	private String master;

	private String jar;

	private String mainClass;

	private List<String> applicationArguments;

	private static final Log log = LogFactory.getLog(SparkTasklet.class);

	public void setMaster(String master) {
		this.master = master;
	}

	public void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}

	public void setJar(String jar) {
		this.jar = jar;
	}

	public void setApplicationArguments(List<String> applicationArguments) {
		this.applicationArguments = applicationArguments;
	}

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
			throws Exception {

		log.info("Targeting: " + master);
		log.info("Loading Jar: " + jar);
		log.info("Running Class: " + mainClass);
		log.info("With arguments: " + applicationArguments);

		List<String> submit = new ArrayList();
		submit.addAll(Arrays.asList(new String[]{"--class", mainClass, "--master", master, jar}));
		submit.addAll(applicationArguments);
		SparkSubmit.main(submit.toArray(new String[0]));

		log.info("Done!");
		
		return null;
	}

}
