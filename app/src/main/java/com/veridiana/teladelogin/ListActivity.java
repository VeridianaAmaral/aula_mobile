package com.veridiana.teladelogin;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.SearchView;

        import com.google.android.material.chip.Chip;

        import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    SearchView searchView_;
    ListView listView;

    ArrayList<banda> arrayList = new ArrayList<>();
    ArrayList<banda> arrayListCopia;
    ArrayList<String> estiloArray;
    ArrayAdapter<banda> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        estiloArray = (ArrayList<String>) intent.getSerializableExtra("esse");

        searchView_ = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView1);

        searchView_.setIconified(false);

        arrayList.add(new banda("Metallica", "Rock"));
        arrayList.add(new banda("Sepultura", "Metal"));
        arrayList.add(new banda("Slayer", "Thrash metal"));
        arrayList.add(new banda("Black Sabbath", "Roque"));
        arrayList.add(new banda("Beatles", "Rock classico"));
        arrayList.add(new banda("Led Zeppelin", "Pop Rock"));
        arrayList.add(new banda("Sandy e Junior", "lo-fi"));

        arrayListCopia = new ArrayList<>(arrayList);

        arrayAdapter = new ArrayAdapter<banda>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(arrayAdapter);

        //filtrando a lista conforme estilo informado na tela 1.
        fazerBuscaTela1();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        searchView_.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //forma 1
                //MainActivity3.this.arrayAdapter.getFilter().filter(s);

                //forma 2
                fazerBusca(s);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void fazerBusca(String s) {

        arrayList.clear();

        s = s.toLowerCase();

        for(banda item: arrayListCopia){
            if(item.toString().toLowerCase().contains(s)){
                arrayList.add(item);
            }
        }
    }

    private void fazerBuscaTela1() {

        arrayList.clear();

        for(String estilo: estiloArray){
            for(banda item: arrayListCopia){
                if(item.toString().contains(estilo)){
                    arrayList.add(item);
                }
            }
        }
        arrayAdapter.notifyDataSetChanged();
    }
}