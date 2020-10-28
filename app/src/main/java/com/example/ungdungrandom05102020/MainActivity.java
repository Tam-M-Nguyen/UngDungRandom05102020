package com.example.ungdungrandom05102020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //    Khai báo biến ánh xạ
    EditText mEdtMax, mEdtMin;
    Button mBtnRandom;
    TextView mTvResult;
    // Tạo biến hứng giá trị từ View
    String mTxtMin, mTxtMax;
    // Tạo biến hứng giá trị sau đổi kiểu
    int mSMin, mSMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    Gọi hàm ánh xạ
        initView();

        /*
                Kiểm tra nhập liệu:
                + Không được để trống
                + Số min không được lớn hơn hoặc bằng số max
        */

        // Gọi hàm event()
        event();
    }

    //    Cơ cấu hàm ánh xạ
    private void initView() {
        mEdtMin = findViewById(R.id.editTextMin);
        mEdtMax = findViewById(R.id.editTextMax);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mTvResult = findViewById(R.id.textViewResult);
        mSMin = mSMax = -1;
    }

    // Cơ cấu hàm event
    private void event() {

        // Chỉ bắt đầu kiểm tra khi nút Random được click
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Hứng giá trị từ View
                mTxtMin = mEdtMin.getText().toString();
                mTxtMax = mEdtMax.getText().toString();

                // Kiểm tra khung nhập liệu có bị bỏ trống hay không
                if (mTxtMin.length() <= 0 || mTxtMax.length() <= 0) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Kiểm tra xem min có lớn hơn hoặc bằng max hay không
                // Chuyển giá trị từ View sang dạng Integer để tính toán
                mSMin = Integer.parseInt(mTxtMin);
                mSMax = Integer.parseInt(mTxtMax);

                // Tiến hành kiểm tra
                if (mSMin >= mSMax) {
                    mSMax = mSMin + 1;
                }

                // Gán lại giá trị cho View
                mEdtMax.setText(mSMax + "");

            }
        });
    }

}