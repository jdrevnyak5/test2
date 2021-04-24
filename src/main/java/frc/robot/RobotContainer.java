/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.*;
import frc.robot.subsystems.PneumaticsSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.Robot;



import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



import java.text.DecimalFormat;




/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...

    private final SendableChooser<Command> m_chooser = new SendableChooser<>();
    public DecimalFormat decimalScale = new DecimalFormat("#,###.##");



    public final Joystick leftJoy = new Joystick(Constants.leftJoyPort);
    public final Joystick rightJoy = new Joystick(Constants.rightJoyPort);
    public final Joystick mechJoy = new Joystick(Constants.mechJoyPort);

    public JoystickButton leftTrigger = new JoystickButton(leftJoy, 1), leftButton2 = new JoystickButton(leftJoy, 2),
            leftButton3 = new JoystickButton(leftJoy, 3), leftButton4 = new JoystickButton(leftJoy, 4),
            leftButton5 = new JoystickButton(leftJoy, 5), leftButton6 = new JoystickButton(leftJoy, 6),
            leftButton7 = new JoystickButton(leftJoy, 7), leftButton8 = new JoystickButton(leftJoy, 8),
            leftButton9 = new JoystickButton(leftJoy, 9), leftButton10 = new JoystickButton(leftJoy, 10),
            leftButton11 = new JoystickButton(leftJoy, 11), leftButton12 = new JoystickButton(leftJoy, 12);

    public double getLeftJoyX() {
        return leftJoy.getRawAxis(0);
    }

    public double getLeftJoyY() {
        return leftJoy.getRawAxis(1);
    }

    public double getLeftJoyThrottle() {
        return leftJoy.getRawAxis(2);
    }

    public JoystickButton rightTrigger = new JoystickButton(rightJoy, 1),
            rightButton2 = new JoystickButton(rightJoy, 2), rightButton3 = new JoystickButton(rightJoy, 3),
            rightButton4 = new JoystickButton(rightJoy, 4), rightButton5 = new JoystickButton(rightJoy, 5),
            rightButton6 = new JoystickButton(rightJoy, 6), rightButton7 = new JoystickButton(rightJoy, 7),
            rightButton8 = new JoystickButton(rightJoy, 8), rightButton9 = new JoystickButton(rightJoy, 9),
            rightButton10 = new JoystickButton(rightJoy, 10), rightButton11 = new JoystickButton(rightJoy, 11),
            rightButton12 = new JoystickButton(rightJoy, 12);

    public double getRightJoyX() {
        return rightJoy.getRawAxis(0);
    }

    public double getRightJoyY() {
        return rightJoy.getRawAxis(1);
    }

    public double getRightJoyThrottle() {
        return rightJoy.getRawAxis(2);
    }

    public JoystickButton mechTrigger = new JoystickButton(mechJoy, 1), mechButton2 = new JoystickButton(mechJoy, 2),
            mechButton3 = new JoystickButton(mechJoy, 3), mechButton4 = new JoystickButton(mechJoy, 4),
            mechButton5 = new JoystickButton(mechJoy, 5), mechButton6 = new JoystickButton(mechJoy, 6),
            mechButton7 = new JoystickButton(mechJoy, 7), mechButton8 = new JoystickButton(mechJoy, 8),
            mechButton9 = new JoystickButton(mechJoy, 9), mechButton10 = new JoystickButton(mechJoy, 10),
            mechButton11 = new JoystickButton(mechJoy, 11), mechButton12 = new JoystickButton(mechJoy, 12);

    public double getMechJoyX() {
        return mechJoy.getRawAxis(0);
    }

    public double getMechJoyY() {
        return mechJoy.getRawAxis(1);
    }

    public double getMechJoyThrottle() {
        return mechJoy.getRawAxis(2);
    }


    //Pneumatics Subsystems and Commands
    PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();
    PneumaticsExtendPistonCommand pneumaticsExtendPistonCommand = new PneumaticsExtendPistonCommand(pneumaticsSubsystem);
    PneumaticsRetractPistonCommand pneumaticsRetractPistonCommand = new PneumaticsRetractPistonCommand(pneumaticsSubsystem);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();


        SmartDashboard.putData(m_chooser);
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // Example : mechButton3.whenPressed(new IntakeBall());

        // Left Hand


        // Right Hand


        // right stick


        //left stick


        mechButton2.whileHeld(new turnCommand());
        mechButton3.whileHeld(pneumaticsExtendPistonCommand);
        mechButton4.whileHeld(pneumaticsRetractPistonCommand);


    }
}