package simulation;


import atm.ATM;
import banking.Card;

public class SimulationProduct {
	private ATM atm;
	private SimOperatorPanel operatorPanel;
	private SimCardReader cardReader;
	private GUI gui;

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public SimOperatorPanel getOperatorPanel() {
		return operatorPanel;
	}

	public void setOperatorPanel(SimOperatorPanel operatorPanel) {
		this.operatorPanel = operatorPanel;
	}

	public SimCardReader getCardReader() {
		return cardReader;
	}

	public void setCardReader(SimCardReader cardReader) {
		this.cardReader = cardReader;
	}

	public GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}

	/**
	* Notify the ATM that the state of the on-off switch has been changed
	* @param on  true if state is now "on", false if it is "off"
	*/
	public void switchChanged(boolean on) {
		cardReader.setVisible(on);
		if (on)
			atm.switchOn();
		else
			atm.switchOff();
	}

	/**
	* Simulate ejecting a card 
	*/
	public void ejectCard() {
		cardReader.animateEjection();
		operatorPanel.setEnabled(true);
	}

	/**
	* Simulate retaining a card
	*/
	public void retainCard() {
		cardReader.animateRetention();
		operatorPanel.setEnabled(true);
	}

	/**
	* Simulate reading of a card
	* @return  Card object representing information on the card if read successfully, null if not read successfully
	*/
	public Card readCard() {
		operatorPanel.setEnabled(false);
		cardReader.animateInsertion();
		return gui.readCard();
	}
}
