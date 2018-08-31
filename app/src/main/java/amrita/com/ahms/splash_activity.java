package amrita.com.ahms;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import hostel.amrita.com.ahms.R;

public class splash_activity extends AppCompatActivity {
    private static int SPLASH_TIMEOUT = 4000;

    @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_activity);

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (connected()) {
                        Intent homeIntent = new Intent(splash_activity.this, MainActivity.class);
                        startActivity(homeIntent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Please Connect to the Internet",Toast.LENGTH_LONG).show();
                    }

                }
            }, SPLASH_TIMEOUT);

        }

    private boolean connected() {

        ConnectivityManager cManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo=cManager.getActiveNetworkInfo();
        return nInfo!=null && nInfo.isConnected();
    }
}

