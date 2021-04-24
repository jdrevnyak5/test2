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


//import frc.robot.commands.ElevatorTeleOp;

public class turnSubsystem extends SubsystemBase {
  /**
   * Creates a new turn.
   */
  
   TalonSRX turnTalon1;



   public final double HOLD_POWER = 0;
   public final double UP_POWER = 0.;
   public final double DOWN_POWER = 0;


  public turnSubsystem() {
    turnTalon1 = new TalonSRX(Constants.talonTurn1);

    

    //winchEncoder1 = new Encoder(Constants.winch1EncoderPort1, Constants.winch1EncoderPort2);
    //winchEncoder2 = new Encoder(Constants.winch2EncoderPort1, Constants.winch2EncoderPort2);

    //setDefaultCommand(new ElevatorTeleOp());
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void turnG() {
    turnTalon1.set(ControlMode.PercentOutput,UP_POWER);
  }

  public void stopTurn() {
    turnTalon1.set(ControlMode.PercentOutput, DOWN_POWER);
  }



  public void HoldHeight() {
    turnTalon1.set(ControlMode.PercentOutput, HOLD_POWER);
  }




}