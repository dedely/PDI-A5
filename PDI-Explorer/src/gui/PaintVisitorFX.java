package gui;


import java.io.FileInputStream;
import java.io.IOException;

import data.entity.Bear;
import data.entity.Chest;
import data.entity.Explorer;
import data.entity.LivingEntity;
import data.entity.Obstacle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import process.visitor.EntityVisitor;

/**
 * 
 * @author lespi
 * 
 * This class paints the entities displayed in the global map of the HUB.
 *
 */
public class PaintVisitorFX implements EntityVisitor<Void> {

	private static double IMG_TILE_SIZE = 25;
	private double scale = 1;

	private GraphicsContext g;
	private Image tiles;

	private Image tree;
	private Image bigTree;
	private Image rock;

	private Image chest;
	private Image bear;

	/**
	 * 
	 * @param gc
	 */
	public PaintVisitorFX(GraphicsContext gc) {
		this.g = gc;
		try {
			FileInputStream input = new FileInputStream("ressources/img/texture.png");
			this.tiles = new Image(input);

			input = new FileInputStream("ressources/img/obstacles/tree.png");
			this.tree = new Image(input);

			input = new FileInputStream("ressources/img/obstacles/bigtree.png");
			this.bigTree = new Image(input);

			input = new FileInputStream("ressources/img/obstacles/rock.png");
			this.rock = new Image(input);

			input = new FileInputStream("ressources/img/obstacles/treasure (1).png");
			this.chest = new Image(input);

			input = new FileInputStream("ressources/img/obstacles/bear.png");
			this.bear = new Image(input);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param entity
	 */
	@Override
	public Void visit(Chest entity) {
		int i = (int) entity.getPosition()[0];
		int j = (int) entity.getPosition()[1];

		g.drawImage(chest, 0, 0, IMG_TILE_SIZE, IMG_TILE_SIZE, j * MapFX.TILE_SIZE, i * MapFX.TILE_SIZE,
				MapFX.TILE_SIZE, MapFX.TILE_SIZE);
		return null;
	}

	/**
	 * 
	 * @param entity
	 */
	@Override
	public Void visit(Obstacle entity) {
		int i = (int) entity.getPosition()[0];
		int j = (int) entity.getPosition()[1];

		
		if (entity.getType().equals("rock:23")) {
			g.drawImage(rock, 0, 0, 2*IMG_TILE_SIZE, 3*IMG_TILE_SIZE, j * MapFX.TILE_SIZE, i * MapFX.TILE_SIZE,
					2*MapFX.TILE_SIZE, 3*MapFX.TILE_SIZE);		
		}
		else if (entity.getType().equals("tree:12")) {
			g.drawImage(tree, 0, 0, IMG_TILE_SIZE, 2*IMG_TILE_SIZE, j * MapFX.TILE_SIZE, i * MapFX.TILE_SIZE,
					MapFX.TILE_SIZE, 2*MapFX.TILE_SIZE);	
		} else {
			g.drawImage(bigTree, 0, 0, 2*IMG_TILE_SIZE, 2*IMG_TILE_SIZE, j * MapFX.TILE_SIZE, i * MapFX.TILE_SIZE,
					2*MapFX.TILE_SIZE, 2*MapFX.TILE_SIZE);	
		}
		return null;
	}

	/**
	 * 
	 * @param entity
	 */
	@Override
	public Void visit(Explorer entity) {
		int r = 2 * entity.getScope();
		double x = entity.getPosition()[1] - r / 2;
		double y = entity.getPosition()[0] - r / 2;
		r *= MapFX.TILE_SIZE;
		x = x * MapFX.TILE_SIZE + MapFX.TILE_SIZE / 2;
		y = y * MapFX.TILE_SIZE + MapFX.TILE_SIZE / 2;
		g.strokeOval(x, y, r, r);
		double i = entity.getPosition()[0];
		double j = entity.getPosition()[1];
		x = 0;
		y = 0;
		g.drawImage(tiles, x, y, IMG_TILE_SIZE, IMG_TILE_SIZE, j * MapFX.TILE_SIZE, i * MapFX.TILE_SIZE,
				MapFX.TILE_SIZE, MapFX.TILE_SIZE);
		paintLifeBar(entity);
		return null;
	}
	
	/**
	 * 
	 * @param entity
	 */
	@Override
	public Void visit(Bear entity) {
		double i = entity.getPosition()[0];
		double j = entity.getPosition()[1];

		g.drawImage(bear, 0, 0, 2*IMG_TILE_SIZE, IMG_TILE_SIZE, j * MapFX.TILE_SIZE, i * MapFX.TILE_SIZE,
				2*MapFX.TILE_SIZE, MapFX.TILE_SIZE);
		paintLifeBar(entity);
		return null;
	}

	/**
	 * 
	 * @param entity
	 */
	private void paintLifeBar(LivingEntity entity) {
		double i = entity.getPosition()[0];
		double j = entity.getPosition()[1];
		int half = (int) (IMG_TILE_SIZE / (2 * scale));
		g.setFill(Color.RED);
		g.fillRect(j * MapFX.TILE_SIZE - half, i * MapFX.TILE_SIZE - half, (MapFX.TILE_SIZE) * 2, 3);
		g.setFill(Color.LIGHTGREEN);
		g.fillRect(j * MapFX.TILE_SIZE - half, i * MapFX.TILE_SIZE - half,
				(int) ((MapFX.TILE_SIZE) * 2 * ((double) entity.getHealth() / entity.getMaxHealth())), 3);
	}

}