package main;
/**
 * Tämä luokka tutkii touchsensorin tilaa ja
 * ohjaa moottoreita sen mukaan onko touchsensori
 * painettu alas vai ei
 */

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

import main.Main;
import main.Remotecontroller;
import main.Moottorit;

public class Puskuri extends Thread{
		
		public void saatana(float j, RegulatedMotor moottoriC)
		{
			/**
			 * Tämä metodi saa touchsensorin tilan float j
			 * parametristä ja ohjaa moottori C:tä sen mukaan
			 */
			if (j==1){
				moottoriC.backward();
			}
		}
	}
