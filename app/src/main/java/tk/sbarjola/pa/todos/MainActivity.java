package tk.sbarjola.pa.todos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter myAdapter;
    ListView lista = (ListView) findViewById(R.id.listView); // Lista
    Button boton = (Button) findViewById(R.id.button); //Botón de añadido
    EditText texto = (EditText) findViewById(R.id.editText); //EditText


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();  //Array list
        myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);    //ArrayAdapter
        lista.setAdapter(myAdapter);    //Acoplamos el array al listView a través del adapter

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {//Hacemos el listener
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                myAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        myAdapter.add((String.valueOf(texto.getText())));
        texto.setText("");
    }
}
