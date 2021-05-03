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

import edu.wpi.first.wpilibj.Encoder;

public class turnSubsystem extends SubsystemBase {

  /**
   * Creates a new Turner. https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/blob/master/Java%20General/PositionClosedLoop/src/main/java/frc/robot/Robot.java
   */
  
   TalonSRX turnTalon;

   
   public Encoder turnEncoder;

   public final double HOLD_POWER = 0;
   public final double Turn_POWER = 0.4;
   public final double Stop_POWER = 0;
   public final double Incremental_value = 1;

   StringBuilder _sb = new StringBuilder();
   double targetPositionRotations;



  


  public turnSubsystem() {
    turnTalon = new TalonSRX(Constants.talonTurn1);
    turnTalon.setNeutralMode(NeutralMode.Coast);
  
		/* Factory Default all hardware to prevent unexpected behaviour */
		turnTalon.configFactoryDefault();
		
		/* Config the sensor used for Primary PID and sensor direction */
        turnTalon.configSelectedFeedbackSensor(FeedbackDevice.Analog,
                                            Constants.kPIDLoopIdx,
				                            Constants.kTimeoutMs);

		/* Ensure sensor is positive when output is positive */
		turnTalon.setSensorPhase(Constants.kSensorPhase);

		/**
		 * Set based on what direction you want forward/positive to be.
		 * This does not affect sensor phase. 
		 */ 
		turnTalon.setInverted(Constants.kMotorInvert);

		/* Config the peak and nominal outputs, 12V means full */
		turnTalon.configNominalOutputForward(0, Constants.kTimeoutMs);
		turnTalon.configNominalOutputReverse(0, Constants.kTimeoutMs);
		turnTalon.configPeakOutputForward(1, Constants.kTimeoutMs);
		turnTalon.configPeakOutputReverse(-1, Constants.kTimeoutMs);

		/**
		 * Config the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		turnTalon.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

		/* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */
		turnTalon.config_kF(Constants.kPIDLoopIdx, Constants.kGains.kF, Constants.kTimeoutMs);
		turnTalon.config_kP(Constants.kPIDLoopIdx, Constants.kGains.kP, Constants.kTimeoutMs);
		turnTalon.config_kI(Constants.kPIDLoopIdx, Constants.kGains.kI, Constants.kTimeoutMs);
		turnTalon.config_kD(Constants.kPIDLoopIdx, Constants.kGains.kD, Constants.kTimeoutMs);

  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Turn() {
    turnTalon.set(ControlMode.Position, Turn_POWER);

   }
    


  public void StopTurn() {
    turnTalon.set(ControlMode.PercentOutput, 0);
  }



  public void resetEncoders() {
    turnEncoder.reset();
  }

 


  public void HoldHeight() {
    turnTalon.set(ControlMode.Position, HOLD_POWER);
  }



}