package com.hfad.workout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WorkoutListFragment extends ListFragment {

//Добавляет слушателя к фрагменту
    static interface Listener {
        void itemClicked(long id);
    }

    private Listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Создать строковый массив с названиями комплексов упражнений
        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }

        //Создать адаптер массива
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                names);

        //Связать адаптер массива со списковым представлением
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //Вызывается когда фрагмент связывается с активностью
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    //Сообщает слушателю, когда пользователь выбрал вариант в ListView
    @Override
    public void onListItemClick(ListView listView,  View itemView, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}