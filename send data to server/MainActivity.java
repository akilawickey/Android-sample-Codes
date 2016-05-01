package asak.pro.send_data_to_server;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class MainActivity extends AppCompatActivity {
    TextView content;
    EditText fname,email,login,pass;
    Thread background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = (TextView)findViewById(R.id.content);
        fname	= (EditText)findViewById(R.id.name);
        email	= (EditText)findViewById(R.id.email);
        login	= (EditText)findViewById(R.id.loginname);
        pass	= (EditText)findViewById(R.id.password);
        Button saveme=(Button)findViewById(R.id.save);
        Button postmsg = (Button)findViewById(R.id.post);


        postmsg.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

//                Intent intent = new Intent(getApplicationContext(), post_send.class);
//                startActivity(intent);


            }


        });


        saveme.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //ALERT MESSAGE
                Toast.makeText(getBaseContext(),
                        "Please wait moment, connecting to server.",
                        Toast.LENGTH_LONG).show();


                background = new Thread(new Runnable() {

                    public void run() {


                        HttpClient Client = new DefaultHttpClient();
                       // String URL = "http://192.168.43.252/?"+tv.getText().toString();
                       //    String URL = "http://mytest123.net84.net/index.php?user="+fname.getText().toString();
                        String URL = "http://mytest123.net84.net/index.php?user="+fname.getText().toString()+"&name="+email.getText().toString();

                        //Log.i("httpget", URL); ok
                        try {
                            HttpGet httpget = new HttpGet(URL);
                            ResponseHandler<String> responseHandler = new BasicResponseHandler();

                            String SetServerString = "";
                            SetServerString = Client.execute(httpget, responseHandler);
                            //   content.setText(SetServerString);
                        } catch (Exception ex) {
                            //  content.setText("Fail!");
                        }
                    }
                });

                background.start();


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
}
