public interface Combat
{
	public int attack();
	public void receiveDamage(int dmg);
	public boolean dodge();
	public boolean outOfCombat();
	public void idle();
}