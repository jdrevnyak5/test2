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



public class shootSubsystem extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  
   VictorSPX shootVictor;


   public final double HOLD_POWER = 0;
   public final double ShootPower = 1;
   public final double StopShoot = 0;


  public shootSubsystem() {
    shootVictor = new VictorSPX(Constants.talonShoot);


 
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



 


  public void HoldHeight() {
    shootVictor.set(ControlMode.PercentOutput, HOLD_POWER);
  }



}