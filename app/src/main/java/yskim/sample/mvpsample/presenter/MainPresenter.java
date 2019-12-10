package yskim.sample.mvpsample.presenter;

import android.content.Context;

import java.util.ArrayList;

import yskim.sample.mvpsample.data.ImageItem;
import yskim.sample.mvpsample.data.SampleImageData;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    private SampleImageData sampleImageData;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setSampleImageData(SampleImageData sampleImageData) {
        this.sampleImageData = sampleImageData;
    }

    @Override
    public void loadItems(Context context, boolean isClear) {
        ArrayList<ImageItem> items = sampleImageData.getImages(context, 10);
        view.addItems(items, isClear);
        view.notifyAdapter();
    }
}
