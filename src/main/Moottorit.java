package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;


public class Moottorit extends Thread {

		public void setSpeed(RegulatedMotor motorx, int nopeus){
			/**
			 * Tällä metodilla muutetaan valitun
			 * moottorin pyörimisnopeutta
			 */
			motorx.setSpeed(nopeus);
		}

		public void closeMotor(RegulatedMotor x){
			/**
			 * Tällä metodilla terminoidaan
			 * valitun moottorin toiminta
			 */
			x.close();
		}
		public void stopMotor(RegulatedMotor x){
			/**
			 * Tällä metodilla pysäytetään
			 * valitun moottorin pyöriminen
			 */
			x.stop();
		}

		
		public void jeesus(int komento, RegulatedMotor moottoriB, RegulatedMotor moottoriC, RegulatedMotor moottoriA)
		{
			/**
			 * Tähän metodiin on ohjelmoitu se mitä mikäkin
			 * infrapunasensorin antama syöte tekee.
			 * Metodi käynnistää ja sammuttaa moottoreita sen
			 * mukaan mitä komento numeroa sille syötetään
			 */
			/*
			 * ub (3) forward 
			 * db (4) backward
			 * ur (1) turn left
			 * dr (2) turn right
			 * db + dr stop
			 * ub + ur forward
			 */
			if(komento==1)
			{ 
				moottoriB.backward();
				//ur
				//turn left
			}
			else if(komento==3)
			{ 
				//ub
				//turn right
				moottoriB.forward();
			}
			else if(komento==2)
			{ 
				//dr
				//pakki
				moottoriC.forward();
				moottoriB.stop();
			}
			else if(komento==4)
			{ 
				//db
				//kaasu
				moottoriC.backward();
				moottoriB.stop();	
			}
			else if(komento==5)
			{
				moottoriA.forward();
				moottoriB.stop();
			}

			else if(komento==6)
			{
				moottoriB.backward();
				moottoriC.backward();
			}
			else if(komento==11){
				moottoriB.forward();
				moottoriC.backward();
			}
			else if(komento==10)
			{
				moottoriB.backward();
				moottoriC.forward();
			}
			else if(komento==7)
			{
				moottoriB.forward();
				moottoriC.forward();
			}
	}	
}
