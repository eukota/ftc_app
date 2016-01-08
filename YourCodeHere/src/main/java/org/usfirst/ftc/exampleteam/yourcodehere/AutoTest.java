package org.usfirst.ftc.exampleteam.yourcodehere;
import org.swerverobotics.library.interfaces.Autonomous;
/*
	Autonomous program turns 90 degrees.
*/
@Autonomous(name = "AUTO Testing", group = "Swerve Examples")
public class AutoTest extends MasterAutonomous
{
    @Override
    protected void main() throws InterruptedException{

        //Initialize our hardware
        initialize();

        // Wait until we've been given the ok to go
        waitForStart();

        turnTo(90);
    }
}
