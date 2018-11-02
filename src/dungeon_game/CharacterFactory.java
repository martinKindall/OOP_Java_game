package dungeon_game;
import java.io.*;

public class CharacterFactory
{
    private static String name;
    private static String weapon;
    private static Weapon weap;

    private static final String sword = "s";
    private static final String axe = "a";
    private static final String bow = "b";

    /**
     * [getDataCharacter: None -> None]
     *
     * effect: the global variables baseAttack, name and weapon 
     * are assigned with the user input
     * 
     * @throws IOException [description]
     */
    public static void setDataCharacter() throws IOException
    {
        final String[] validWeapons = {sword, axe, bow};
        boolean isvalid = false;

        name = Utils.readLine("Name? ");

        while(!isvalid)
        {
            weapon = Utils.readLine("Weapon [s:sword, b:bow, a:axe]? ");

            for (int idx=0; idx<validWeapons.length; ++idx) 
            {
                if (validWeapons[idx].equals(weapon))
                {
                    isvalid = true;
                    break;
                } 
            }
            if (!isvalid) Utils.println("Not a valid weapon!");
        }

        switch (weapon)
        {
            case axe:   weap = new Axe();
                                    break;
            case sword: weap = new Sword();
                                    break;
            case bow:   weap = new Bow();
                                    break;

            default:                break;
        }
    }

    /**
     * [create: None -> Combat]
     *
     * returns a Character based on the user input
     * 
     * @return [description]
     * @throws IOException   [description]
     */
    public static Combater create() throws IOException
    {
        setDataCharacter();
        return new Player(name, weap);
    }
}