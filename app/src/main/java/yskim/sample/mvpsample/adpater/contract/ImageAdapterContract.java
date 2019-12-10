package yskim.sample.mvpsample.adpater.contract;

import java.util.ArrayList;

import yskim.sample.mvpsample.data.ImageItem;
import yskim.sample.mvpsample.listener.OnItemClickListener;

public interface ImageAdapterContract {
    interface View {
        void setOnClickListener(OnItemClickListener clickListener);
        void notifyAdapter();
    }

    interface Model {
        void addItems(ArrayList<ImageItem> imageItems);
        void clearItem();
        ImageItem getItem(int position);
    }
}
