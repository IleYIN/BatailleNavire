package application.caze;

import javafx.scene.canvas.GraphicsContext;

public interface IViewCaze {
	public void drawInit(GraphicsContext gc);
	public void drawAttaqueEmpty(GraphicsContext gc);
	public void drawBrokenShip(GraphicsContext gc);
	public void drawDestroyedShip(GraphicsContext gc);
}
