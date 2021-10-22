package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Drive extends CommandBase{
    public Drive(){

    addRequirements(Robot.driveTrain);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftJoyX = Robot.m_robotContainer.getMechJoyX();
    double leftJoyY = Robot.m_robotContainer.getMechJoyY();

    Robot.driveTrain.setLeftMotors(leftJoyY);
    Robot.driveTrain.setRightMotors(leftJoyY);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      Robot.driveTrain.setLeftMotors(0);
      Robot.driveTrain.setRightMotors(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}