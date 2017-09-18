package com.example.administrator.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */

public class FruitAdaptor extends RecyclerView.Adapter<FruitAdaptor.ViewHolder> {
    private List<Fruit> fruits;
    public static View header;
    public static final int HEADER_NORMAL=0;
    public static final int HEADER=1;
    public static final int NORMAL=2;

    public FruitAdaptor(List<Fruit> fruits) {
        this.fruits = fruits;
    }
    /**
     * 用于把header.xml初始化成view并传进来
     * @param view
     */
    public void setHeader(View view){
        this.header=view;
        notifyItemInserted(0);  //以观察者的模式，如果调用此方法则把position=0的item占用
    }
    /**
     * 如果设置footer,则用此方法
     * @param view
     */
   /* public void setFooter(View view){
        this.footer=view;
        //以观察者的模式，如果调用此方法则把position=getItemCount()-1的item占用
        notifyItemInserted(getItemCount()-1);
    }*/
    /**
     * 得到每个item的类型
     * 1、如果没有header，则返回NORMAL
     * 2、如果有header，且position=0,则返回HEADER
     *                  且position!=0，则返回HEADER_NORMAL
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (header==null){
            return NORMAL;
        }else {
            if (position==0){
                return HEADER;
            }else {
                return HEADER_NORMAL;
            }
        }
    }
    /**
     * 创建item中的viewholder
     * 1、没有header或者有header但是不占用header位置的item正常返回viewholder
     * 2、有header并且position=0的item返回装有header.xml的viewholder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        if (viewType==NORMAL||viewType==HEADER_NORMAL){
            final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit,parent,false);
            final ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
        }else {
            return new ViewHolder(header);
        }
    }
    /**
     * 绑定每个item的数据
     * 1、如果没有header(就是没有执行setHeader方法)，则不执行notifyItemInserted(0)
     * 2、与此相反，执行了notifyItemInserted(0)之后。position=0的item则装上了header.xml，
     *    所以装数据的item的position从1开始（0被header占了）
     * 3、如果有header并且position=0时，则立即返回，结束方法，因为header没有数据可以存取
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position)==NORMAL){
            Fruit fruit=fruits.get(position);
            holder.imageView.setImageResource(fruit.getImageId());
            holder.textView.setText(fruit.getName());
        }else if (getItemViewType(position)==HEADER){
            return;
        }else {
            Fruit fruit=fruits.get(position-1); //有header的情况下position从1开始，所以position-1
            holder.imageView.setImageResource(fruit.getImageId());
            holder.textView.setText(fruit.getName());
        }
    }
    /**
     * 设置总的item数目
     * 1、没有header为fruits.size()
     * 2、有header再加一个header数目，即fruits.size()+1
     * @return
     */
    @Override
    public int getItemCount() {
        if (header!=null){
            return fruits.size()+1;
        }
        return fruits.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView imageView;
        TextView textView;
        /**
         *viewholder的构造函数
         * 1、如果传进来的view是header，则立即返回，结束此方法（因为header的布局与item其他的布局不同）
         * 2、如果传进来的view不是header，则正常存取值
         */
        public ViewHolder(View view1){
            super(view1);
            if (view1==FruitAdaptor.header){
                return;
            }else {
                view=view1;
                imageView=(ImageView)view.findViewById(R.id.image_view);
                textView=(TextView)view.findViewById(R.id.text_view);
            }
        }
    }
}
