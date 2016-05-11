package main;
/**
 * Remotecontroller lukee infrapunasensorin
 * saamia arvoja ja antaa ne metodilla int arvoina
 */

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

public class Remotecontroller extends Thread {
	
	private EV3IRSensor infrapunaSensori;
	private int komento;
	boolean stop = true;
	
	public Remotecontroller(EV3IRSensor sensori){
		this.infrapunaSensori = sensori;	
	}
	
	public void run(){
		/**
		 * Tämä metodi pyörii kokoajan ja muutta
		 * komento muuttuja infrapunasensorin lukemaksi
		 * arvoksi
		 */
		while(stop){
			int remoteCommand = infrapunaSensori.getRemoteCommand(0);	
			if (remoteCommand != 0){
				this.komento = remoteCommand;
			}
			else{
				this.komento = 0;
				
			}
		}
		infrapunaSensori.close();
	}
	
	public int getCommand() {
		/**
		 * Tällä metodilla saadaan infrapunasensorin
		 * tämän hetkinen lukema arvo palautettua
		 */
		return this.komento;
	}
	
	public void stopRun(){
		/**
		 * Tällä metodilla pysäytetään run metodin
		 * looppi
		 */
		this.stop = false;
	}
}

