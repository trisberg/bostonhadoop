package com.springdeveloper.demo.batch;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.Assert;

public class PairDataMapper implements LineMapper<Map<String, Object>> {

	private static final Log logger = LogFactory.getLog(PairDataMapper.class);

	public Map<String, Object> mapLine(String line, int lineNum) throws Exception {
		logger.info("Mapping: " + line);
		Assert.notNull(line, "Expecting line not to be null");
		Assert.isTrue(line.length() > 2, "Expecting line to have length greater than 2");
//		String pair = line.substring(1, line.length()-1);
//		String[] tokens = pair.split(",");
		String[] tokens = line.split("\t");
		if (tokens.length != 2) {
			throw new DataIntegrityViolationException("Expecting 2 tokens in input line: " + line);
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("hash_tag", tokens[0]);
		data.put("count", Integer.parseInt(tokens[1]));
		return data;
	}

}
