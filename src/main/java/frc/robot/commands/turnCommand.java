/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class turnCommand extends CommandBase {

  /**
   * Creates a new ElevatorUp.
   */
  public turnCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_turn);
  }

  boolean isFinished = false;


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println(Robot.m_turn.getState());
    if(Robot.m_turn.getState() == 1) {
      Robot.m_turn.Turn();
      System.out.println("T-Shirt 1");
    } 
    
    else if(Robot.m_turn.getState() == 2) {
      System.out.println("T-Shirt 2");
      Robot.m_turn.secondTurn();
      }

    else if(Robot.m_turn.getState() == 3) {
      System.out.println("T-Shirt 3");
      Robot.m_turn.thirdTurn();
      }

    else if(Robot.m_turn.getState() == 4) {
      System.out.println("T-Shirt 4");
      Robot.m_turn.fourthTurn();
      }

    else if(Robot.m_turn.getState() == 5) {
      System.out.println("T-Shirt 5");
      Robot.m_turn.fifthTurn();
      }

    else if(Robot.m_turn.getState() == 6) {
      System.out.println("T-Shirt 6");
      Robot.m_turn.sixthTurn();
      }

    else{
      System.out.println("No More Shirts");
    }

}

  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  System.out.println(Robot.m_turn.getState());
	System.out.println(Robot.m_turn.turnTalon.getSelectedSensorPosition(0));


}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_turn.HoldHeight();
    


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}