package application.placementscene;

public class ModelPlacementScene {
	
	private int player; // 0, 1, 2, 3 means Sleeping, Player1, Player2, Passed
	
	public ModelPlacementScene() {
		player = 1;
	}
	
	public void setPlayer(int playernumber) {
		player = playernumber;
	}

	public int getPlayer() {
		return player;
	}
}
