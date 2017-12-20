package com.example.android.foodpanda;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Arrays;
import java.util.List;

public class UpdateMenu extends AppCompatActivity {


    private ImageButton mfoodImage;
    private static final int GALLREQ = 1;
    EditText mID, mname, mprice;
    Button mInsert;
    private Uri uri = null;
    private StorageReference storagereference = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);

        mID = (EditText) findViewById(R.id.ID_text);
        mname = (EditText) findViewById(R.id.name_text);
        mprice = (EditText) findViewById(R.id.price_text);
        mInsert = (Button) findViewById(R.id.insert);
        storagereference = FirebaseStorage.getInstance().getReference("Item");





        Button toStart = (Button) findViewById(R.id.previous);
        toStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goStart = new Intent(UpdateMenu.this, MainActivity.class);
                startActivity(goStart);
            }
        });

    }

    public void imageButtonClicked(View view){
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("Image/*");
        startActivityForResult(galleryIntent,GALLREQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLREQ && resultCode == RESULT_OK){
            uri = data.getData();
            mfoodImage = (ImageButton) findViewById(R.id.image_button);
            mfoodImage.setImageURI(uri);
        }
    }

    public void insertButtonClicked(View view){
        String id = mID.getText().toString().trim();
        String name = mname.getText().toString().trim();
        String price = mprice.getText().toString().trim();

        if(!TextUtils.isEmpty(id) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(price)){
            StorageReference filepath = storagereference.child(uri.getLastPathSegment());
            filepath.putFile(uri);/*.addOnSuccessListener(new onSuccessListener<UploadTask.TaskSnapshot>(){
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot){
                    final Uri downloadurl = taskSnapshot.getDownloadUrl();
                    Toast.makeText(UpdateMenu.this,"Image Uploaded",Toast.LENGTH_LONG).show();
                }
            });*/
        }

    }
}

