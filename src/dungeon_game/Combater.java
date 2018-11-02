package dungeon_game;

public interface Combater
{
	public void attack(Combater combater);
	public int getAttack();
	public void receiveDamage(Combater combater);
	public boolean dodge();
	public boolean outOfCombat();
	public boolean idle();
	public String warCry();
	public int getExp();
	public String toString();
	public void selfHeal();
	public int currentHp();
}