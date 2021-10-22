package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Drive extends CommandBase {

  public Drive() {
      addRequirements(Robot.driveTrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.driveTrain.driveWithJoystick(Robot.m_robotContainer.getRightJoyY(), -(Robot.m_robotContainer.getRightJoyX()));
  }

  @Override
  public boolean isFinished() {
    return isTimedOut();
  }

  private boolean isTimedOut() {
    return false;
  }

  protected void end() {
    Robot.driveTrain.driveWithJoystick(0,0);
  }

  protected void interrupted() {
      end();
  }
}
