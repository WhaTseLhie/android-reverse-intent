package pardillo.john.jv.reverseintent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static int REQUEST_ADD_NAME = 100;
    private final static String TAG = "MAIN ACTIVITY";

    private ListView lv;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lv = this.findViewById(R.id.listView);
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        this.lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent addNameIntent = new Intent(this, AddNameActivity.class);
        startActivityForResult(addNameIntent, REQUEST_ADD_NAME);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // throws an exception if data is empty
        try {
            // check if the code is ok
            if (resultCode == Activity.RESULT_OK) {
                // check the requesting code
                if (requestCode == REQUEST_ADD_NAME) {
                    // get all the data from requested activity
                    Bundle b = data.getExtras();
                    // get the specific data from requested activity
                    String name = b.getString("name");
                    // add the data in to the list
                    list.add(name);
                    // update list
                    adapter.notifyDataSetChanged();
                }
            }
        } catch(Exception e) {
            Log.d("ERROR: ", TAG);
        }
    }
}
