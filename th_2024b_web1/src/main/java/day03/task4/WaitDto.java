package day03.task4;

public class WaitDto {
	private String callnum;
	private int person;
	private int num;
	public WaitDto() {
	}
	
	public WaitDto(String callnum, int person, int num) {
		super();
		this.callnum = callnum;
		this.person = person;
		this.num = num;
	}

	
	@Override
	public String toString() {
		return "WaitDto [callnum=" + callnum + ", person=" + person + ", num=" + num + "]";
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
