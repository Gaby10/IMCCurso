package basico.android.cftic.edu.calculaimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private float peso = 0f;
    private float altura = 0f;


    private static float pedirPeso()
    {
        float peso=0;
        Scanner scanner = null;

        //TODO pedir peso por pantalla
        System.out.println ("Introduzca peso (kg) ");
        scanner = new Scanner(System.in);//preparo para leer de teclado
        peso = scanner.nextFloat();

        return peso;
    }


    private static float pedirAltura()
    {
        float altura=0;
        Scanner scanner = null;


        System.out.println ("Introduzca altura (m) ");
        scanner = new Scanner(System.in);//preparo para leer de teclado
        altura = scanner.nextFloat();

        return altura;
    }

    public static float calcularIMC (float peso,float altura)
    {
        float imc = 0;

        imc = peso/(altura*altura);

        return imc;

    }


    public  String informarIMC (float imc) {
        String res = "Su IMC es " + imc;
        System.out.println("Su IMC es " + imc);

        ImageView imagen = findViewById(R.id.imagen);

        if (imc < 16) {
            System.out.println();
            res += getResources().getString(R.string.desnutrido);

            imagen.setImageResource(R.drawable.desnutrido);


        } else if (imc < 18) {
            System.out.println();
            res += getResources().getString(R.string.delgado);
            imagen.setImageResource(R.drawable.delgado);

        } else if (imc < 25) {
            System.out.println();
            res += getResources().getString(R.string.ideal);
            imagen.setImageResource(R.drawable.ideal);
        } else if (imc < 31) {
            System.out.println();
            res += getResources().getString(R.string.sobrepeso);
            imagen.setImageResource(R.drawable.sobrepeso);
        } else {
            System.out.println();
            res += getResources().getString(R.string.obeso);
            imagen.setImageResource(R.drawable.obeso);
        }
        return res;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Para cambiar la imagen

        ImageView imageView = findViewById(R.id.imagen);
        imageView.setImageResource(R.mipmap.ic_launcher);
    }
        @Override
        protected void onStart() {
            super.onStart();

            Log.d("MIAPP", "Estoy en onStart");

        }
        protected void onResume () {
            super.onResume();
            Log.d("MIAPP", "Estoy en onResume");

        }
        protected void onStop () {
            super.onStop();
            Log.d("MIAPP", "Estoy en onStop");

        }
        protected void onDestroy(){
            super.onDestroy();
            Log.d("MIAPP", "Estoy en onDestroy");

        }


    public void mostrarIMC (View view){

        //TODO Gestionar el evento del boton

        // int id_vista = view.getId()
        //Recoger el texto introducido
        EditText editText = findViewById(R.id.campo_peso);
        Float peso = Float.parseFloat(editText.getText().toString()) ;//Para que me de el texto traducido


        EditText editText2 = findViewById(R.id.campo_altura);
        Float altura = Float.parseFloat(editText2.getText().toString());




        Float resultado = calcularIMC(peso, altura);
        String estado = informarIMC(resultado);
        //Mostrarlo
        TextView caja_destino = findViewById(R.id.mostrar);
        caja_destino.setText(estado);






    }





}// Class
