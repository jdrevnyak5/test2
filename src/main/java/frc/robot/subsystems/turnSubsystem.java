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
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
//import frc.robot.commands.ElevatorTeleOp;

public class turnSubsystem extends SubsystemBase {

  /**
   * Creates a new Turner. https://www.chiefdelphi.com/t/using-encoder-with-talon-srx/145483/7
   */
  
   TalonSRX turnTalon;

   
   public Encoder turnEncoder;
   AnalogInput liftStringPotPin;

   public final double HOLD_POWER = 0;
   public final double UP_POWER = 0.4;
   public final double DOWN_POWER = 0;




  public turnSubsystem() {
    turnTalon = new TalonSRX(Constants.talonTurn1);


  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Turn() {
    turnTalon.set(ControlMode.PercentOutput, UP_POWER);
  }

  public void StopTurn() {
    turnTalon.set(ControlMode.PercentOutput, DOWN_POWER);
  }



  public void resetEncoders() {
    //winchEncoder1.reset();
    //winchEncoder2.reset();
  }

 


  public void HoldHeight() {
    turnTalon.set(ControlMode.PercentOutput, HOLD_POWER);
  }



}