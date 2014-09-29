package com.springdeveloper.demo.batch.spark;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.spark.deploy.SparkSubmit;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class SparkTasklet implements Tasklet, InitializingBean {

	private String master;

	private String dataPath;
	
	private String outputDir;
	
	private String mainClass;
	
	private String jar;

	private static final Log log = LogFactory.getLog(SparkTasklet.class);

	public void setMaster(String master) {
		this.master = master;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}

	public void setJar(String jar) {
		this.jar = jar;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.state(dataPath != null , "The data path must be provided");
	}

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext)
			throws Exception {

		log.info("Targeting: " + master);
		log.info("Loading Jar: " + jar);
		log.info("Running Class: " + mainClass);

		SparkSubmit.main(new String[] {"--class", mainClass, "--master", master, jar, dataPath, outputDir});

		log.info("Done!");
		
		return null;
	}

}
