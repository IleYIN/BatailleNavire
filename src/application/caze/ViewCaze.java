package application.caze;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ViewCaze extends Canvas implements IViewCaze{
	
	private PresentationCaze presCaze;

	private GraphicsContext gc;
	private static int edgeSquare = 25;
	
	public ViewCaze(final PresentationCaze presCaze) {
		super(edgeSquare, edgeSquare);
		this.presCaze = presCaze;
		
		GraphicsContext gc = getGraphicsContext2D();
		drawSquare(gc);
		
		addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
//				presCaze.notifyChosen();				
			}			
		});
	}
	
	public void drawSquare(GraphicsContext gc) {
		gc.beginPath();
		gc.moveTo(0, 0);
		gc.lineTo(edgeSquare, 0);
		gc.lineTo(edgeSquare, edgeSquare);
		gc.lineTo(0, edgeSquare);
		gc.lineTo(0, 0);
		gc.stroke();
	}
	
	public void drawHit(GraphicsContext gc) {
		gc.beginPath();
		gc.moveTo(0, 0);
		gc.lineTo(edgeSquare, edgeSquare);
		gc.stroke();
		
		gc.beginPath();
		gc.moveTo(edgeSquare, 0);
		gc.lineTo(0, edgeSquare);
		gc.stroke();
	}
	
	// Draw 5 different Ships
	public void drawTorpilleur(GraphicsContext gc) {
		gc.setFill(Color.GREEN);	
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawSousMarin(GraphicsContext gc) {
		gc.setFill(Color.GREENYELLOW);	
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawContreTorpilleur(GraphicsContext gc) {
		gc.setFill(Color.PURPLE);	
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawPorteAvion(GraphicsContext gc) {
		gc.setFill(Color.GRAY);	
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawCroisseur(GraphicsContext gc) {
		gc.setFill(Color.YELLOW);	
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void drawInit(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void drawAttaqueEmpty(GraphicsContext gc) {
		gc.setFill(Color.BLUE);	
		drawHit(gc);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void drawBrokenShip(GraphicsContext gc) {
		gc.setFill(Color.ORANGE);	
		drawHit(gc);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void drawDestroyedShip(GraphicsContext gc) {
		gc.setFill(Color.RED);	
		drawHit(gc);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
}