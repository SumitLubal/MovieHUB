package me.sumeetlubal.moviehub.display.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.sumeetlubal.moviehub.R;

/**
 * Created by SAM on 19-09-2016.
 */
public class GridRecycleViewAdapter extends RecyclerView.Adapter<GridRecycleViewAdapter.ViewHolder> {
    Context mContext;
    GridRecycleViewAdapter(Context context){
        mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.otherscreen_gridview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txt.setText(String.format("Navigation Item #%d", position));
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txt;

        public ViewHolder(final View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt_vp_item_list);
        }
    }

}
