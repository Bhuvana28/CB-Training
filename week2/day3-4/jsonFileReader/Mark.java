package jsonFileReader;

public class Mark{
	private Long mark;
	private String subject;

	public Mark(Long mark,String subject){
		this.mark = mark;
		this.subject = subject;
	}

	public Long getMark(){
		return mark;
	}

	public String getSubject(){
		return subject;
	}

	@Override
	public String toString(){
 		return "\nMark = " + mark + "	Subject = " + subject + "\n";
	}
}