package com.example.yuanping.todolist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yuanping.todolist.R;
import com.example.yuanping.todolist.bean.Events;

import org.w3c.dom.Text;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Events> mEvents;
    private Context mContext;
    public static final int COMMON_EVENTS = 1;
    public static final int FOOTER_EVENTS = 0;
    private OnItemClickListener mOnItemClickListener = null;

    public MainRecyclerViewAdapter(List<Events> events, Context context) {
        mEvents = events;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FOOTER_EVENTS) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_footer_fragment,
                    parent, false);
            return new FooterViewHolder(view);
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main_fragment, parent,
                false);
        return new CommViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == COMMON_EVENTS) {
            final CommViewHolder temp = (CommViewHolder) holder;
            temp.title.setText(mEvents.get(position).getTitle());
            temp.subTitle.setText(mEvents.get(position).getContent());
            temp.isComplete.setImageResource(mEvents.get(position).isComplete() ? R.drawable
                    .complete : R.drawable.uncomplete);
            temp.isComplete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mEvents.get(position).setComplete(!mEvents.get(position).isComplete());
                    temp.isComplete.setImageResource(mEvents.get(position).isComplete() ? R
                            .drawable.complete : R.drawable.uncomplete);
                }
            });
            temp.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null)
                        mOnItemClickListener.onCommItemClick(position);
                }
            });
        } else {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null)
                        mOnItemClickListener.onFootItemClick();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mEvents.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= mEvents.size())
            return FOOTER_EVENTS;
        return COMMON_EVENTS;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onCommItemClick(int pos);

        void onFootItemClick();
    }

    class CommViewHolder extends RecyclerView.ViewHolder {
        private ImageView isComplete;
        private TextView title;
        private TextView subTitle;

        public CommViewHolder(View itemView) {
            super(itemView);
            isComplete = itemView.findViewById(R.id.is_complete);
            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.sub_title);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
