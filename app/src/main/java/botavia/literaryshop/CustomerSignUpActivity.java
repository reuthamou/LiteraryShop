package botavia.literaryshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import entities.Customer;

public class CustomerSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);
    }

    public void register(View V) {
        EditText Eemail = (EditText)findViewById(R.id.editText);
        String email = Eemail.getText().toString();

        //check if email exists in the database
        if(MainActivity.databaseList.doesCustomerEmailExist(email)) {
            TextView errorMessage = (TextView)findViewById(R.id.error_message_registration);
            errorMessage.setText(getResources().getText(R.string.email_taken).toString());
            errorMessage.setVisibility(View.VISIBLE);
            return;
        }

    }
}
