package sfitproject.mcc.newgeofenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    private final int splashtime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mapact = new Intent(SplashScreen.this,MapsActivity.class);
                SplashScreen.this.startActivity(mapact);
                SplashScreen.this.finish();
            }
        },splashtime);

    }
}