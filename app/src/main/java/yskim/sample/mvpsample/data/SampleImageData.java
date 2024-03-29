package yskim.sample.mvpsample.data;

import android.content.Context;

import java.util.ArrayList;

import yskim.sample.mvpsample.util.Debug;

public class SampleImageData {
    private SampleImageData() {

    }

    private static SampleImageData sampleImageData;

    public static SampleImageData getInstance() {
        if(sampleImageData == null) {
            sampleImageData = new SampleImageData();
        }

        return sampleImageData;
    }

    public ArrayList<ImageItem> getImages(Context context, int size) {
        ArrayList<ImageItem> items = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            int random = (int) (Math.random() * 15);
            if(random == 4) {
                random = 10;
            }
            Debug.logd(new Exception(), "index: " + i + ", random index: " + random);
            final String name = String.format("sample_%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageItem(resource, name));
        }

        return items;
    }
}
