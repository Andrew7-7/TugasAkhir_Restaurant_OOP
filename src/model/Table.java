package model;

public class Table {
	private String type;
	private Integer MaximumLoad;
	public Table(String type) {
		super();
		this.type = type;
		if(type.toLowerCase().equals("romantic")) {
			this.MaximumLoad = 2;
		}else if(type.toLowerCase().equals("general")) {
			this.MaximumLoad = 4;
		}else if(type.toLowerCase().equals("family")) {
			this.MaximumLoad = 10;
		}else {
			this.MaximumLoad = 0;
		}
	}
	
}
