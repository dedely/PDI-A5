package data.entity;

/**
 * Class of all breakable entities. Can be animals, explorer, or breakable obstacles such as trees. 
 *
 */
public abstract class BreakableEntity extends Entity {

	private int health;
	private int maxHealth;

	/**
	 * Constructor.
	 * 
	 * @param type
	 * @param position
	 * @param size
	 * @param maxHealth
	 */
	public BreakableEntity(String type, double[] position, double[] size, int maxHealth) {
		super(type, position, size);
		this.maxHealth = maxHealth;
		this.health = maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

}