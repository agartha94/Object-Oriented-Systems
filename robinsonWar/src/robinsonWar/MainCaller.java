package robinsonWar;

public class MainCaller {
	public static void main(String[] args)
	{
		System.out.println("Hello from main caller!");
		basicWarGame firstGame = new basicWarGame();
		pointsPileGame secondGame = new pointsPileGame();
		try {
			firstGame.playGame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Base game played. Points Pile GAME next!");
		try{
			secondGame.playGame();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
