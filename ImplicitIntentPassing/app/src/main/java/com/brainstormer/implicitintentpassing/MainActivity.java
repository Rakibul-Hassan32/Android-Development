package com.brainstormer.implicitintentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnDial,btnMsg,btnEmail,btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);
        btnMsg = findViewById(R.id.btnMsg);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +8801824319780"));
                startActivity(iDial);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent massage = new Intent(Intent.ACTION_SENDTO);
                massage.setData(Uri.parse("smsto:"+Uri.encode("+8801824319780")));
                massage.putExtra("sms_body","Please solve this problem asap.");
                startActivity(massage);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"rakkibul007@gmail.com","rakibul3238@gmail.com","rakibulprodhan18@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Quaries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please resolve this issue asap");
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Download FIFA now, https://play.google.com/store/apps/details?id=com.ea.gp.fifamobile");
                startActivity(Intent.createChooser(iShare,"Share via"));
            }
        });

    }
}