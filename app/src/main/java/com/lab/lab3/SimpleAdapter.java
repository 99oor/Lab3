package com.lab.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;

import java.util.List;

public class SimpleAdapter extends ArrayAdapter {
    private final int resourceId;

    public SimpleAdapter(Context context, int textViewResourceId, List<Animal> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Animal animal = (Animal)getItem(position);//获取当前的Animal实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        ImageView av = (ImageView)view.findViewById(R.id.animal_image);//获取该布局内的图片视图
        TextView tv = (TextView)view.findViewById(R.id.animal_name);//获取该布局内的文本视图
        av.setImageResource(animal.getImageId());//为图片视图设置图片资源
        tv.setText(animal.getName());//为文本视图设置文本内容

        return view;

    }
}
