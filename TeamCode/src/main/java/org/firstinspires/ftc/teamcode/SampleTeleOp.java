package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by tchan17 on 10/11/16.
 *
 * Sample TeleOp program for DARC. The TeleOp Class provides code for manual control of the robot using a game controller.
 *
 * Controls:
 *
 * D-pad Down: Backwards
 * D-pad Up: Forwards
 * D-pad Left: In-place left turn
 * D-pad Right: In-place right turn
 *
 */

public class SampleTeleOp extends OpMode {

    public static final int D_SPEED = 1;
    public static final int B_SPEED = -1;
    public static final int STOP = 0;

    public DcMotor leftMotor;
    public DcMotor rightMotor;

    /**
     *  Put the code you want the robot to run only once at the beginning of the program here.
     *  Generally, things like motor initialization happen here.
     */
    public void init(){

        leftMotor = hardwareMap.dcMotor.get("motor1"); //sets the left motor to the first motor in the hardware map
        rightMotor = hardwareMap.dcMotor.get("motor2"); //sets the right motor to the second motor in the hardware map

    }

    /**
     *  Put the code you want running over and over again until you terminate it here.
     *  Generally, things like checking for input or running the motors happen here.
     */
    public void loop(){

        double leftSpeed = STOP;
        double rightSpeed = STOP;

        //checks if D-pad Up is pressed and sets L & R motor speed to 1 if pressed
        if(gamepad1.dpad_up){
            leftSpeed = D_SPEED;
            rightSpeed = D_SPEED;
        }

        //checks if D-pad Down is pressed and sets L & R motor speed to -1 if pressed
        else if(gamepad1.dpad_down){
            leftSpeed = B_SPEED;
            rightSpeed = B_SPEED;
        }

        //checks if D-pad Left is pressed and sets L motor speed to -1 and R motor speed to 1 if pressed
        else if(gamepad1.dpad_left){
            leftSpeed = B_SPEED;
            rightSpeed = D_SPEED;
        }

        //checks if D-pad Left is pressed and sets L motor speed to 1 and R motor speed to -1 if pressed
        else if(gamepad1.dpad_right){
            leftSpeed = D_SPEED;
            rightSpeed = B_SPEED;
        }

        //Writes the new speed to the motor
        leftMotor.setPower(leftSpeed);
        rightMotor.setPower(rightSpeed);

    }

}
