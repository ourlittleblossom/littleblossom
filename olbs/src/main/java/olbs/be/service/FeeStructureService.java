package olbs.be.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import olbs.be.bean.FeeStructureDetailBean;
import olbs.be.bean.FeeStructureParentBean;
import olbs.be.constants.Constants;
import olbs.be.model.entities.FeeStructure;
import olbs.be.model.repositories.FeeStructureRepository;

@Service
public class FeeStructureService {
@Autowired
private FeeStructureRepository feeRepository;
	public FeeStructureParentBean getFeeDetails() {
		FeeStructureParentBean feeData = new FeeStructureParentBean();
		Iterator<FeeStructure> feeDetailDbList = feeRepository.findAll().iterator();
		List<FeeStructureDetailBean> feeDetailList = new ArrayList<>();
		feeData.setRespCode(Constants.MINUS_ONE_INT);
		feeData.setRespMsg(Constants.FAILURE);
		int i=0;
		while(feeDetailDbList.hasNext()) {
			feeData.setRespCode(Constants.ZERO_INT);
			feeData.setRespMsg(Constants.SUCCESS);
			FeeStructure feeDetailDb = feeDetailDbList.next();
			FeeStructureDetailBean feeDetail = new FeeStructureDetailBean();
			feeDetail.setClassName(feeDetailDb.getStandard());
			feeDetail.setAnnualFee(feeDetailDb.getAnnualFee());
			feeDetail.setCourseFee(feeDetailDb.getCourseFee());
			feeDetail.setTuitionFee(feeDetailDb.getTuitionFee());
			feeDetail.setExaminationFee(feeDetailDb.getExaminationFee());
			feeDetailList.add(i++, feeDetail);
		}
		feeData.setFeeData(feeDetailList);
		return feeData;
	}
	
}
