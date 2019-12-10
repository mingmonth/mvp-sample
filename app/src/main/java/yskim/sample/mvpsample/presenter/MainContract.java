package yskim.sample.mvpsample.presenter;

import android.content.Context;

import java.util.ArrayList;

import yskim.sample.mvpsample.data.ImageItem;
import yskim.sample.mvpsample.data.SampleImageData;

public interface MainContract {
    interface View {
        void addItems(ArrayList<ImageItem> items, boolean isClear);
        void notifyAdapter();
    }

    interface Presenter {
        void attachView(View view);
        void detachView();
        void setSampleImageData(SampleImageData sampleImageData);
        void loadItems(Context context, boolean isClear);
    }
}
