package com.example.hu.dazuoye;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by a1398 on 2018/1/6.
 */

public class TitleActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTitleTextView;
    private Button mBackwardbButton;
    private FrameLayout mContentLayout;
    private LinearLayout mEndView;
    private LinearLayout mLeft;
    private LinearLayout mHome;
    private LinearLayout mRight;
    private ImageButton mLeftImg;
    private ImageButton mHomeImg;
    private ImageButton mRightImg;
    private CharSequence last_title = null;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();  //加载 title_activity 布局，并获取标题和按钮
    }

    private void setupViews() {
        super.setContentView(R.layout.title_activity);
        mTitleTextView = (TextView) findViewById(R.id.text_title);
        mContentLayout = (FrameLayout) findViewById(R.id.layout_title);
        mEndView = (LinearLayout) findViewById(R.id.end_View);
        mBackwardbButton = (Button) findViewById(R.id.button_back_arrow);
        mLeft = (LinearLayout) findViewById(R.id.tab_1);
        mHome = (LinearLayout) findViewById(R.id.tab_2);
        mRight = (LinearLayout) findViewById(R.id.tab_3);
        mLeftImg = (ImageButton) findViewById(R.id.tab_1_img);
        mHomeImg = (ImageButton) findViewById(R.id.tab_2_img);
        mRightImg = (ImageButton) findViewById(R.id.tab_3_img);

    }


    /*
    * 是否显示返回按钮
    *
    * @param backwardResident 文字
    * @param show  true 显示
    *
    * */
    protected void showBackwardView(int backwordResId, boolean show){
        if(mBackwardbButton!=null){
            if (show) {
                mBackwardbButton.setText(backwordResId);
                mBackwardbButton.setVisibility(View.VISIBLE);
            }else{
                mBackwardbButton.setVisibility(View.INVISIBLE);
            }

        }
    }
/*
* 在某些界面使底部导航栏不可见
*
*
* */

    protected void showEndView(boolean show){
        if(mEndView!=null){
            if (show){
                mEndView.setVisibility(View.VISIBLE);
            }else {
                mEndView.setVisibility(View.INVISIBLE);
            }
        }
    }

    /*
    * 返回按钮点击后触发
    *
    * @param forwardView
    *
    * */

    protected void  onBackward(View backwardView){
        //Toast.makeText(this,"调用finish（）",Toast.LENGTH_LONG).show();
        finish();
    }

    //重置底部菜单栏图片并加深当前图片
    public void setBottomImg(String flag){
        switch (flag){
            case "home":
                resetImg();
                mHomeImg.setImageResource(R.drawable.home_1);
                break;
            case "left":
                resetImg();
                mLeftImg.setImageResource(R.drawable.left_1);
                break;
            case "right":
                resetImg();
                mRightImg.setImageResource(R.drawable.right_1);
                break;
            default:
                break;
        }
    }

     /*
    *
    * 获取当前activity名
    *
    *
    * */

    public String get_TopActivity(Activity context)

    {
        ActivityManager manager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        ActivityManager.RunningTaskInfo info = manager.getRunningTasks(1).get(0);
        String shortClassName = info.topActivity.getShortClassName(); //类名
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        String className = info.topActivity.getClassName(); //完整类名
        String packageName = info.topActivity.getPackageName(); //包名
        if (runningTaskInfos != null)
            return (shortClassName).toString();
        else
            return null;
    }

    protected void onHomeward(View homewardView){

        String lei = null;
        lei = get_TopActivity(this);
        //resetImg();
        //mHomeImg.setImageResource(R.drawable.home_1);
        if (lei.equals(".MainActivity")){

        }else{
            startActivity(new Intent(this,MainActivity.class));
        }

        //Toast.makeText(this,"调用finish（）",Toast.LENGTH_SHORT).show();

    }

    protected void onLeftward(View leftwardView){

        String lei = null;
        lei = get_TopActivity(this);
        if(lei.equals(".Login")){

        }else {
            startActivity(new Intent(this,EnvironmentIndex.class));
        }
    }

    protected void onRightward(View rightwardView){

        String lei = null;
        lei = get_TopActivity(this);
        //Toast.makeText(this,lei,Toast.LENGTH_SHORT).show();
        //System.out.println(lei);
        if(lei.equals(".ReCharge") ) {
            //Toast.makeText(this,"butiao",Toast.LENGTH_SHORT).show();
        }else{
            startActivity(new Intent(this, ReCharge.class));
            //Toast.makeText(this,"tiaozhuan",Toast.LENGTH_SHORT).show();
        }
    }

    //设置标题内容

    public void setTitle (int titleId){
        mTitleTextView.setText(titleId);
    }

    //设置标题内容

    public void setTitle (CharSequence title){
        mTitleTextView.setText(title);
        last_title = title;

    }

    //设置标题颜色

    public void setTitleColor (int textColor){
        mTitleTextView.setTextColor(textColor);
    }

    //取出FrameLayout并调用父类removeAllViews()方法


    @Override
    public void setContentView(int layoutResID) {
        mContentLayout.removeAllViews();
        View.inflate(this,layoutResID,mContentLayout);
        onContentChanged();
    }

    @Override
    public void setContentView(View view) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view);
        onContentChanged();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view,params);
        onContentChanged();
    }

    /*
    *
    * 按钮点击调用的方法
    * */

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_back_arrow:
                onBackward(view);
                break;
            case R.id.tab_1:
                onLeftward(view);
                break;
            case R.id.tab_2:
                //Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();
                onHomeward(view);
                break;
            case R.id.tab_3:
                //Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();
                onRightward(view);
                break;
            default:
                break;
        }
    }
    private void resetImg(){
        mLeftImg.setImageResource(R.drawable.left_2);
        mHomeImg.setImageResource(R.drawable.home_2);
        mRightImg.setImageResource(R.drawable.right_2);

    }


    public CharSequence getTitle_1(){
        return last_title;

    }
}
