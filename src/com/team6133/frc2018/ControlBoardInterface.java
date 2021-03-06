package com.team6133.frc2018;

/**
 * A basic framework for robot controls that other controller classes implement
 */
public interface ControlBoardInterface {
    // DRIVER CONTROLS
    double getThrottleX();

    double getThrottleY();

    double getTwist();


    // OPERATOR CONTROLS
    boolean getRotateLeftButton();

    boolean getRotateRightButton();

    boolean getIntakeFloorButton();

    boolean getIntakeStackButton();

    boolean getWantsAlignButton();

    boolean getExhaustExchangeButton();

    boolean getExhaustSwitchButton();

    boolean getWantsLaunchButton();

    boolean getLoadLauncherButton();

    boolean getActuateIntakePistonsButton();

    boolean getExtendClimbButton();

    boolean getRetractClimbButton();

    boolean getClimbButton();

    boolean getWantsCubeIntakeButton();

}