package com.chad.baserecyclerviewadapterhelper.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionMultipleItem extends SectionMultiEntity<Video> implements MultiItemEntity {

    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;

    public static final int GROUP_HEADER_1 = 4;
    public static final int GROUP_HEADER_2 = 5;

    private int itemType;
    private boolean isMore;
    private Video video;

    //    组头数据的构造方法
    public SectionMultipleItem(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
    }


    //    组头数据的构造方法
    public SectionMultipleItem(boolean isHeader,int itemType, String header, boolean isMore) {
        super(isHeader, header);
        this.itemType = itemType;
        this.isMore = isMore;
    }
    //   组item数据的构造方法
    public SectionMultipleItem(int itemType, Video video) {
        super(video);
        this.video = video;
        this.itemType = itemType;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
