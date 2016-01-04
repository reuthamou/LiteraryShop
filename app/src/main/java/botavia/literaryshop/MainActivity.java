<<<<<<< HEAD
package botavia.literaryshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import entities.Customer;
import model.datasource.DatabaseList;

public class MainActivity extends AppCompatActivity {
    //Create the database lists
    public static DatabaseList databaseList = new DatabaseList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //Set the content of the databaseList
        databaseList.setLists();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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

    /**
     * This method is executed when the SignIn button is clicked
     * @param v
     */
    public void startVerification(View v) {
        // Extract the username and password that were entered
        EditText usernameE = (EditText)findViewById(R.id.editText);
        EditText passwordE = (EditText)findViewById(R.id.editText2);

        String username = usernameE.getText().toString();
        String password = passwordE.getText().toString();

        try {
            //find the user in the database
            Customer customer = databaseList.findCustomerByUsername(username);
            if (customer.getPassword().equals(password)) {
                // if the login in valid, continue to the store
                Intent loginIntent = new Intent(this, ProductList.class);
                loginIntent.putExtra("customerId", customer.getId());
                startActivity(loginIntent);
            }
            else throw new Exception("The password you have entered is incorrect");
        }

        catch (Exception a) {
            Toast.makeText(this, a.getMessage(), Toast.LENGTH_SHORT);
        }

    }

}
=======
package botavia.literaryshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import entities.Customer;
import model.datasource.DatabaseList;

public class MainActivity extends AppCompatActivity {
    //Create the database lists
    public static DatabaseList databaseList = new DatabaseList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //Set the content of the databaseList
        databaseList.setLists();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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

    /**
     * This method is executed when the SignIn button is clicked
     * @param v
     */
    public void startVerification(View v) {
        // Extract the username and password that were entered
        EditText usernameE = (EditText)findViewById(R.id.editText);
        EditText passwordE = (EditText)findViewById(R.id.editText2);

        String username = usernameE.getText().toString();
        String password = passwordE.getText().toString();

        try {
            //find the user in the database
            Customer customer = databaseList.findCustomerByUsername(username);
            if (customer.getPassword().equals(password)) {
                // if the login in valid, continue to the store
                Intent loginIntent = new Intent(this, ProductList.class);
                loginIntent.putExtra("customerId", customer.getId());
                startActivity(loginIntent);
            }
            else throw new Exception(getResources().getText(R.string.password_incorrecrt).toString());
        }

        catch (Exception a) {
            Toast.makeText(this, a.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void goToSignUp(View v) {
        Intent signUpIntent = new Intent (this, CustomerSignUpActivity.class);
        startActivity(signUpIntent);
    }

}
>>>>>>> 3304e3cfe2203f7ad47c08af54fc900bc608f856
