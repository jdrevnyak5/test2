/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
      //Drivetrain
    //   public static final int frontLeftDrivePort = 2;  This stuff is the actual competition ports
    //   public static final int frontRightDrivePort = 1; 
    //   public static final int backLeftDrivePort = 3; 
    //   public static final int backRightDrivePort = 0; 
    //public static final int frontLeftDrivePort = 0;  //talon; this stuff is for when I (Prithvi) tested the code on Demobot
    //public static final int frontRightDrivePort = 1; //talon
    // public static final int backLeftDrivePort = 2;   //victor
    //public static final int backRightDrivePort = 3;  //victor


      //compressors

  

      //Climber
  public static final int compressor = 0;
  public static final int talonTurn1 = 1; //Motor that turns cannon
  public static final int talonShoot = 6; //Controller that activates the shot
  



      //Joysticks
  public static final int leftJoyPort = 2;
  public static final int rightJoyPort = 0;
  public static final int mechJoyPort = 1;


  
  	/**
	 * Which PID slot to pull gains from. Starting 2018, you can choose from
	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
	 * configuration.
	 */
	public static final int kSlotIdx = 0;

	/**
	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
	 * now we just want the primary one.
	 */
	public static final int kPIDLoopIdx = 0;

	/**
	 * Set to zero to skip waiting for confirmation, set to nonzero to wait and
	 * report to DS if action fails.
	 */
	public static final int kTimeoutMs = 30;
	
	/* Choose so that Talon does not report sensor out of phase */
	public static boolean kSensorPhase = false;

	/**
	 * Choose based on what direction you want to be positive,
	 * this does not affect motor invert. 
	 */
	public static boolean kMotorInvert = true;

	/**
	 * Gains used in Positon Closed Loop, to be adjusted accordingly
     * Gains(kp, ki, kd, kf, izone, peak output);
     */
  public static final Gains kGains = new Gains(.8, 0.0002, 75.0, 0.0, 0, 0.4);
    
}
