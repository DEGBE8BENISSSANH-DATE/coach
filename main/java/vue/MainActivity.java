package vue;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coach.R;

import org.w3c.dom.Text;

import controler.Control;

public class MainActivity extends AppCompatActivity {

    private controler.Control Control;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.Control= Control.getInstance();


    }

    private EditText txtpoids;
    private EditText txttaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private ImageView imageView;
     private TextView imglbl;

    private void init() {
        txtpoids = (EditText) findViewById(R.id.txtpoids);
        txttaille = (EditText) findViewById(R.id.txttaille);
        txtAge = (EditText) findViewById(R.id.txtage);
        rdHomme = (RadioButton) findViewById(R.id.rdhomme);
        imageView = (ImageView) findViewById(R.id.imageView);
        imglbl = (TextView) findViewById(R.id.imglbl);
        ecouteCalcul();

    }


    private void ecouteCalcul() {

        ((Button) findViewById(R.id.button)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();{}


                Integer poids = 0;
                Integer taille = 0;
                Integer Age = 0;
                Integer sexe = 0;
                try {
                    poids = Integer.parseInt(txtpoids.getText().toString());
                    taille = Integer.parseInt(txttaille.getText().toString());
                    Age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception e){};

                if (rdHomme.isChecked()) {
                    sexe = 1;
                    if (poids == 0 || taille == 0 || Age == 0) {
                        Toast.makeText(MainActivity.this, "saisie incorect", Toast.LENGTH_SHORT).show();
                    }else{
                        affichersult(poids,taille,Age,sexe);
                    }
                }
            }
        });


    }

    /**
     *
     * @param poids
     * @param taille
     * @param Age
     * @param sexe
     */
    private void affichersult(Integer poids, Integer taille, Integer Age, Integer sexe) {
        this.Control.creerProfil(poids, taille, Age, sexe);
        float img = this.Control.getimg();
        String message = this.Control.getMessage();
        if (message == "normal") {
            imageView.setImageResource(R.drawable.normal);
        } else {
            if (message == "moyen") {
                imageView.setImageResource(R.drawable.moyen);
                imglbl.setTextColor(Color.BLUE);

            } else {
                imglbl.setTextColor(Color.RED);
                imageView.setImageResource(R.drawable.naz);
            }
            imglbl.setText(String.format("%.01f",img)+"Img"+""+message);

        }


    }


}

