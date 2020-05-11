package sg.edu.rp.c346.id18015497.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText amt,pax,discount;
    Button split,reset;
    ToggleButton svs,gst;
    TextView bill,pay;
    float amount,paxamt,discountamt;
    float svsamt;
    float gstamt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amt = findViewById(R.id.amtEditText);
        pax = findViewById(R.id.paxEditText);
        discount = findViewById(R.id.discountEditText);

        split = findViewById(R.id.splitButton);
        reset = findViewById(R.id.resetButton);

        svs = findViewById(R.id.svsButton);
        gst = findViewById(R.id.gstButton);

        bill = findViewById(R.id.billamtTextView);
        pay = findViewById(R.id.splitamtTextView);


        svs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amount = Float.parseFloat(amt.getText().toString());

                if (svs.isChecked()) {
                    svsamt = amount / 100 * 10;
                }

                else {
                    svsamt = 0;
                }

            }
        });

        gst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amount = Float.parseFloat(amt.getText().toString());

                if (gst.isChecked()) {
                    gstamt = amount / 100 * 7;
                }

                else {
                    gstamt = 0;
                }
            }
        });

        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amount = Float.parseFloat(amt.getText().toString());
                discountamt = Float.parseFloat(discount.getText().toString());
                paxamt = Float.parseFloat(pax.getText().toString());


                float finaltotal = 0;
                finaltotal = (amount + svsamt + gstamt) - ((amount + svsamt + gstamt) * (discountamt / 100));
                float finalpay = 0;
                finalpay = finaltotal / paxamt;

                String stringbill = String.format("%.2f",finaltotal);
                String stringpay = String.format("%.2f",finalpay);
                bill.setText(stringbill);
                pay.setText(stringpay);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amt.setText("");
                pax.setText("");
                discount.setText("");
                svs.setChecked(false);
                gst.setChecked(false);
            }
        });
    }
}
