package yskim.sample.mvpsample.presenter;

import android.content.Context;

import java.util.ArrayList;

import yskim.sample.mvpsample.adpater.contract.ImageAdapterContract;
import yskim.sample.mvpsample.data.ImageItem;
import yskim.sample.mvpsample.data.SampleImageData;
import yskim.sample.mvpsample.data.source.image.SampleImageRepository;
import yskim.sample.mvpsample.data.source.image.SampleImageSource;
import yskim.sample.mvpsample.listener.OnItemClickListener;

public class MainPresenter implements MainContract.Presenter, OnItemClickListener {

    private MainContract.View view;
    private SampleImageRepository sampleImageData;

    private ImageAdapterContract.Model adapterModel;
    private ImageAdapterContract.View adapterView;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setSampleImageData(SampleImageRepository sampleImageData) {
        this.sampleImageData = sampleImageData;
    }

    @Override
    public void loadItems(Context context, final boolean isClear) {
        sampleImageData.getImages(context, 10, new SampleImageSource.LoadImageCallback() {
            @Override
            public void onImageLoaded(ArrayList<ImageItem> list) {
                if(list != null) {
                    if(isClear) {
                        adapterModel.clearItem();
                    }
                    adapterModel.addItems(list);
                    adapterView.notifyAdapter();
                    //        view.addItems(items, isClear);
                    //        view.notifyAdapter();
                }
            }
        });
    }

    @Override
    public void setImageAdapterModel(ImageAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setImageAdapterView(ImageAdapterContract.View adapterView) {
        this.adapterView = adapterView;
        this.adapterView.setOnClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        ImageItem imageItem = adapterModel.getItem(position);
        view.showToast(imageItem.getTitle());
    }
}
