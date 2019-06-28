package com.example.task1.ui.main.Tab1;


import android.app.ProgressDialog;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.R;
import com.example.task1.ui.main.Tab1.adapter.ContactAdapter;
import com.example.task1.ui.main.Tab1.model.ContactList;

import java.util.ArrayList;

import static com.example.task1.MainActivity.getContextOfApplication;

public class Fragment1 extends Fragment {

  RecyclerView recyclerView;
  ContactAdapter adapter = new ContactAdapter(getContextOfApplication());

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.layout_fragment1, container, false);

    recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    LoadContactsAsync lca = new LoadContactsAsync();
    lca.execute();
    return view;
  }

  class LoadContactsAsync extends AsyncTask<Void, Void, ArrayList<ContactList>> {
    ProgressDialog pd;

    @Override
    protected void onPreExecute() {
      // TODO Auto-generated method stub
      super.onPreExecute();

      pd = ProgressDialog.show(Fragment1.this.getContext(), "Loading Contacts", "Please Wait");
    }

    @Override
    protected ArrayList<ContactList> doInBackground(Void... params) {
      // TODO Auto-generated method stub
      ArrayList<ContactList> contacts = new ArrayList<>();
      Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
      String[] projection = new String[]{
              ContactsContract.CommonDataKinds.Phone.NUMBER,
              ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
              ContactsContract.Contacts.PHOTO_ID,
              ContactsContract.Contacts._ID
      };

      String[] selectionArgs = null;

      Cursor c = getActivity().getContentResolver().query(uri, projection, null, null, null);
      assert c != null;
      while (c.moveToNext()) {
          long photo_id = c.getLong(2);
          long person = c.getLong(3);
          String contactName = c.getString(1);
          String phNumber = c.getString(0);
          contacts.add(new ContactList(contactName, phNumber, "KOREA", person, photo_id));
      }
      adapter.setItems(contacts);
      c.close();
      return contacts;
    }

    @Override
    protected void onPostExecute(ArrayList<ContactList> contacts) {
      // TODO Auto-generated method stub
      super.onPostExecute(contacts);

      pd.cancel();

      recyclerView.setAdapter(adapter);
    }
  }
}