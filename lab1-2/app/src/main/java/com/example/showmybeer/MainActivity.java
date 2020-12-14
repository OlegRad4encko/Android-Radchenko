package com.example.showmybeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner beersList;
    private TextView beerText;
    private Button Sbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beersList = findViewById(R.id.S_sortOfBeer);
        beerText = findViewById(R.id.TV_beerText);
        Sbutton = findViewById(R.id.B_sButton);

        View.OnClickListener OnButtonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] sortsOfBeer = {"А выбрать пивасик?","Papaya Rye, Viaemilia, Brio, Galaxy IPA, Nøgne Ø Porter, ManBearPig, Black Eyed King Imp Vietnamese Coffee Edition.",
                        "Мюнхенське світле, Пільзнер, Дортмундер, Травневий бок, Віденський лагер",
                        "Mann's Brown Ale, Tolly Cobbold Cobnut Nut Brown Ale","Портер, Стаут"};
                int idSelectedBear = (int) beersList.getSelectedItemId();
                //beerText.setText(String.valueOf(idSelectedBear));
                beerText.setText(sortsOfBeer[idSelectedBear]);
            }


        };

        Sbutton.setOnClickListener(OnButtonClick);

    }
}