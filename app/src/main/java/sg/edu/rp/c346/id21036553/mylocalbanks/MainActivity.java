package sg.edu.rp.c346.id21036553.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB, tvPOSB, tvSc;
    String bankSelected = "";
    String url = "";
    String phoneNumber = "";

    boolean favDBS, favOCBc, favUOB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);
        tvPOSB = findViewById(R.id.tvPOSB);
        tvSc = findViewById(R.id.tvSc);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
        registerForContextMenu(tvPOSB);
        registerForContextMenu(tvSc);
        tvDBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ "18001111111"));
                startActivity(intentCall);

            }
        });

        tvOCBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ "18003633333"));
                startActivity(intentCall);

            }
        });

        tvUOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);

            }
        });

        tvPOSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003396666"));
                startActivity(intentCall);

            }
        });

        tvSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18007477000"));
                startActivity(intentCall);

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvDBS) {
            bankSelected = "DBS";
        } else if (v == tvOCBC) {
            bankSelected = "OCBC";
        } else if (v == tvUOB) {
            bankSelected = "UOB";
        } else if (v == tvPOSB) {
            bankSelected = "POSB";
        } else if (v == tvSc) {
            bankSelected = "Sc";
        } else {
            bankSelected = "";
        }

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS Bank");
            tvOCBC.setText("OCBC Bank");
            tvUOB.setText("UOB Bank");
            tvPOSB.setText("POSB Bank");
            tvSc.setText("Standard Chartered");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            tvPOSB.setText("繁體中⽂");
            tvSc.setText("渣打集團");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
            tvPOSB.setText("Error translation");
            tvSc.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView tvSelected = null;
        if (bankSelected.equalsIgnoreCase("DBS")) {
            url = "https://www.dbs.com.sg";
            phoneNumber = "18001111111";
            tvSelected = tvDBS;
        } else if (bankSelected.equalsIgnoreCase("OCBC")) {
            url = "https://www.ocbc.com";
            phoneNumber = "18003633333";
            tvSelected = tvOCBC;
        } else if (bankSelected.equalsIgnoreCase("UOB")) {
            url = "https://www.uob.com.sg";
            phoneNumber = "18002222121";
            tvSelected = tvUOB;
        } else if (bankSelected.equalsIgnoreCase("POSB")) {
            url = "https://www.posb.com.sg/";
            phoneNumber = "18003396666";
            tvSelected = tvPOSB;
        } else if (bankSelected.equalsIgnoreCase("Sc")) {
            url = "https://www.sc.com/sg/";
            phoneNumber = "18007477000";
            tvSelected = tvSc;
        } else {
            url = "";
            phoneNumber = "";
        }
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0

            Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intentCall);
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ phoneNumber));
            startActivity(intentCall);
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation


    }


}