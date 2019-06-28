package com.example.task1.ui.main.tab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import com.example.task1.R;

public class Fragment2 extends Fragment {

  GridView gridViewImages;

  public int[] imageIDs = new int[]{
      R.drawable.image_01,
      R.drawable.image_02,
      R.drawable.image_03,
      R.drawable.image_04,
      R.drawable.image_05,
      R.drawable.image_06,
      R.drawable.image_07,
      R.drawable.image_08,
      R.drawable.image_09,
      R.drawable.image_10,
  };


  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.layout_fragment2, container, false);

    gridViewImages = (GridView) view.findViewById(R.id.gridViewImages);
    ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this.getContext());
    gridViewImages.setAdapter(imageGridAdapter);

    return view;

  }


}