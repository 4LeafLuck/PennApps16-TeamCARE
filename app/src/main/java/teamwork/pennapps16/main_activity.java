package teamwork.pennapps16;

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


/**
 * Created by Libby on 9/9/17.
 */

public class main_activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        final TextView Title = (TextView) findViewById(R.id.title_main);
        final Button StartButton = (Button) findViewById(R.id.start_button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
            StartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setContentView(R.layout.select_layout);
                }
            });
    }
}
