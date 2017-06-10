package com.example.administrator.yn_yuzhilai.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.zhi_play.PayResult;
import com.example.administrator.yn_yuzhilai.zhi_play.PayUtils;

import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;

import static android.R.attr.order;

/**
 * 作者：仝晓雅 on 2017/6/6 09:00
 * 类的注释：
 */

public class ZhiFuActivity extends Activity {
    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.z_price)
    TextView zPrice;
    @Bind(R.id.z_ping)
    CheckBox zPing;
    @Bind(R.id.z_yu)
    TextView zYu;
    @Bind(R.id.z_yus)
    CheckBox zYus;
    @Bind(R.id.z_chong)
    TextView zChong;
    @Bind(R.id.z_wei)
    CheckBox zWei;
    @Bind(R.id.z_zhi)
    CheckBox zZhi;
    @Bind(R.id.z_yes)
    TextView zYes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhi_main);
        ButterKnife.bind(this);
        iText.setText("支付结算");
        Intent intent =getIntent();
        int jiage = intent.getIntExtra("jiage", -1);
        zPrice.setText("￥ " +jiage);



    }
    //写个静态的内部类Handler
    public  static class MyHandler extends Handler {
        //创建弱引用
        WeakReference<Context> weakReference = null;

        public MyHandler(Context context) {
            weakReference = new WeakReference<>(context);

        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //当不为null是进行操作
            if(weakReference.get()!=null){
                if(msg.what==0){
                    // 同步返回需要验证的信息
                    PayResult payResult = new PayResult((String) msg.obj);
                    String resultStatus = payResult.getResultStatus();
                    if(TextUtils.equals(resultStatus, "9000")){
                        Toast.makeText(weakReference.get(), "支付成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(weakReference.get(), "支付不成功", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }
    }

    @OnClick({R.id.i_fan, R.id.i_text, R.id.z_price, R.id.z_ping, R.id.z_yu, R.id.z_yus, R.id.z_chong, R.id.z_wei, R.id.z_zhi, R.id.z_yes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                Intent in = new Intent();
                ZhiFuActivity.this.setResult(30, in);
                finish();
                break;
            case R.id.i_text:
                break;
            case R.id.z_price:
                break;
            case R.id.z_ping:
                zPing.setChecked(true);
                zWei.setChecked(false);
                zZhi.setChecked(false);
                zYus.setChecked(false);
                break;
            case R.id.z_yu:
                break;
            case R.id.z_yus:
                zPing.setChecked(false);
                zWei.setChecked(false);
                zZhi.setChecked(false);
                zYus.setChecked(true);
                break;
            case R.id.z_chong:
                Intent intent =new Intent(ZhiFuActivity.this,ChongActivity.class);
                startActivity(intent);
                break;
            case R.id.z_wei:
                zPing.setChecked(false);
                zWei.setChecked(true);
                zZhi.setChecked(false);
                zYus.setChecked(false);
                break;
            case R.id.z_zhi:
                zPing.setChecked(false);
                zWei.setChecked(false);
                zZhi.setChecked(true);
                zYus.setChecked(false);
                break;
            case R.id.z_yes:
                if (zPing.isChecked()){
                    Toast.makeText(this, "苹果支付", Toast.LENGTH_SHORT).show();
                }else if (zWei.isChecked()){
                    Toast.makeText(this, "微信支付", Toast.LENGTH_SHORT).show();
                }else if (zZhi.isChecked()){
                    Toast.makeText(this, "支付宝支付", Toast.LENGTH_SHORT).show();
                   PayZFB();
                }else if (zYus.isChecked()){
                    Toast.makeText(this, "余额支付", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    MyHandler myHandler=new MyHandler(ZhiFuActivity.this);
    //支付宝的方法
    private void PayZFB() {
        //拿到订单号
        //获得订单信息
        String orderInfo = PayUtils.getOrderInfo("预知来测试", "单号:"+order, "0.01");
        //进行加密签名
        String sign = PayUtils.sign(orderInfo);
        //通过URLEncoder进行编码
        try {
            sign = URLEncoder.encode(sign, "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //进行一个参数分拼接
        StringBuffer sb=new StringBuffer(orderInfo);
        sb.append("&sign=\"");
        sb.append(sign);
        sb.append("\"&");
        //设置签名的类型
        sb.append(PayUtils.getSignType());
        //获得最终的支付信息,完整的符合支付宝参数规范的订单信息
        final String payInfo = sb.toString();
        //开启子线程去调起支付宝的API
        Runnable payRunnable=new Runnable() {
            @Override
            public void run() {
                //支付宝的API，构造PayTask 对象
                PayTask alipay = new PayTask(ZhiFuActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo,true);
                //获得支付宝同步返回的结果
                Log.i("result",result.toString());
                //需要通过发送Message给主线程更新UI
                Message message = myHandler.obtainMessage(0, result);
                //发送
                message.sendToTarget();
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }

    /*private void ZFB(){
        //到服务器进行订单加密
        //进行网络请求
        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.LOCAL_URL);
        // Flowable<String> flowable = server.getService("测试", order, "0.01");
        Flowable<String> flowable = server.getPay("测试", order, "0.01");
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<String>() {
                    @Override
                    public void onNext(String s) {
                        Log.i("service_s",s.toString());

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("Throwable",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }*/
}
