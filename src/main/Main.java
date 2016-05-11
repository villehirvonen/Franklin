package main;
/**
 * Main luokka jossa robotin toiminta pyörii
 * Luokka aloittaa muitten luokkien toiminnat,
 * luo moottorit ja sensori ja kutsuu muiden luokkien
 * metodeja niitten käyttämiseen.
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

public class Main {

	public static void main(String[] args) {
		RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B); //kääntyvä pikkuetumoottori B
		RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C); //takamoottori C
		EV3IRSensor sensor = new EV3IRSensor(SensorPort.S4);
		Remotecontroller rc = new Remotecontroller(sensor);
		Moottorit motors = new Moottorit();
		Puskuri p = new Puskuri();
		
		EV3TouchSensor touch = new  EV3TouchSensor(SensorPort.S1);
		float[] sample = new float[touch.sampleSize()]; 
		RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
		
		rc.start();
		motors.start();
		p.start();
		
		int k = 0;
		
		motors.setSpeed(motorB, 150);
		motors.setSpeed(motorC, 3000);
		motors.setSpeed(motorA, 7000);
		
		
		while(k != 8)
		{
			k = 0;
			k = rc.getCommand();
			touch.fetchSample(sample, 0);
			if (!(k==5)){
				p.saatana(sample[0], motorC);
			}
			motors.jeesus(k, motorB, motorC, motorA);
			if ((k==0)&&(sample[0]==0)){
				motors.stopMotor(motorA);
				motors.stopMotor(motorB);
				motors.stopMotor(motorC);
			}
			LCD.drawString("k on :" + k, 0, 0);	
			LCD.drawString("j on :" + sample[0], 0, 1);		
		}
		
		motors.closeMotor(motorA);
		motors.closeMotor(motorB);
		motors.closeMotor(motorC);
	}	
}
