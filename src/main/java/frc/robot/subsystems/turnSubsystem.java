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
   * Creates a new Turner. 
   */
  
   TalonSRX turnTalon;

   
   public Encoder turnEncoder;

   public final double HOLD_POWER = 0;
   public final double Turn_POWER = 0.4;
   public final double Stop_POWER = 0;
   public final double Incremental_value = 1000;


  


  public turnSubsystem() {
    turnTalon = new TalonSRX(Constants.talonTurn1);
    turnTalon.setNeutralMode(NeutralMode.Brake);
    turnTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
  
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
    turnTalon.set(ControlMode.Velocity, Incremental_value); 
   }
    


  public void StopTurn() {
    turnTalon.set(ControlMode.Velocity, Stop_POWER);
  }



  public void resetEncoders() {
    turnEncoder.reset();
  }

 


  public void HoldHeight() {
    turnTalon.set(ControlMode.Position, HOLD_POWER);
  }



}