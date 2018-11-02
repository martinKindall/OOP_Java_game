import java.io.*;

public class CharacterFactory
{
    public static String name;
    public static String weapon;
    public static int baseAttack;

    static final String sword = "s";
    static final String axe = "a";
    static final String bow = "b";

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
            case axe:   baseAttack = 2;
                                    break;
            case sword: baseAttack = 1;
                                    break;
            case bow:   baseAttack = 3;
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
    public static Combat create() throws IOException
    {
        setDataCharacter();
        return new Character(baseAttack, name, weapon);
    }
}