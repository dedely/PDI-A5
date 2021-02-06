package data.simulation;

import java.util.ArrayList;

import data.entity.*;
import data.map.Map;

/** 
 * Contains all the data needed for a simulation.
 * 
 * This class has to be instanced only once.
 * Consequently, this is a Singleton class.
 * 
 * @author L�o COQUET
 *
 */

public final class Environment {

	//The only instance of Environment
	private static volatile Environment instance = null;
	
	private Map map;
	private ArrayList<LivingEntity> entities;
	private ArrayList<Entity> obstacles;
	private int explorerAmount;
	private int explorerInit;
	private int chestAmount;
	private int foundChest;
	private ArrayList<Item> items;
	
	private Environment() {}
	
	public Map getMap() {
		return map;
	}
	
	public final static Environment getInstance() {
		if(Environment.instance == null )
			synchronized(Environment.class) {
				if(Environment.instance == null)
					Environment.instance = new Environment();
			}
		return Environment.instance;
	}

	public ArrayList<LivingEntity> getEntities(){
		return entities;
	}
	public ArrayList<Entity> getObstacles(){
		return obstacles;
	}
	public int getExplorerAmount() {
		return explorerAmount;
	}
	public int getExplorerInit() {
		return explorerInit;
	}
	public int getChestAmount() {
		return chestAmount;
	}
	public int getFoundChest() {
		return foundChest;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public void setEntities(ArrayList<LivingEntity> entities) {
		this.entities = entities;
	}
	public void setObstacles(ArrayList<Entity> obstacles) {
		this.obstacles = obstacles;
	}
	public void setExplorerAmount(int explorerAmount) {
		this.explorerAmount = explorerAmount;
	}
	public void setExplorerInit(int explorerInit) {
		this.explorerInit = explorerInit;
	}
	public void setChestAmount(int chestAmount) {
		this.chestAmount = chestAmount;
	}
	public void setFoundChest(int foundChest) {
		this.foundChest = foundChest;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public void decrementExplorerAmount() {
		if(explorerAmount > 0)
			explorerAmount --;
	}
	public void incrementFoundChest() {
		if(foundChest < chestAmount)
			foundChest++;
	}
}
