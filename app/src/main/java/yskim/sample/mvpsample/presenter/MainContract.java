package yskim.sample.mvpsample.presenter;

import android.content.Context;

import java.util.ArrayList;

import yskim.sample.mvpsample.adpater.contract.ImageAdapterContract;
import yskim.sample.mvpsample.data.ImageItem;
import yskim.sample.mvpsample.data.SampleImageData;
import yskim.sample.mvpsample.data.source.image.SampleImageRepository;

public interface MainContract {
    interface View {
//        void addItems(ArrayList<ImageItem> items, boolean isClear);
//        void notifyAdapter();
        void showToast(String title);
    }

    interface Presenter {
        void attachView(View view);
        void detachView();
        void setImageAdapterModel(ImageAdapterContract.Model adapterModel);
        void setImageAdapterView(ImageAdapterContract.View adapterView);
        void setSampleImageData(SampleImageRepository sampleImageData);
        void loadItems(Context context, boolean isClear);
    }
}
