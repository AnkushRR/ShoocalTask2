package in.ankushrodewad.shoocaltask2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_1)
    EditText et1;

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    @BindView(R.id.btn_add_view)
    ImageButton btn_addView;

    @BindView(R.id.btn_save)
    Button btn_save;

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.editText2)
    EditText editText2;

    @BindView(R.id.checkBox)
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn_addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.custom_view_layout, null);
                ImageButton iv_btn = (ImageButton) constraintLayout.findViewById(R.id.iv_remove);
                iv_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        linearLayout.removeView(constraintLayout);
                    }
                });
                linearLayout.addView(constraintLayout);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Two[] arr = new Two[linearLayout.getChildCount()];
                for(int i=0; i<linearLayout.getChildCount(); i++){
                    ConstraintLayout l = (ConstraintLayout) linearLayout.getChildAt(0);
                    arr[i] = new Two();
                    arr[i].setA(((EditText)(l.findViewById(R.id.editText))).getText().toString());
                    arr[i].setB(((EditText)(l.findViewById(R.id.editText2))).getText().toString());
                    arr[i].setC(((CheckBox)l.findViewById(R.id.checkBox)).isChecked());
                }
                One one = new One(et1.getText().toString(), spinner.getSelectedItem().toString(), arr);
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                intent.putExtra("parcel-data", one);
                startActivity(intent);
            }
        });
    }
}
