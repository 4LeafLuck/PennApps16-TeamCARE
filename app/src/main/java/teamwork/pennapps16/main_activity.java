package teamwork.pennapps16;
import android.hardware.SensorEvent;
import 	android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import 	android.hardware.Sensor;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Libby on 9/9/17.
 */

public class main_activity extends AppCompatActivity  {
    SensorManager sensorManager;
    TextView Steps = (TextView) findViewById(R.id.counter);
    boolean walking = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        final TextView Title = (TextView) findViewById(R.id.title_main);
        final Button StartButton = (Button) findViewById(R.id.start_button);
            StartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.select_layout);
<<<<<<< HEAD
                    final Button GameChoose = (Button) findViewById(R.id.game_init);
                    final Button StatButton = (Button) findViewById(R.id.stat_button);
                    final Button CustomButton = (Button) findViewById(R.id.custom_button);
                    GameChoose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setContentView(R.layout.game_layout);



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
=======
>>>>>>> parent of 224aefc... Set up for continuation
                }
            });
    }
}
