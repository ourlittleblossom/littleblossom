package olbs.be.bean;

public class FeeStructureDetailBean {

	private String className;
	private int tuitionFee;
	private int annualFee;
	private int courseFee;
	private int examinationFee;
	public FeeStructureDetailBean() {
		/**
		 * unimplemented
		 */
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public int getAnnualFee() {
		return annualFee;
	}
	public void setAnnualFee(int annualFee) {
		this.annualFee = annualFee;
	}
	public int getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	public int getExaminationFee() {
		return examinationFee;
	}
	public void setExaminationFee(int examinationFee) {
		this.examinationFee = examinationFee;
	}
}
