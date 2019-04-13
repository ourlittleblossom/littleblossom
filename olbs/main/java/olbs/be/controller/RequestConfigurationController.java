package olbs.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import olbs.be.constants.Constants;
import olbs.be.service.ConfigurationService;




import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class RequestConfigurationController {
	@Autowired
	private ConfigurationService configService;
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestConfigurationController.class);
	@GetMapping(value = "/requestConfiguration/{requestType}", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<Object> getFeeDetails(@PathVariable("requestType") String requestType) {
		LOGGER.info("Request received for configuration with config type :{}",requestType);
		
		JSONObject config = null;
		JSONParser parser = new JSONParser();
		try {
			 config = (JSONObject) parser.parse(configService.getConfiguration(requestType));
			
		} catch (ParseException e) {
			LOGGER.error("Exception in parsing configuration:{}",e);
		}
		return new ResponseEntity<Object>(config, HttpStatus.OK);
	}
}
