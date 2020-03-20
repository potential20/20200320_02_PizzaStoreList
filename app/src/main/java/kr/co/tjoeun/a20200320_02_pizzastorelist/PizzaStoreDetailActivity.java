package kr.co.tjoeun.a20200320_02_pizzastorelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;

import kr.co.tjoeun.a20200320_02_pizzastorelist.databinding.ActivityPizzaStoreDetailBinding;
import kr.co.tjoeun.a20200320_02_pizzastorelist.datas.PizzaStore;

public class PizzaStoreDetailActivity extends BaseActivity {

    PizzaStore store = null;
    ActivityPizzaStoreDetailBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_pizza_store_detail);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                가게의 전화번호를 => CALL 액션으로 연결.

                String phoneNumUri = String.format("tel:%s",store.getPhoneNum());

                Uri uri = Uri.parse(phoneNumUri);
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);

            }
        });

    }

    @Override
    public void setValues() {

        store = (PizzaStore) getIntent().getSerializableExtra("store");

        binding.storeNameTxt.setText(store.getStoreName());
        binding.storePhoneTxt.setText(store.getPhoneNum());
        Glide.with(mContext).load(store.getLogoUrl()).into(binding.storeLogoImg);

    }
}
