package day05;

public class BoardDto {
	private String title;
	private String content;
	private String writer;
	private String pwd;
	private int num;
	private String ddate;
	private int viewnum;
	
	public BoardDto() {}

	public BoardDto(String title, String content, String writer, String pwd, int num, String ddate, int viewnum) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.pwd = pwd;
		this.num = num;
		this.ddate = ddate;
		this.viewnum = viewnum;
	}




	@Override
	public String toString() {
		return "BoardDto [title=" + title + ", content=" + content + ", writer=" + writer + ", pwd=" + pwd + ", num="
				+ num + ", ddate=" + ddate + ", viewnum=" + viewnum + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDdate() {
		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}

	public int getViewnum() {
		return viewnum;
	}

	public void setViewnum(int viewnum) {
		this.viewnum = viewnum;
	}

	


	
}

