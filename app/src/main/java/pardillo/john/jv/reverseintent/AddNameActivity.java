package pardillo.john.jv.reverseintent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        this.txtName = this.findViewById(R.id.editText);
        this.btnSave = this.findViewById(R.id.button);
        this.btnCancel = this.findViewById(R.id.button2);

        this.btnSave.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                String name = this.txtName.getText().toString();

                if(TextUtils.isEmpty(name)) {
                    Toast.makeText(this, "Please input your name", Toast.LENGTH_LONG).show();
                } else {
                    // prepare to return data to requesting activity
                    Intent blindIntent = new Intent();
                    blindIntent.putExtra("name", name);
                    // set the resultCode to RESULT_OK
                    this.setResult(Activity.RESULT_OK, blindIntent);
                    // terminate the current activity
                    this.finish();
                }

                break;
            case R.id.button2:
                // terminate the current activity
                this.finish();

                break;
        }
    }
}
