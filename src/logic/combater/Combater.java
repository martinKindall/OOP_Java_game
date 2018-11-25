package logic.combater;

import java.util.Observer;

public interface Combater
{
	void attack(Combater combater);
	int getAttack();
	void receiveDamage(Combater combater);
	boolean dodge();
	boolean outOfCombat();
	boolean idle();
	String warCry();
	int getExp();
	String toString();
	void selfHeal();
	int currentHp();

	void subscribe(Observer observer);

	void increaseExp(int exp);
}