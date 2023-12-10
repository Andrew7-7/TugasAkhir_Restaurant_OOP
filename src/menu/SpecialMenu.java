package menu;

public class SpecialMenu extends Menu{
	private String story;
	public SpecialMenu(Integer id,Integer price, String name,String story) {
		super(id,price,name);
		this.story = story;
	}

	public synchronized String getStory() {
		return story;
	}
	public synchronized void setStory(String story) {
		this.story = story;
	}
}
