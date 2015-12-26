package pl.lukmarr.magicstories;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Łukasz Marczak
 *
 * @since 26.12.15
 */
public class NEW extends RecyclerView.Adapter<NEW.VH> {
    public List<Pair<String, String>> titles = new ArrayList<>();

    public interface Listener {
        void onClick(int position, String s);
    }

    Listener listener;

    public NEW(List<Pair<String, String>> ss, Listener listener) {
        titles.addAll(ss);
        this.listener = listener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new VH(view);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    @Override
    public void onBindViewHolder(VH vh, final int i) {

        if (i == WebViewActivity.lastClickedChapter) {
            vh.tV.setTextColor(Color.BLACK);
        } else {
            vh.tV.setTextColor(Color.GRAY);
        }

        vh.tV.setText(titles.get(i).second);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(i, titles.get(i).first);
                notifyDataSetChanged();
            }
        });
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tV;

        public VH(View itemView) {
            super(itemView);
            tV = (TextView) itemView.findViewById(R.id.tV);
        }
    }
}
