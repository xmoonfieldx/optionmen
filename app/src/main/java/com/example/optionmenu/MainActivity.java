package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        Button button;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                TextView textview = findViewById(R.id.text_view);
                registerForContextMenu(textview);
                button=findViewById(R.id.button2);
                button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                showalert();

                        }

                        private void showalert() {
                                AlertDialog.Builder alerts = new AlertDialog.Builder(MainActivity.this);
                                alerts.setTitle("Alert text")
                                        .setMessage("This is just an alert")
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                        dialogInterface.cancel();

                                                }
                                        })
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                        dialogInterface.cancel();

                                                }
                                        }).show();
                                alerts.create();
                        }
                });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                super.onCreateContextMenu(menu, v, menuInfo);
                menu.setHeaderTitle("Choose Your option");
                getMenuInflater().inflate(R.menu.example_menu, menu);

        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                        case R.id.option_1:
                                Toast.makeText(this, "option 1 selected", Toast.LENGTH_SHORT).show();
                                return true;

                        case R.id.option_2:
                                Toast.makeText(this, "option 2 selected", Toast.LENGTH_SHORT).show();
                                return true;

                        case R.id.option_3:
                                Toast.makeText(this, "option 3 selected", Toast.LENGTH_SHORT).show();
                                return true;

                }
                return super.onContextItemSelected(item);
        }
}

