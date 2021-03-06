package com.team6133.frc2018.auto.modes;

import com.team6133.frc2018.Constants;
import com.team6133.frc2018.auto.AutoModeBase;
import com.team6133.frc2018.auto.AutoModeEndedException;
import edu.wpi.first.wpilibj.DriverStation;

public class CENTER_ScoreSwitchNear extends AutoModeBase {
    @Override
    protected void routine() throws AutoModeEndedException {
        AutoModeBase determinedAutoMode = new Option_StartCenter_EndScoreLeftSwitch();
        if (Constants.kGameSpecificMessage.length() != 3) {
            if (DriverStation.getInstance().isFMSAttached())
                Constants.kGameSpecificMessage = DriverStation.getInstance().getGameSpecificMessage();
            else
                Constants.kGameSpecificMessage = "LLLX";
        }
        if (Constants.kGameSpecificMessage.charAt(0) == 'R') {
            determinedAutoMode = new Option_StartCenter_EndScoreSwitchRight();
            System.out.println(Constants.kGameSpecificMessage + "\t-> Starting Score Right Switch");
        } else {
            System.out.println(Constants.kGameSpecificMessage + "\t-> Starting Score Left Switch");
        }
        child = determinedAutoMode;
        determinedAutoMode.run();
    }
}
