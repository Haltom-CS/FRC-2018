package com.team6133.frc2018.auto.modes;

import com.team6133.frc2018.Constants;
import com.team6133.frc2018.auto.AutoModeBase;
import com.team6133.frc2018.auto.AutoModeEndedException;
import com.team6133.frc2018.auto.AutonPathSettings;
import com.team6133.frc2018.auto.actions.*;
import com.team6133.lib.util.SensorTarget;
import com.team6133.lib.util.math.Rotation2d;
import edu.wpi.first.wpilibj.Timer;

import java.util.Arrays;

public class Option_StartCenter_EndFarRightSwitch extends AutoModeBase {
    AutonPathSettings path1 = new AutonPathSettings(FACE_LEFT, 0, 40, new SensorTarget(SensorTarget.Sensor.LeftIRPD, 40, true), .1, .35);
    AutonPathSettings path2 = new AutonPathSettings(FACE_RIGHT, 100, 0, new SensorTarget(SensorTarget.Sensor.Ultra, 32, false), 2, .35);
    AutonPathSettings path3 = new AutonPathSettings(FACE_RIGHT, 0, 160, new SensorTarget(SensorTarget.Sensor.RightIRPD, 150, true), .5, .35);
    AutonPathSettings path4 = new AutonPathSettings(FACE_RIGHT, -12,0, new SensorTarget(SensorTarget.Sensor.Ultra, Constants.SWITCH_SIDE_DISTANCE_INCHES, false) , .5, .35);

    @Override
    protected void routine() throws AutoModeEndedException {
        System.out.println("Option_StartCenter_EndFarRightSwitch()");
        double start = Timer.getFPGATimestamp();
        runAction(new ResetStartingPoseAction(Rotation2d.fromDegrees(FACE_LEFT)));

        //runAction(new WaitAction(.5));

        runAction(new DrivePathAction(path1));
        System.out.println("Path 1/4 Time:\t" + (Timer.getFPGATimestamp() - start));

        runAction(new DrivePathAction(path2));
        System.out.println("Path 2/4 Time:\t" + (Timer.getFPGATimestamp() - start));

        runAction(new DrivePathAction(path3));
        System.out.println("Path 3/4 Time:\t" + (Timer.getFPGATimestamp() - start));

        runAction(new DrivePathAction(path4));
        System.out.println("Path 4/4 Time:\t" + (Timer.getFPGATimestamp() - start));

        runAction(new PrepLaunchSwitchAction());
        runAction(new LaunchSwitchAction());
        System.out.println("Score Switch Time:\t" + (Timer.getFPGATimestamp() - start));

        runAction(new WaitAction(15));
    }
}
