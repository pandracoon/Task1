package com.example.task1.ui.main.tab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.task1.R;

public class ImageActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tab2_imageview);

    ImageView imageView = (ImageView) findViewById(R.id.imageView);
    setImage(imageView);
  }

  private void setImage(ImageView imageView){
    Intent receivedIntent = getIntent();

    int imageID=(Integer) receivedIntent.getExtras().get("image ID");
    imageView.setImageResource(imageID);
  }
}
