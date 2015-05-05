package com.example.reproduct4;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ArrayList<Musica> pista = new ArrayList<Musica>();  
        
        pista.add(new Musica(R.drawable.amalia, "Amalia Montero", "Paris"));
        pista.add(new Musica(R.drawable.scorpions, "Scorpions", "No One Like You"));
        pista.add(new Musica(R.drawable.hilar2, "Hilary Duff", "Chicas Materiales"));
        pista.add(new Musica(R.drawable.sistars, "Sistar","Cool"));
        pista.add(new Musica(R.drawable.beatles, "Beattles ","Y la Amo"));
        
        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new ListaMusica(this, R.layout.listview_item, pista){
			
        	@Override
			public void onEntrada(Object listview_item, View view) {
		        if (listview_item != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Musica) listview_item).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Musica) listview_item).get_textoDebajo()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Musica) listview_item).get_idImagen());
		           
		        }
		        
			}
		});
        
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Musica elegido = (Musica) pariente.getItemAtPosition(posicion); 
                
                CharSequence texto = "Abriendo Pista de: " + elegido.get_textoEncima();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
                nuevo(pariente,view,posicion,id);   
			}
        });
    }    
        public void nuevo(AdapterView<?> pariente, View view, int posicion, long id){
    	Intent intent = new Intent(this, ItemActivity.class );
    	Musica item = (Musica) lista.getAdapter().getItem(posicion);
    	intent.putExtra("imagen",item.get_idImagen());
    	intent.putExtra("debajo",item.get_textoDebajo().toString());
    	intent.putExtra("encima",item.get_textoEncima().toString()); 
    	intent.putExtra("posicion",posicion);
        startActivity(intent);
       
    }	

}


