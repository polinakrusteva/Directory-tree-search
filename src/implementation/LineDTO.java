package implementation;

public class LineDTO {

	private String id;
	private String line;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LineDTO(String fileName, long row, String line) {
		this.id = String.join("-", fileName, String.valueOf(row));
		this.setLine(line);
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return String.format("%s %s", id, line);
	}
	
}
