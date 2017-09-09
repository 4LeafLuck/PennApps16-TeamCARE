package teamwork.pennapps16;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

import org.w3c.dom.Text;

import java.util.Arrays;







/**
 * Created by Libby on 9/9/17.
 */

public class main_activity extends AppCompatActivity implements SensorEventListener {
    //CallbackManager callbackManager;
    final SharedPreferences mPrefs = getSharedPreferences("win/loss", 0);
    final String winLoss = mPrefs.getString("StudyTag", "Unknown");
    int value = 0;
    String congrats = "You've earned a gift for your avatar";
    final TextView pedometer = (TextView) findViewById(R.id.pedometer_text);
    protected void onCreate(Bundle savedInstanceState) {
        //FacebookSdk.sdkInitialize(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        final TextView pedometer = (TextView) findViewById(R.id.pedometer_text);

        final TextView Title = (TextView) findViewById(R.id.title_main);
        final Button StartButton = (Button) findViewById(R.id.start_button);
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
                            //Button challButton = (Button) findViewById(R.id.challenge_start);
                            final SensorManager sensorManager;
                            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


                            final TextView counter = (TextView) findViewById(R.id.countdown);
                            Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
                            sensorManager.registerListener(new SensorEventListener() {
                                @Override
                                public void onSensorChanged(SensorEvent event) {


                                }

                                @Override
                                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                                }
                            }, countSensor, SensorManager.SENSOR_DELAY_UI);
                            if (value >= 10000) {
                                counter.setText(congrats);
                                SharedPreferences.Editor mEditor = mPrefs.edit();
                                mEditor.putString("winLoss", "Win").commit();
                            }


                        }

                    });
                    StatButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setContentView(R.layout.stat_layout);
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
        pedometer.setText(String.valueOf(event.values[0]));
        value++;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }




   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }*/
}
