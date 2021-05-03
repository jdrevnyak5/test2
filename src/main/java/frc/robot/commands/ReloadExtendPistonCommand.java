package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ReloadSubsystem;

public class ReloadExtendPistonCommand extends CommandBase {

  //Member variables will be subsystems that the command will be executed on:

  ReloadSubsystem reloadSubsystem;

  //Pass in an instance of all the required subsystems in the constructor.

  //and set them to the member variables.

  public ReloadExtendPistonCommand(ReloadSubsystem pneumatics) {

    // Use addRequirements() here to declare subsystem dependencies.

    reloadSubsystem = pneumatics;
    

    addRequirements(reloadSubsystem);

  }

  // Called when the command is initially scheduled.

  @Override

  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.

  @Override

  public void execute() {

    reloadSubsystem.extendPiston(); //This is the command to execute -- extend the 

    System.out.println("Extending Slider Piston!");

  }

  // Called once the command ends or is interrupted.

  @Override

  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.

  @Override

  public boolean isFinished() {

    return false;

  }

}