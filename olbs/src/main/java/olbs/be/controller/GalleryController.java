package olbs.be.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import olbs.be.bean.GalleryDetailsBean;
import olbs.be.constants.Constants;

import olbs.be.service.GalleryDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GalleryController {
	@Autowired
	private GalleryDetailsService galleryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(GalleryController.class);
	@GetMapping(value = "/galleryDetails", consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public GalleryDetailsBean getFeeDetails() {
		LOGGER.info("Request received for gallery details");
		GalleryDetailsBean galleryResponse = galleryService.getGalleryDetails();
		return galleryResponse;
		
	}
}
