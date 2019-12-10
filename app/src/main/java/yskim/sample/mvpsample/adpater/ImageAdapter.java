package yskim.sample.mvpsample.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import yskim.sample.mvpsample.adpater.contract.ImageAdapterContract;
import yskim.sample.mvpsample.adpater.holder.ImageViewHolder;
import yskim.sample.mvpsample.data.ImageItem;
import yskim.sample.mvpsample.listener.OnItemClickListener;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> implements ImageAdapterContract.Model, ImageAdapterContract.View {

    private Context context;
    private OnItemClickListener onItemClickListener;

    private ArrayList<ImageItem> imageItems;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void setOnClickListener(OnItemClickListener clickListener) {
        this.onItemClickListener = clickListener;
    }

    public void setImageItems(ArrayList<ImageItem> imageItems) {
        this.imageItems = imageItems;
    }

//    public void clear() {
//        if(imageItems != null) {
//            imageItems.clear();
//            imageItems = null;
//        }
//    }

//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItems(ArrayList<ImageItem> imageItems) {
        this.imageItems = imageItems;
    }

    @Override
    public void clearItem() {
        if (imageItems != null) {
            imageItems.clear();
        }
    }

    @Override
    public ImageItem getItem(int position) {
        return imageItems.get(position);
    }

    @Override
    public int getItemCount() {
        return imageItems != null ? imageItems.size() : 0;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return new ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false));
        return new ImageViewHolder(context, parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        if (holder == null) return;
        holder.onBind(imageItems.get(position), position);
//        final ImageItem imageItem = imageItems.get(position);
//        new ImageAsync(holder.imageView).execute(imageItem.getImageRes());
    }
}
//    private class ImageAsync extends AsyncTask<Integer, Void, Bitmap> {
//        private final WeakReference<ImageView> imageViewReference;
//
//        ImageAsync(ImageView imageView) {
//            imageViewReference = new WeakReference<>(imageView);
//        }
//
//        @Override
//        protected Bitmap doInBackground(Integer... params) {
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inSampleSize = 2;
//            return BitmapFactory.decodeResource(context.getResources(), params[0], options);
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            imageViewReference.get().setImageResource(0);
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//            super.onPostExecute(bitmap);
//            imageViewReference.get().setImageBitmap(bitmap);
//        }


//    public class ImageViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.img_view)
//        ImageView imageView;
//
//        public ImageViewHolder(View itemView) {
//            super(itemView);
//
//            ButterKnife.bind(this, itemView);
//        }
//    }


