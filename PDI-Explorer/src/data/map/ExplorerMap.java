package data.map;

public class ExplorerMap {

	private ExplorerTile[][] tiles = new ExplorerTile[90][90];
	
	public ExplorerMap(ExplorerTile[][] tiles) {
		this.tiles = tiles;
	}

	public ExplorerTile[][] getTiles() {
		return tiles;
	}

	public void setTiles(ExplorerTile[][] tiles) {
		this.tiles = tiles;
	}
	
}
