/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class Drivetrain extends SubsystemBase {



  private final Talon m_leftMotorFront = new Talon(1);
  private final Talon m_leftMotorRear = new Talon(2);
  private SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftMotorFront, m_leftMotorRear);


  private final Talon m_rightMotorFront = new Talon(3);
  private final Talon m_rightMotorRear = new Talon(4);
  private SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightMotorFront, m_rightMotorRear);



  // Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_left, m_right);


  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_right.setInverted(true);


  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

}