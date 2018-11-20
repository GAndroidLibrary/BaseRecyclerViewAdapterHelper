package com.chad.baserecyclerviewadapterhelper.adapter;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.MultipleItem;
import com.chad.baserecyclerviewadapterhelper.entity.SectionMultipleItem;
import com.chad.library.adapter.base.BaseSectionMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 * 
 */
public class SectionMultipleItemAdapter extends BaseSectionMultiItemQuickAdapter<SectionMultipleItem, BaseViewHolder> {
    /**
     * init SectionMultipleItemAdapter
     * 1. add your header resource layout
     * 2. add some kind of items
     *
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionMultipleItemAdapter(int sectionHeadResId, List data) {
        super(sectionHeadResId, data);

        addItemType(SectionMultipleItem.GROUP_HEADER_1, R.layout.header_text_view_1);
        addItemType(SectionMultipleItem.GROUP_HEADER_2, R.layout.header_text_view_2);
//        添加了两个Layout，可根据item的内容（ItemViewType）设置不同的layout，
        addItemType(SectionMultipleItem.TEXT, R.layout.item_text_view);
        addItemType(SectionMultipleItem.IMG_TEXT, R.layout.item_img_text_view);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final SectionMultipleItem item) {
        // deal with header viewHolder
//        helper.setText(R.id.header, item.header);
////        如果 head item的isMore 是特殊的，就显示某内容
//        helper.setVisible(R.id.more, item.isMore());
//        helper.addOnClickListener(R.id.more);

        switch (helper.getItemViewType()) {
            case SectionMultipleItem.GROUP_HEADER_1:
                helper.setText(R.id.tv, item.header);
                break;
            case SectionMultipleItem.GROUP_HEADER_2:
                helper.setText(R.id.tv, item.header);
                break;
            default:
                break;
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, SectionMultipleItem item) {
        // deal with multiple type items viewHolder
        helper.addOnClickListener(R.id.card_view);
//      item的数据中设置了itemView（layout）的类型，所以可以实现不同Layout的页面
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv, item.getVideo().getName());
                break;
            case MultipleItem.IMG_TEXT:
                switch (helper.getLayoutPosition() % 2) {
                    case 0:
                        helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                        break;
                    case 1:
                        helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }
}
