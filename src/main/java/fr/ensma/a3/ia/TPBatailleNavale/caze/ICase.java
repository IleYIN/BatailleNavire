package fr.ensma.a3.ia.TPBatailleNavale.caze;

public interface ICase extends IEstAttaque {
	public void setPosX(int positionX);
	public void setPosY(int positionY);
	public int getPosX();
	public int getPosY();
}
