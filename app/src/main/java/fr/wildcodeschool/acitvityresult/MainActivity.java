package fr.wildcodeschool.acitvityresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button tabAction = findViewById(R.id.activity_main_tab_action);
        tabAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TabActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        tvNumTab = findViewById(R.id.activity_main_num_tab_tv);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == AppCompatActivity.RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                tvNumTab.setText(String.valueOf(result));
            }
            if (resultCode == AppCompatActivity.RESULT_CANCELED) {
                tvNumTab.setText("");
            }
        }
    }
}
