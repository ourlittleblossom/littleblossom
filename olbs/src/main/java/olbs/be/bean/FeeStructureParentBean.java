package olbs.be.bean;

import java.util.List;

public class FeeStructureParentBean extends ResponseBean{
private List<FeeStructureDetailBean> feeData;

public List<FeeStructureDetailBean> getFeeData() {
	return feeData;
}

public void setFeeData(List<FeeStructureDetailBean> feeData) {
	this.feeData = feeData;
}
}
