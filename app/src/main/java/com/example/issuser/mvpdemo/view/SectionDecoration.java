package com.example.issuser.mvpdemo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.issuser.mvpdemo.R;

import java.util.List;



/**
 * Created by issuser on 2018/4/3.
 */

public class SectionDecoration extends RecyclerView.ItemDecoration {

    private List<String> list;
    private TextPaint textPaint;
    private Paint paint;
    private int topGap;
    private int alignBottom;
    private Paint.FontMetrics fontMetrics;
    private DecorationCallback callback;


    public SectionDecoration(List<String> list, Context context,DecorationCallback callback){
        Resources res=context.getResources();
        this.list=list;
        this.callback=callback;
        paint =new Paint();
        paint.setColor(res.getColor(R.color.colorPrimary));

        textPaint=new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize(30);
        fontMetrics = new Paint.FontMetrics();

        topGap=res.getDimensionPixelOffset(R.dimen.sectioned_top);
        alignBottom=res.getDimensionPixelOffset(R.dimen.sectioned_alignBottom);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos=parent.getChildAdapterPosition(view);

        String groupId =callback.getGroupId(pos);
        if(groupId.equals("-1")) return;
        if (pos == 0 || isFirstInGroup(pos)) {
            outRect.top = topGap;
            if (list.get(pos) == "") {
                outRect.top = 0;
            }
        } else {
            outRect.top = 0;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View view =parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            String groupId = callback.getGroupId(position);
            if (groupId.equals("-1")) return;
            String textLine = callback.getGroupFirstLine(position).toUpperCase();
            if (textLine == "") {
                float top = view.getTop();
                float bottom = view.getTop();
                c.drawRect(left, top, right, bottom, paint);
                return;
            } else {
                if (position == 0 || isFirstInGroup(position)) {
                    float top = view.getTop() - topGap;
                    float bottom = view.getTop();
                    //绘制悬浮栏
                    c.drawRect(left, top, right, bottom, paint);
                    //绘制文本
                    c.drawText(textLine, left, bottom, textPaint);
                }
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int itemCount=state.getItemCount();
        int childCount=parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        float lineHeight = textPaint.getTextSize() + fontMetrics.descent;
        String preGroupId = "";
        String groupId = "-1";

        for(int i=0;i<childCount;i++){
            View view =parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            preGroupId = groupId;
            groupId = callback.getGroupId(position);
            if (groupId.equals("-1") || groupId.equals(preGroupId)) continue;
            String textLine = callback.getGroupFirstLine(position).toUpperCase();
            if (TextUtils.isEmpty(textLine)) continue;

            int viewBottom=view.getBottom();
            float textY = Math.max(topGap, view.getTop());
            Log.e("yzh",viewBottom+"---"+textY);
            //下一个和当前不一样移动当前
            if (position + 1 < itemCount) {
                String nextGroupId = callback.getGroupId(position + 1);
                //组内最后一个view进入了header
                if (nextGroupId != groupId && viewBottom < textY) {
                    textY = viewBottom;
                }
            }
//            Log.e("yzh",i+"---"+textLine+"---"+(textY-topGap)+"----"+textY);
            //textY - topGap决定了悬浮栏绘制的高度和位置
            c.drawRect(left, textY - topGap, right, textY, paint);
            //left+2*alignBottom 决定了文本往左偏移的多少（加-->向左移）
            //textY-alignBottom  决定了文本往右偏移的多少  (减-->向上移)
//            c.drawText(textLine, left + 2 * alignBottom, textY - alignBottom, textPaint);
            c.drawText(textLine, left, textY - alignBottom, textPaint);
        }
    }

    private boolean isFirstInGroup(int pos){
        if(pos==0){
            return true;
        }else{
            String prevGroupId = callback.getGroupId(pos - 1);
            String groupId = callback.getGroupId(pos);
            if (prevGroupId.equals(groupId)) {
                return false;
            } else {
                return true;
            }
        }
    }



    public interface DecorationCallback{
        String getGroupId(int position);
        String getGroupFirstLine(int position);
    }

}
