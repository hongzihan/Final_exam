package com.example.hu.finalexam.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hu.finalexam.R;
import com.example.hu.finalexam.db.dao.UserDao;

/**
 * Created by a1398 on 2018/1/6.
 */

public class ReCharge extends TitleActivity {
    private EditText mEditText;
    private TextView mPayForTv;
    private boolean flag;
    EditText recharge_account;
//    Button pay_btn_10;
//    Button pay_btn_20;
//    Button pay_btn_30;
//    Button pay_btn_50;
//    Button pay_btn_100;
//    Button pay_btn_200;
//    Button pay_btn_300;
//    Button pay_btn_500;
//    Button pay_btn_1000;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recharge);
        recharge_account = (EditText) findViewById(R.id.recharge_account);
        mPayForTv = (TextView) findViewById(R.id.pay_For_Tv);
        flag = true;
        //CharSequence title = null;
        //title = getTitle_1();
        //showBackwardView(title,true);
        setTitle("小车充值");

        setBottomImg("right");

//        pay_btn_10 = (Button) findViewById(R.id.pay_btn_10);
//        pay_btn_20 = (Button) findViewById(R.id.pay_btn_20);
//        pay_btn_30 = (Button) findViewById(R.id.pay_btn_30);
//        pay_btn_50 = (Button) findViewById(R.id.pay_btn_50);
//        pay_btn_100 = (Button) findViewById(R.id.pay_btn_100);
//        pay_btn_200 = (Button) findViewById(R.id.pay_btn_200);
//        pay_btn_300 = (Button) findViewById(R.id.pay_btn_300);
//        pay_btn_500 = (Button) findViewById(R.id.pay_btn_500);
//        pay_btn_1000 = (Button) findViewById(R.id.pay_btn_500);
    }



    /**
     * made by ken
     * 2017/1/9
     * 充值方法
     */
    public void reCharge(View view){
        String account = recharge_account.getText().toString().trim();
        UserDao udao = new UserDao(this);
        Integer canRecharge;
        switch (view.getId()) {
            case R.id.pay_btn_10:
                Integer pay_btn_10 = 10;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+10 > 5000){
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_10);
                    Toast.makeText(this, "成功充值10元", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.pay_btn_20:
                Integer pay_btn_20 = 20;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+20 > 5000){
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_20);
                    Toast.makeText(this, "成功充值20元", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.pay_btn_30:
                Integer pay_btn_30 = 30;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+30 > 5000){
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_30);
                    Toast.makeText(this, "成功充值30元", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.pay_btn_50:
                Integer pay_btn_50 = 50;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+50 > 5000){
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_50);
                    Toast.makeText(this, "成功充值50元", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.pay_btn_100:
                Integer pay_btn_100 = 100;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+100 > 5000) {
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_100);
                    Toast.makeText(this, "成功充值100元", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.pay_btn_200:
                Integer pay_btn_200 = 200;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+200 > 5000){
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_200);
                    Toast.makeText(this, "成功充值200元", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.pay_btn_300:
                Integer pay_btn_300 = 300;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+300 > 5000){
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_300);
                    Toast.makeText(this, "成功充值300元", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.pay_btn_500:
                Integer pay_btn_500 = 500;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+500 > 5000){
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_500);
                    Toast.makeText(this, "成功充值500元", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.pay_btn_1000:
                Integer pay_btn_1000 = 1000;
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(this,"请先输入您需要充值的手机账号",Toast.LENGTH_SHORT).show();
                }else if(udao.findBalance(account)+1000 > 5000){
                    canRecharge = 5000 - udao.findBalance(account);
                    Toast.makeText(this, "余额上限为5000，您当前还可充值" + canRecharge + "元", Toast.LENGTH_SHORT).show();
                }else if(udao.reCheckAccount(account)){
                    Toast.makeText(this,"该账户不存在",Toast.LENGTH_SHORT).show();
                }else{
                    udao.reCharge(account, pay_btn_1000);
                    Toast.makeText(this, "成功充值1000元", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;

        }
    }
}
