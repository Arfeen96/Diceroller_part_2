package com.example.diceroller_part_2;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int count;
    private TextView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (TextView) this.findViewById(R.id.listview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view){

        TextView tv = (TextView) this.findViewById(R.id.numbertextView);

        try {

            TextView tv3 = (TextView) this.findViewById(R.id.textView2);
            EditText tv2 = (EditText) this.findViewById(R.id.editText);

            Random r = new Random();
            int number = r.nextInt(6);

            tv.setText(Integer.toString(number));
            String input = tv2.getText().toString();
            int input2 = Integer.parseInt(input);

            if (input2 == number) {

                tv.setText("Congratulations");
                count++;
            }

            tv3.setText(Integer.toString(count));
        }

        catch (Exception e) {

            tv.setText("Please enter number from 1-6");
        }
    }

    public void on_button_click3(View view){

        ArrayList<String> randlist = new ArrayList<>();
        randlist.add("1) If you could go anywhere in the world, where would you go?");
        randlist.add("2) If you were stranded on a desert island, what three things would you want to take with you?");
        randlist.add("3) If you could eat only one food for the rest of your life, what would that be?");
        randlist.add("4) If you won a million dollars, what is the first thing you would buy?");
        randlist.add("5) If you could spaned the day with one fictional character, who would it be?");
        randlist.add("6) If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        Random rand = new Random();

        int numelement = 1;

        for (int i = 0; i < numelement; i++) {

            int randi = rand.nextInt(randlist.size());
            String rande = randlist.get(randi);
            listview.setText(rande);
        }
    }
}


