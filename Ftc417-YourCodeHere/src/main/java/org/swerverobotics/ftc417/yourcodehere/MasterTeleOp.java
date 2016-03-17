package org.swerverobotics.ftc417.yourcodehere;

import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.Range;

/**
 * 417 master opmode
 */
public abstract class MasterTeleOp extends MasterOpMode
{
    double wheelPowerMultiply = FULL_SPEED;

    boolean reverseMode = false;

    void initialize()
    {
        super.initialize();

        // Configure the knobs of the hardware according to how you've wired your
        // robot. Here, we assume that there are no encoders connected to the motors,
        // so we inform the motor objects of that fact.
        this.motorFrontLeft.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        this.motorFrontRight.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        this.motorBackLeft.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        this.motorBackRight.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        this.motorDeliverySlider.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        this.motorCollector.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        this.motorDeliverySlider.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

    }


    @Override
    public void driveLeft(double power)
    {
        if(reverseMode)
        {
            power *= -1.0;
            super.driveRight(Range.clip(power * wheelPowerMultiply, -1f, 1f));
        }
        else
        {
            super.driveLeft(Range.clip(power * wheelPowerMultiply, -1f, 1f));
        }
    }

    @Override
    public void driveRight(double power)
    {
        if(reverseMode)
        {
            power *= -1.0;
            super.driveLeft(Range.clip(power * wheelPowerMultiply, -1f, 1f));
        }
        else
        {
            super.driveRight(Range.clip(power * wheelPowerMultiply, -1f, 1f));
        }
    }


}