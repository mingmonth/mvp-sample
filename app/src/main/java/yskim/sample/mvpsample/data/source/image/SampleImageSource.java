package yskim.sample.mvpsample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import yskim.sample.mvpsample.data.ImageItem;

public interface SampleImageSource {

    interface LoadImageCallback {
        // 이미지 아이템을 리턴하는 콜백메소드 정의
        void onImageLoaded(ArrayList<ImageItem> list);
    }

    void getImages(Context context, int size, LoadImageCallback loadImageCallback);
}
