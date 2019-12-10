package yskim.sample.mvpsample.adpater.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import yskim.sample.mvpsample.R;
import yskim.sample.mvpsample.data.ImageItem;
import yskim.sample.mvpsample.listener.OnItemClickListener;
import yskim.sample.mvpsample.util.ImageAsync;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private Context context;

    private OnItemClickListener onItemClickListener;

    @BindView(R.id.img_view)
    ImageView imageView;

    public ImageViewHolder(Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false));

        this.context = context;
        this.onItemClickListener = onItemClickListener;

        ButterKnife.bind(this, itemView);
    }

    public void onBind(ImageItem item, final int position) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });

        new ImageAsync(context, imageView).execute(item.getImageRes());
    }
}
