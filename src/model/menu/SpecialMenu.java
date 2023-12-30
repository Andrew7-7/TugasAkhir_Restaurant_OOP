package model.menu;

public class SpecialMenu extends Menu{
	private String Story;

	public SpecialMenu(Integer menuID, Integer price, String name, String availableOn, String story) {
		super(menuID, price, name, availableOn);
		Story = story;
	}

	public String getStory() {
		return Story;
	}

	public void setStory(String story) {
		Story = story;
	}
	
}
