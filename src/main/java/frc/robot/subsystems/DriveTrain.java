/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Drive;




public class DriveTrain extends SubsystemBase {
    
    private Talon motorLeft1 = new Talon(1);
    private Talon motorLeft2 = new Talon(2);
    private Talon motorRight1 = new Talon(3);
    private Talon motorRight2 = new Talon(4);
    
    public void setLeftMotors (double speed){
        motorLeft1.set(-speed);
        motorLeft2.set(-speed);
    }
    
    public void setRightMotors (double speed){
        motorRight1.set(speed);
        motorRight2.set(speed);
    }


  public DriveTrain() {

}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}