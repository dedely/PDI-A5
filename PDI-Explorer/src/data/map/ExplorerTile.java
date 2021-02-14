package data.map;

public class ExplorerTile extends Tile {

	private boolean explored;
	private boolean visible;
	private int interest;
	
	public ExplorerTile() {
		super();
		explored = false;
		visible = false;
		interest = 0;
	}
	
	public ExplorerTile(String type, boolean explored, boolean visible, int interest){
		super(type);
		this.explored = explored;
		this.visible = visible;
		this.interest = interest;
	}

	public boolean isExplored() {
		return explored;
	}

	public boolean isVisible() {
		return visible;
	}

	public int getInterest() {
		return interest;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}
	
}
