package com.example.administrator.littletortoisetortoise;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.UnicodeSetSpanner;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.Retrofit.MyRetrofit;
import com.example.administrator.Retrofit.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.switchMinWidth;
import static android.R.attr.type;

/**
 * Created by Administrator on 2017/8/12.
 */

public class IdentifyIDActivity extends AppCompatActivity {
    private static final String TAG ="IdentifyIDActivity";
//    Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch(msg.what){
//                case 0:
//                    Intent intent=new Intent(IdentifyIDActivity.this,CertificateActivity.class);
//                    startActivity(intent);
//                    Toast.makeText(IdentifyIDActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//    };


    @BindView(R.id.iv_id_back)ImageView iv_id_back;
    @BindView(R.id.iv_id_front)ImageView iv_id_front;

    private Uri imageUri;
    public static final int TAKE_PHOTO_FRONT = 1;
    public static final int TAKE_PHOTO_BACK = 2;

    public static final int CHOOSE_PHOTO_FRONT = 3;
    public static final int CHOOSE_PHOTO_BACK  = 4;
    @OnClick(R.id.id_jump)
    public void jump(){

        Intent intent=new Intent(this,CertificateActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_back)
    public  void back(){
        finish();
    }
    @OnClick(R.id.bt_confirm_upload)
    public void upload(){
        //创建ProgressDialog对象
        final ProgressDialog progressDialog = new ProgressDialog(
                IdentifyIDActivity.this);
        //设置进度条风格，风格为圆形，旋转的
        progressDialog.setProgressStyle(
                ProgressDialog.STYLE_SPINNER);
        //设置ProgressDialog 标题
        progressDialog.setTitle("正在上传照片信息");
        //设置ProgressDialog 提示信息
        progressDialog.setMessage("请稍等...");
        //设置ProgressDialog 标题图标
        progressDialog.setIcon(android.R.drawable.btn_star);
        //设置ProgressDialog 的进度条是否不明确
        progressDialog.setIndeterminate(false);
        //设置ProgressDialog 是否可以按退回按键取消
        progressDialog.setCancelable(true);
        //设置取消按钮
//        progressDialog.setButton("取消",
//        new ProgressDialogButtonListener());
//        让ProgressDialog显示
        progressDialog.show();
//        handler.sendEmptyMessageDelayed(0,2000);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://kikipar.imwork.net:29296/")
                .build();
        UserService userService = retrofit.create(UserService.class);
        //组装请求体

//        File file=new File("/mnt/sdcard/pic/01.jpg");//将要保存图片的路径
//        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.pxm);
//        try {
//            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
//            bos.flush();
//            bos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File file = new File(imageUri.getPath());//filePath 图片地址/
        Log.i(TAG,"图片地址为："+imageUri.getPath());
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        builder.addFormDataPart("file", file.getName(), imageBody);
        List<MultipartBody.Part> parts = builder.build().parts();
        Call<ResponseBody> responseBodyCall = userService.upLoadCertificateId(parts);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i(TAG,"上传出图片成功");
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                 Log.e(TAG,"上传图片失败");
                 Log.e(TAG,t.getMessage());
                progressDialog.dismiss();
            }
        });


    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_id);
        ButterKnife.bind(this);
         Mylistener mylistener1=new Mylistener(1);
        Mylistener mylistener2=new Mylistener(2);
        iv_id_front.setOnClickListener(mylistener1);
        iv_id_back.setOnClickListener(mylistener2);

    }


   class Mylistener implements View.OnClickListener{
       //1为正面 2为反面
       int type;
        public Mylistener(int type){
            this.type=type;
        }
       @Override
       public void onClick(View v) {
           AlertDialog.Builder builder=new AlertDialog.Builder(IdentifyIDActivity.this);
           final String[] Items={"拍照","从手机中选取"};
           builder.setItems(Items, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   switch (i){
                       //拍照
                       case 0:
                           File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                           try {
                               if (outputImage.exists()) {
                                   outputImage.delete();
                               }
                               outputImage.createNewFile();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                           if (Build.VERSION.SDK_INT < 24) {
                               imageUri = Uri.fromFile(outputImage);
                           } else {
                               imageUri = FileProvider.getUriForFile(IdentifyIDActivity.this, "com.example.administrator.littletortoisetortoise.fileprovider", outputImage);
                           }
                           // 启动相机程序
                           Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                           intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                           startActivityForResult(intent, type==1?TAKE_PHOTO_FRONT:TAKE_PHOTO_BACK);
                           break;

                       //从照片中获取
                       case 1:
                           if (ContextCompat.checkSelfPermission(IdentifyIDActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                               ActivityCompat.requestPermissions(IdentifyIDActivity.this, new String[]{ Manifest.permission. WRITE_EXTERNAL_STORAGE }, 1);
                           } else {
                               openAlbum(type);
                           }
                           break;

                   }

               }
           });
           builder.setCancelable(true);
           AlertDialog dialog=builder.create();
           dialog.show();
       }
   }




    private void openAlbum(int type) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, type==1?CHOOSE_PHOTO_FRONT:CHOOSE_PHOTO_BACK); // 打开相册
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum(type);
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO_FRONT:
                if (resultCode == RESULT_OK) {
                    try {
                        // 将拍摄的照片显示出来
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        iv_id_front.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case TAKE_PHOTO_BACK:
                if (resultCode == RESULT_OK) {
                    try {
                        // 将拍摄的照片显示出来
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        iv_id_back.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;

            case CHOOSE_PHOTO_FRONT:
                if (resultCode == RESULT_OK) {
                    // 判断手机系统版本号
                    if (Build.VERSION.SDK_INT >= 19) {
                        // 4.4及以上系统使用这个方法处理图片
                        handleImageOnKitKat(data,1);
                    } else {
                        // 4.4以下系统使用这个方法处理图片
                        handleImageBeforeKitKat(data,1);
                    }
                }
                break;
            case CHOOSE_PHOTO_BACK:
                if (resultCode == RESULT_OK) {
                    // 判断手机系统版本号
                    if (Build.VERSION.SDK_INT >= 19) {
                        // 4.4及以上系统使用这个方法处理图片
                        handleImageOnKitKat(data,2);
                    } else {
                        // 4.4以下系统使用这个方法处理图片
                        handleImageBeforeKitKat(data,2);
                    }
                }

                break;

            default:
                break;
        }
    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data ,int type) {
        String imagePath = null;
        Uri uri = data.getData();
        Log.d("TAG", "handleImageOnKitKat: uri is " + uri);
        if (DocumentsContract.isDocumentUri(this, uri)) {
            // 如果是document类型的Uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1]; // 解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // 如果是content类型的Uri，则使用普通方式处理
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            // 如果是file类型的Uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath,type); // 根据图片路径显示图片
    }

    private void handleImageBeforeKitKat(Intent data,int type) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath,type);
    }

    private String getImagePath(Uri uri, String selection) {
        String path = null;
        // 通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath ,int type ) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            switch (type){
                case 1:
                    iv_id_front.setImageBitmap(bitmap);
                    break;
                case 2:
                    iv_id_back.setImageBitmap(bitmap);
                    break;
            }

        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }

}
