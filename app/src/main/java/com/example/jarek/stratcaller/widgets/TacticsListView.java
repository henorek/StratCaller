package com.example.jarek.stratcaller.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jarek.stratcaller.R;
import com.example.jarek.stratcaller.data.TacticsDAO;
import com.example.jarek.stratcaller.data.TacticsEntity;

import java.util.List;

public abstract class TacticsListView {

    private static final int[] COLUMNS_SHORT = {R.id.tactic_title,R.id.he_amount,R.id.flash_amount,R.id.smoke_amount,R.id.molotov_amount,R.id.decoy_amount};

    public static int[] getColumnsShort() {
        return COLUMNS_SHORT;
    }

}
