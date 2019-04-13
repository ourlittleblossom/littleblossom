package olbs.be.bean;

import java.util.List;

public class GalleryDetailsBean extends ResponseBean{

	protected List<EventDetailsBean> eventDetails;

	public List<EventDetailsBean> getEventDetails() {
		return eventDetails;
	}

	public void setEventDetails(List<EventDetailsBean> eventDetails) {
		this.eventDetails = eventDetails;
	}
	
	
}
