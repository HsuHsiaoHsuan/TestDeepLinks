package hkasianark.testdeeplinks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final boolean D = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        if (data != null) {
            parseLinksData(data);
        } else {
            Toast.makeText(this, "no Data", Toast.LENGTH_SHORT).show();
        }

    }

    private void parseLinksData(Uri data) {
        String path = data.getPath();

        String loginString = data.getLastPathSegment(); // should be 'login'

        String u = data.getQueryParameter("u");
        String p = data.getQueryParameter("p");
        String pid = data.getQueryParameter("pid");

        Toast.makeText(this,
                "u = " + u + "\np = " + p + "\npid = " + pid, Toast.LENGTH_SHORT).show();
    }
}
