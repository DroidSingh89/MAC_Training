package com.example.user.retrievingphonecontacts;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.retrievingphonecontacts.manager.ContactManager;
import com.example.user.retrievingphonecontacts.manager.PermissionManager;
import com.example.user.retrievingphonecontacts.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PermissionManager.IPermissionManager {

    private PermissionManager permissionManager;
    private ListView lvContact;
    private ContactManager contactManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContact = findViewById(R.id.lvContacts);

//        check permission
        permissionManager = new PermissionManager(this);
        contactManager = new ContactManager(this);
        permissionManager.checkPermission();


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionManager.checkResult(requestCode, permissions, grantResults);

    }

    public void getPhoneContacts() {


    }

    @Override
    public void onPermissionResult(boolean isGranted) {

        if (isGranted) {

            List<Contact> contactList = contactManager.getContacts();
            ArrayAdapter<Contact> arrayAdapter =
                    new ArrayAdapter<>(
                            this,
                            android.R.layout.simple_list_item_checked,
                            contactList);
            lvContact.setAdapter(arrayAdapter);

        }
    }
}
