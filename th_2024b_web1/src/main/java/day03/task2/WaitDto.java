package day03.task2;

public class WaitDto {
	private String callnum;
	private int person;
	public WaitDto() {
	}
	public WaitDto(String callnum, int person) {
		super();
		this.callnum = callnum;
		this.person = person;
	}
	@Override
	public String toString() {
		return "WaitDto [callnum=" + callnum + ", person=" + person + "]";
	}
	public String getCallnum() {
		return callnum;
	}
	public void setCallnum(String callnum) {
		this.callnum = callnum;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	
	
}
