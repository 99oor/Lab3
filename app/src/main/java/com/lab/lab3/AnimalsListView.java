package com.lab.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class AnimalsListView extends Activity implements AdapterView.OnItemClickListener{
    private List<Animal> animalList = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list_view);
        initAnimals(); //初始化数据
        SimpleAdapter adapter = new SimpleAdapter(AnimalsListView.this,R.layout.animal_item,animalList);
        ListView listView = (ListView) findViewById(R.id.mylist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    private  void initAnimals(){
        Animal cat = new Animal("Cat",R.drawable.cat);
        animalList.add(cat);
        Animal dog = new Animal("Dog",R.drawable.dog);
        animalList.add(dog);
        Animal elephant = new Animal("Elephant",R.drawable.elephant);
        animalList.add(elephant);
        Animal lion = new Animal("Lion",R.drawable.lion);
        animalList.add(lion);
        Animal monkey = new Animal("Monkey",R.drawable.monkey);
        animalList.add(monkey);
        Animal tiger = new Animal("Tiger",R.drawable.tiger);
        animalList.add(tiger);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //通过view获取其内部的组件，进而进行操作
        String text = (String) ((TextView)view.findViewById(R.id.animal_name)).getText();
        String showText = text ;
        view.setBackgroundResource(R.color.colorPrimaryDark);
        Toast.makeText(this, showText, Toast.LENGTH_LONG).show();
    }
}
