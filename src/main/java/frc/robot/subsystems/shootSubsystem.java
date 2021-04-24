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
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
//import frc.robot.commands.ElevatorTeleOp;

public class shootSubsystem extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  
   VictorSPX shootVictor;

   
   public Encoder winchEncoder1;
   public Encoder winchEncoder2;
   AnalogInput liftStringPotPin;

   public final double HOLD_POWER = 0;
   public final double ShootPower = 1;
   public final double StopShoot = 0;


  public shootSubsystem() {
    shootVictor = new VictorSPX(Constants.talonShoot);


    //winchEncoder1 = new Encoder(Constants.winch1EncoderPort1, Constants.winch1EncoderPort2);
    //winchEncoder2 = new Encoder(Constants.winch2EncoderPort1, Constants.winch2EncoderPort2);

    //setDefaultCommand(new ElevatorTeleOp());
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Shoot() {
    shootVictor.set(ControlMode.PercentOutput, ShootPower);
  }

  public void StopShoot() {
    shootVictor.set(ControlMode.PercentOutput, StopShoot);
  }



  public void resetEncoders() {
    //winchEncoder1.reset();
    //winchEncoder2.reset();
  }

 


  public void HoldHeight() {
    shootVictor.set(ControlMode.PercentOutput, HOLD_POWER);
  }



}