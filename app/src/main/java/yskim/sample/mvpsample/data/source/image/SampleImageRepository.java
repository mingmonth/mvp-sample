package yskim.sample.mvpsample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import yskim.sample.mvpsample.data.ImageItem;

public class SampleImageRepository implements SampleImageSource {

    private static SampleImageRepository sampleImageRepository;

    public static SampleImageRepository getInstance() {
        if(sampleImageRepository == null) {
            sampleImageRepository = new SampleImageRepository();
        }
        return sampleImageRepository;
    }

    private SampleImageLocalDataSource sampleImageLocalDataSource;

    private SampleImageRepository() {
        sampleImageLocalDataSource = new SampleImageLocalDataSource();
    }

    @Override
    public void getImages(Context context, int size, final LoadImageCallback loadImageCallback) {
        sampleImageLocalDataSource.getImages(context, size, new LoadImageCallback() {
            @Override
            public void onImageLoaded(ArrayList<ImageItem> list) {
                if(loadImageCallback != null) {
                    loadImageCallback.onImageLoaded(list);
                }
            }
        });
    }
}
