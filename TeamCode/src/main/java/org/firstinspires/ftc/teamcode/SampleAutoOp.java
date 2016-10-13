package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by tchan17 on 10/11/16.
 */

public class SampleAutoOp extends OpMode {


    private static final int TRAVEL_TIME = 3000;
    private static final int TURN_TIME = 1500;

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    private int mode = 0;
    private long time = -1;

    /**
     *  Put the code you want the robot to run only once at the beginning of the program here.
     *  Generally, things like motor initialization happen here.
     */
    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("motor1");
        rightMotor = hardwareMap.dcMotor.get("motor2");
    }

    /**
     *  Put the code you want running over and over again until you terminate it here.
     *  Generally, things like checking for input or running the motors happen here.
     */
    @Override
    public void loop() {
        double leftSpeed = SampleTeleOp.STOP;
        double rightSpeed = SampleTeleOp.STOP;
        if(time == -1){
            time = System.currentTimeMillis();
        }
        switch(mode){
            case 0:
                if(System.currentTimeMillis() - time < TRAVEL_TIME){
                    leftSpeed = SampleTeleOp.D_SPEED;
                    rightSpeed = SampleTeleOp.D_SPEED;
                }
                else{
                    mode = (mode + 1) % 2;
                    time = System.currentTimeMillis();
                }
                break;
            case 1:
                if(System.currentTimeMillis() - time < TURN_TIME){
                    leftSpeed = SampleTeleOp.B_SPEED;
                    rightSpeed = SampleTeleOp.D_SPEED;
                }
                else{
                    mode = (mode + 1) % 2;
                    time = System.currentTimeMillis();
                }
                break;
        }

        leftMotor.setPower(leftSpeed);
        rightMotor.setPower(rightSpeed);
    }
}
