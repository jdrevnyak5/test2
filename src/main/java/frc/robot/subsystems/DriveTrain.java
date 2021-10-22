/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;




public class DriveTrain extends SubsystemBase {

  private final DifferentialDrive robotDrive = Robot.m_drive;

  
  public void driveWithJoystick(double m_left, double m_right) {
      robotDrive.arcadeDrive(m_left, m_right);
  }
}

