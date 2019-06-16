package olbs.be.bean;

import java.util.List;

public class GalleryDetailsBean extends ResponseBean{

	protected List<EventDetailsBean> eventDetails;
	
	private boolean discourageDownloads;
	private boolean clickOutsideToClose;

	public List<EventDetailsBean> getEventDetails() {
		return eventDetails;
	}

	public void setEventDetails(List<EventDetailsBean> eventDetails) {
		this.eventDetails = eventDetails;
	}

	public boolean isDiscourageDownloads() {
		return discourageDownloads;
	}

	public void setDiscourageDownloads(boolean discourageDownloads) {
		this.discourageDownloads = discourageDownloads;
	}

	public boolean isClickOutsideToClose() {
		return clickOutsideToClose;
	}

	public void setClickOutsideToClose(boolean clickOutsideToClose) {
		this.clickOutsideToClose = clickOutsideToClose;
	}
	
	
}
