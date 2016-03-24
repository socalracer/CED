package net.peaknw.sambaexplorer;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;
import android.os.Bundle;

public class SambaLogin extends Activity {
    public String share;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        share = i.getStringExtra("share");

        setContentView(R.layout.login);

        Button btn = (Button)findViewById(R.id.Button01);
        btn.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                EditText domain = (EditText)findViewById(R.id.EditTextDomain);
                EditText username = (EditText)findViewById(R.id.EditTextUsername);
                EditText password = (EditText)findViewById(R.id.EditTextPassword);

                net.peaknw.sambaexplorer.DownloadService.ProvideLoginCredentials(domain.toString(), username.toString(), password.toString());

                Intent intent = new Intent(SambaLogin.this, net.peaknw.sambaexplorer.SambaExplorer.class);
                //Intent intent = new Intent(this, net.peaknw.sambaexplorer.SambaExplorer.class);
                intent.setData(Uri.parse(share));
                startActivity(intent);
            }
        });
    }

}
