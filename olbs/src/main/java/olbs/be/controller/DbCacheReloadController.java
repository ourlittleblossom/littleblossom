package olbs.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import olbs.be.bean.ResponseBean;
import olbs.be.constants.Constants;
import olbs.be.service.DbCacheReloadService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class DbCacheReloadController {
	@Autowired
	private DbCacheReloadService reloadService;
	private static final Logger LOGGER = LoggerFactory.getLogger(DbCacheReloadController.class);
	@PutMapping(value = "/reload/{reloadType}", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseBean getFeeDetails(@PathVariable("reloadType") String reloadType) {
		LOGGER.info("Request received for reload with request type:{}",reloadType);
		ResponseBean rb = new ResponseBean();
		if(reloadService.reloadCache(reloadType)) {
			rb.setRespCode(Constants.ZERO_INT);
			rb.setRespMsg(Constants.SUCCESS);
		}else {
			rb.setRespCode(Constants.MINUS_INT);
			rb.setRespMsg(Constants.FAILURE);
		}
		return rb;
	}
}
