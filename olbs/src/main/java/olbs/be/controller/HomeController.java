package olbs.be.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import olbs.be.bean.HomeBean;
import olbs.be.constants.Constants;
import olbs.be.service.HomeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HomeController {
	@Autowired
	private HomeService homeService;
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@GetMapping(value = "/homeDetails", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public HomeBean getFeeDetails() {
		LOGGER.info("Request received for home details");
		HomeBean homeResponse = homeService.getHomeDetails();
		return homeResponse;
		
	}
}
