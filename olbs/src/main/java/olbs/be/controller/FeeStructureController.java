package olbs.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import olbs.be.bean.FeeStructureParentBean;
import olbs.be.constants.Constants;
import olbs.be.service.FeeStructureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class FeeStructureController {
	@Autowired
	private FeeStructureService feeService;
	private static final Logger LOGGER = LoggerFactory.getLogger(FeeStructureController.class);
	@GetMapping(value = "/fees", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public FeeStructureParentBean getFeeDetails() {
		LOGGER.info("Request received for fee details");
		return feeService.getFeeDetails();
	}
}
