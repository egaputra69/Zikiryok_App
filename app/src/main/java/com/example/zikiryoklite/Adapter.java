package com.example.zikiryoklite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {

    // Mendefinisikan variabel
    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    // Membuat constructor Adapter
    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    // Membaca ukuran dari models
    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container,false);

        TextView title, sentence;

        title = view.findViewById(R.id.title);
        sentence = view.findViewById(R.id.sentence);

        title.setText(models.get(position).getTitle());
        sentence.setText(models.get(position).getSentence());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
