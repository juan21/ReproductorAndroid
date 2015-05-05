package com.example.reproduct4;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends ActionBarActivity { 
	
	ImageView idImagen; 
	TextView textoEncima; 
	TextView textoDebajo;
    private MediaPlayer mpl;
    private int Estado = 1;
    private final int Reproducir = 1;
    private final int Pausar = 2;
    private Button bReproducir;
   	private Button bDetener;
   	private Button batras;
   	private Button badelante;
   	//boolean reproductor = false;
	int contador;

   	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item);
		
		textoEncima = (TextView) findViewById(R.id.textView_superior);
		textoDebajo = (TextView) findViewById(R.id.textView_inferior);
		idImagen = (ImageView) findViewById(R.id.imageView_imagen);
		
		Bundle bundle = getIntent().getExtras();
		textoEncima.setText(bundle.getString("encima"));
		textoDebajo.setText(bundle.getString("debajo"));
		idImagen.setImageResource(getIntent().getExtras().getInt("imagen"));
		bReproducir=(Button)findViewById(R.id.bReproducir);
		bDetener=(Button)findViewById(R.id.bDetener);
		batras = (Button)findViewById(R.id.batras);
		badelante = (Button)findViewById(R.id.badelante);
		
		switch (bundle.getInt("posicion")) {
		case 0:
			contador = 0;
			mpl = MediaPlayer.create(this, R.raw.paris);
			break;
		case 1:
			contador = 1;
			mpl = MediaPlayer.create(this, R.raw.scorp);
			break;
		case 2:
			contador = 2;
			mpl = MediaPlayer.create(this, R.raw.material);
			break;
		case 3:
			contador = 3;
			mpl = MediaPlayer.create(this, R.raw.sistar);
			break;
		case 4:
			contador = 4;
			mpl = MediaPlayer.create(this, R.raw.amo);
			break;
		}
		mpl.start();
	}
    public void bReproducir(View view){
        if(view == bReproducir){
            switch (Estado){
                case Reproducir:
                    mpl.start();
                    Estado = Pausar;
                    bReproducir.setText("Pause");
                    break;
                case Pausar:
                   mpl.pause();
                    Estado = Reproducir;
                    bReproducir.setText("Play");
                    break;
            }
        }
    }
    public void bDetener(View v){
        if(v == bDetener){
            mpl.stop();
        }
    }
    public void badelante(View view) {
		if (contador == 4) {
		} else {
			mpl.pause();
			contador++;
			try {
				nexPreviuSong(view);
			} catch (IOException e) {
				e.printStackTrace();
			}
			mpl.start();
		}
	}
	public void batras(View view) {
		if (contador == 0) {
		} else {
			mpl.pause();
			contador--;
			try {
				nexPreviuSong(view);
			} catch (IOException e) {
				e.printStackTrace();
			}
			mpl.start();
		}
	}
	private void nexPreviuSong(View v) throws IOException {
		switch (contador) {
		case 0:
			contador = 0;
			textoEncima.setText("Amalia Montero");
			textoDebajo.setText("Paris");
			idImagen.setImageResource(R.drawable.amalia);
			try {
				mpl.reset();
				mpl = MediaPlayer.create(this, R.raw.paris);
				mpl.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			break;
		case 1:
			contador = 1;
			textoEncima.setText("Scorpions");
			textoDebajo.setText("No One Like You");
			idImagen.setImageResource(R.drawable.scorpions);
			try {
				mpl.reset();
				mpl = MediaPlayer.create(this, R.raw.scorp);
				mpl.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} 
			break;
		case 2:
			contador = 2;
			textoEncima.setText("Hilary Duff");
			textoDebajo.setText("Chicas Materiales");
			idImagen.setImageResource(R.drawable.hilar2);
			try {
				mpl.reset();
				mpl = MediaPlayer.create(this, R.raw.material);
				mpl.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			contador = 3;
			textoEncima.setText("Sistars");
			textoDebajo.setText("Cool");
			idImagen.setImageResource(R.drawable.sistars);
			try {
				mpl.reset();
				mpl = MediaPlayer.create(this, R.raw.sistar);
				mpl.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			contador = 4;
			textoEncima.setText("Beattles");
			textoDebajo.setText("Y la Amo");
			idImagen.setImageResource(R.drawable.beatles);
			try {
				mpl.reset();
				mpl = MediaPlayer.create(this, R.raw.amo);
				mpl.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			break;
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
