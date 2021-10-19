/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class turnSubsystem extends SubsystemBase {

	private int state = 0;

	/**
	 * Creates a new Turner.
	 * https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/blob/master/Java%20General/PositionClosedLoop/src/main/java/frc/robot/Robot.java
	 */

	public TalonSRX turnTalon;

	public final double HOLD_POWER = 0;

	public final double Turn_POSITION = 344;
	public final double Turn_POSITION2 = 633;
	public final double Turn_POSITION3 = 1222;
	public final double Turn_POSITION4 = 1520;
	public final double Turn_POSITION5 = 1900;
	public final double Turn_POSITION6 = 1150;


	public final double Stop_POWER = 0;

	public double turn_angle = 0;

	StringBuilder _sb = new StringBuilder();
	double targetPositionRotations;

	public turnSubsystem() {
		turnTalon = new TalonSRX(Constants.talonTurn1);
		turnTalon.setNeutralMode(NeutralMode.Brake);

		/* Factory Default all hardware to prevent unexpected behaviour */
		turnTalon.configFactoryDefault();

		/* Config the sensor used for Primary PID and sensor direction */
		turnTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog, Constants.kSlotIdx, Constants.kTimeoutMs);

		/* Ensure sensor is positive when output is positive */
		turnTalon.setSensorPhase(Constants.kSensorPhase);

		/**
		 * Set based on what direction you want forward/positive to be. This does not
		 * affect sensor phase.
		 */
		turnTalon.setInverted(Constants.kMotorInvert);

		/* Config the peak and nominal outputs, 12V means full */
		turnTalon.configNominalOutputForward(0, Constants.kTimeoutMs);
		turnTalon.configNominalOutputReverse(0, Constants.kTimeoutMs);
		turnTalon.configPeakOutputForward(1, Constants.kTimeoutMs);
		turnTalon.configPeakOutputReverse(-1, Constants.kTimeoutMs);

		/**
		 * Config the allowable closed-loop error, Closed-Loop output will be neutral
		 * within this range. See Table in Section 17.2.1 for native units per rotation.
		 */
		turnTalon.configAllowableClosedloopError(0, Constants.kSlotIdx, Constants.kTimeoutMs);

		/* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */
		turnTalon.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
		turnTalon.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
		turnTalon.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
		turnTalon.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}

	public void Turn() {

		turn_angle = ((turnTalon.getSelectedSensorPosition() % 1024) / 1024 * 365);
		turnTalon.set(ControlMode.Position, Turn_POSITION);

		// print sensor position and angle
		System.out.println(turnTalon.getSelectedSensorPosition(0));
		System.out.println(turn_angle);
		state++;

   }
	
   public void secondTurn() {

	turn_angle = ((turnTalon.getSelectedSensorPosition() % 1024) / 1024 * 365);  
	turnTalon.set(ControlMode.Position, Turn_POSITION2);
	state++;


	//print sensor position and angle
	System.out.println(turnTalon.getSelectedSensorPosition(0));
	System.out.println(turn_angle);



}	

	public void thirdTurn() {

		turn_angle = ((turnTalon.getSelectedSensorPosition() % 1024) / 1024 * 365);  
		turnTalon.set(ControlMode.Position, Turn_POSITION3);
		state++;


		//print sensor position and angle
		System.out.println(turnTalon.getSelectedSensorPosition(0));
		System.out.println(turn_angle);

	}


	public void fourthTurn() {

		turn_angle = ((turnTalon.getSelectedSensorPosition() % 1024) / 1024 * 365);  
		turnTalon.set(ControlMode.Position, Turn_POSITION4);
		state++;


		//print sensor position and angle
		System.out.println(turnTalon.getSelectedSensorPosition(0));
		System.out.println(turn_angle);

	}

	public void fifthTurn() {

		turn_angle = ((turnTalon.getSelectedSensorPosition() % 1024) / 1024 * 365);  
		turnTalon.set(ControlMode.Position, Turn_POSITION5);
		state++;


		//print sensor position and angle
		System.out.println(turnTalon.getSelectedSensorPosition(0));
		System.out.println(turn_angle);

	}


	public void sixthTurn() {

		turn_angle = ((turnTalon.getSelectedSensorPosition() % 1024) / 1024 * 365);  
		turnTalon.set(ControlMode.Position, Turn_POSITION6);
		state++;


		//print sensor position and angle
		System.out.println(turnTalon.getSelectedSensorPosition(0));
		System.out.println(turn_angle);

	}







	public void returnToHome() {

		turn_angle = ((turnTalon.getSelectedSensorPosition() % 1024) / 1024 * 365);  
		turnTalon.set(ControlMode.Position, 0);

		//print sensor position and angle
		System.out.println(turnTalon.getSelectedSensorPosition(0));
		System.out.println(turn_angle);
		state = 0;

	}	


  public void StopTurn() {
	turnTalon.set(ControlMode.PercentOutput, 0);
	System.out.println(turnTalon.getSelectedSensorPosition(0));

  }



  public void HoldHeight() {
    turnTalon.set(ControlMode.Position, HOLD_POWER);
  }


  public int getState() {
    return state + 1;
  }


}