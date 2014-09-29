package com.springdeveloper.demo.batch.spark;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.Assert;

public class PairDataMapper implements LineMapper<Map<String, Object>> {

	public Map<String, Object> mapLine(String line, int lineNum) throws Exception {
		Assert.notNull(line, "Expecting line not to be null");
		Assert.isTrue(line.length() > 2, "Expecting line to have length greater than 2");
		String pair = line.substring(1, line.length()-1);
		String[] tokens = pair.split(",");
		if (tokens.length != 2) {
			throw new DataIntegrityViolationException("Expecting 2 tokens in input line: " + line);
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("hash_tag", tokens[0]);
		data.put("count", Integer.parseInt(tokens[1]));
		return data;
	}

}
