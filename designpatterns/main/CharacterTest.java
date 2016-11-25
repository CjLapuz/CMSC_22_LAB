package main;

public class CharacterTest {

	public static void main(String[] args) {
		Character queen = new Queen("Richard");
		Character king = new King("Diana");
		Character troll = new Troll("Gabriel");
		Character knight = new Knight("Khan");
		
		queen.fight();
		System.out.println("");
		king.fight();
		System.out.println("");
		troll.fight();
		System.out.println("");
		knight.fight();
	}

}
