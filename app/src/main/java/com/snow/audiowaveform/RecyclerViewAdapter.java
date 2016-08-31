package com.snow.audiowaveform;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.maxproj.simplewaveform.SimpleWaveform;

import java.util.LinkedList;

/**
 * @author axue
 * @date 2016/8/28 21:16
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    // List<LvRowFile> listItems;
    LinkedList<LinkedList<Integer>> amp_list_list;

    public RecyclerViewAdapter(LinkedList<LinkedList<Integer>> amp_list_list) {
        this.amp_list_list = amp_list_list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public SimpleWaveform simpleWaveform;

        public ViewHolder(View itemView) {
            super(itemView);
            this.simpleWaveform = (SimpleWaveform) itemView
                    .findViewById(R.id.simplewaveform_row);
//                this.simpleWaveform.clearScreen();
        }
    }


    @Override
    public int getItemCount() {
        Log.d("", "SimpleWaveform: amp_list_list.size() " + amp_list_list.size());
        return amp_list_list.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("", "SimpleWaveform: position " + position);
        holder.simpleWaveform.setDataList(amp_list_list.get(position));

        holder.simpleWaveform.barPencilSecond.setStrokeWidth(5);
        holder.simpleWaveform.barPencilSecond.setColor(0xff1dcfcf);

        holder.simpleWaveform.peakPencilSecond.setStrokeWidth(5);
        holder.simpleWaveform.peakPencilSecond.setColor(0xfffeef3f);//0xfffeef3f

        //show x-axis
        holder.simpleWaveform.showXAxis = true;
        holder.simpleWaveform.xAxisPencil.setStrokeWidth(5);
        holder.simpleWaveform.xAxisPencil.setStrokeWidth(0x88ffffff);

        holder.simpleWaveform.refresh();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),
                R.layout.row_recycler, null);
        ViewHolder holder = new ViewHolder(view);
        Log.d("", "SimpleWaveform: onCreateViewHolder ");
        return holder;
    }

}
