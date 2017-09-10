package teamwork.pennapps16;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;
import java.util.ArrayList;
import android.view.inputmethod.*;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.lang.Object;
import android.provider.AlarmClock;
import android.content.SharedPreferences;
import java.io.File;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.*;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import android.graphics.drawable.Drawable;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.logging.Handler;


/**
 * Created by Libby on 9/9/17.
 */

public class main_activity extends AppCompatActivity implements SensorEventListener {
    //CallbackManager callbackManager;
    boolean moving;
    TextView pedometer;
    String congrats;
    SensorManager sensorManager;
    Button DeveloperButton;

    TextView winTitle;
    TextView accessoryInfo;
    String sorry;
    //int win;
    TextView congratsTitle;
    TextView congratsText;
    Button Go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences aPrefs = getSharedPreferences("WinLose", 0);
        final Boolean WinLose = aPrefs.getBoolean("winTag", false);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.main_layout);
        /*final SharedPreferences mPrefs = getSharedPreferences("winLose", 0);
        final String winLose = mPrefs.getString("win/lose_tag", "Unknown");*/
        //win=1;
       // congrats = "you got a reward!";
        TextView counter = (TextView) findViewById(R.id.countdown);


        winTitle = (TextView) findViewById(R.id.win_title);
        accessoryInfo = (TextView) findViewById(R.id.prize_text);
        congratsTitle = (TextView) findViewById(R.id.congrats_title);
        congratsText = (TextView) findViewById(R.id.congrats_text);

        ImageView bodyDark = (ImageView)findViewById(R.id.bodydark);
        ImageView bodyLight = (ImageView)findViewById(R.id.bodylight);
        ImageView bodyMedium = (ImageView)findViewById(R.id.bodymedium);
        ImageView brows = (ImageView)findViewById(R.id.brows);
        ImageView faceFN = (ImageView)findViewById(R.id.facefemaleneutral);
        ImageView faceFS = (ImageView)findViewById(R.id.facefemalesmile);
        ImageView faceMN = (ImageView)findViewById(R.id.facemaleneutral);
        ImageView faceMS = (ImageView)findViewById(R.id.facemalesmile);
        ImageView hairFBlack = (ImageView)findViewById(R.id.hairfemaleblack);
        ImageView hairFBlonde = (ImageView)findViewById(R.id.hairfemaleblonde);
        ImageView hairFBrown = (ImageView)findViewById(R.id.hairfemalebrown);
        ImageView hairMBlack = (ImageView)findViewById(R.id.hairmaleblack);
        ImageView hairMBlonde = (ImageView)findViewById(R.id.hairmaleblonde);
        ImageView hairMBrown = (ImageView)findViewById(R.id.hairmalebrown);
        ImageView shirtF = (ImageView)findViewById(R.id.shirtfemale);
        ImageView shirtM = (ImageView)findViewById(R.id.shirtmale);
        ImageView shoes = (ImageView)findViewById(R.id.shoes);
        ImageView shorts = (ImageView)findViewById(R.id.shorts);

        bodyDark.setVisibility(View.INVISIBLE);
        bodyLight.setVisibility(View.VISIBLE);
        bodyMedium.setVisibility(View.INVISIBLE);
        brows.setVisibility(View.VISIBLE);
        faceFN.setVisibility(View.VISIBLE);
        faceFS.setVisibility(View.INVISIBLE);
        faceMN.setVisibility(View.INVISIBLE);
        faceMS.setVisibility(View.INVISIBLE);
        hairFBlack.setVisibility(View.VISIBLE);
        hairFBlonde.setVisibility(View.INVISIBLE);
        hairFBrown.setVisibility(View.INVISIBLE);
        hairMBlack.setVisibility(View.INVISIBLE);
        hairMBlonde.setVisibility(View.INVISIBLE);
        hairMBrown.setVisibility(View.INVISIBLE);
        shirtF.setVisibility(View.VISIBLE);
        shirtM.setVisibility(View.INVISIBLE);
        shoes.setVisibility(View.VISIBLE);
        shorts.setVisibility(View.VISIBLE);


        //sorry = "Sorry, you haven't won any accessories";
        moving = false;


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);



       // final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        //callbackManager = CallbackManager.Factory.create();
        //final TextView loginReport = (TextView) findViewById(R.id.login_log) ;






        final TextView Title = (TextView) findViewById(R.id.title_main);
        final Button StartButton = (Button) findViewById(R.id.start_button);
        final Button logIn = (Button) findViewById(R.id.login_button);
            StartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.select_layout);

                    final Button GameChoose = (Button) findViewById(R.id.game_init);
                    final Button StatButton = (Button) findViewById(R.id.stat_button);
                    final Button CustomButton = (Button) findViewById(R.id.custom_button);
                    GameChoose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setContentView(R.layout.game_layout);
                            DeveloperButton = (Button) findViewById(R.id.developer_button);
                            Go = (Button) findViewById(R.id.go_button);

                            Go.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    pedometer = (TextView) findViewById(R.id.pedometer_text);
                                   /* for (int i = 0; i < 100; i++) {
                                        try {
                                            pedometer.setText(i);

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }*/


                                    new CountDownTimer(7000,100){
                                        int inCount = 60;

                                        public void onTick(long millisUntilFinished){

                                            pedometer.setText(String.valueOf(7000-millisUntilFinished/1000));
                                            // inCount--;
                                        }

                                        public void onFinish(){

                                            SharedPreferences.Editor aEditor = aPrefs.edit();
                                            aEditor.putBoolean("winTag", true).apply();
                                        }
                                    }.start();
                                }
                            });

                            //Button challButton = (Button) findViewById(R.id.challenge_start);

                            //challButton.setOnClickListener(new View.OnClickListener() {
                              //  @Override
                                //public void onClick(View v) {

                               // }

                            //});

                        DeveloperButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //win=+1;
                                SharedPreferences.Editor aEditor = aPrefs.edit();
                                aEditor.putBoolean("winTag", true).apply();

                                //SharedPreferences.Editor mEditor = mPrefs.edit();
                                //mEditor.putString("win/lose_tag", "win").apply();

                            }
                        });


                        }

                    });
                    StatButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                          if(WinLose){
                               setContentView(R.layout.win_layout);
                            }else{
                               setContentView(R.layout.stat_layout);
                            }

                        }
                    });
                    CustomButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setContentView(R.layout.custom_layout);
                        }
                    });

                }









            });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(moving){
            pedometer.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume(){
        super.onResume();
        moving = true;

        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if(countSensor!=null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);

        } else {
            Toast.makeText(this, "Sensor not found...", Toast.LENGTH_LONG).show();
            /*new CountDownTimer(60000, 6000) {
                int inCount = 6;

                public void onTick(long millisUntilFinished) {

                    pedometer.setText(String.valueOf(60000-millisUntilFinished / 1000));
                    // inCount--;
                }

                public void onFinish() {
                    pedometer.setText(congrats);

                }
                */


            };

        }
    }




   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }*/

