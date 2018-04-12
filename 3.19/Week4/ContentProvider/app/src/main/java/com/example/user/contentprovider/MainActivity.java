package com.example.user.contentprovider;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.user.contentprovider.manager.ContactManager;
import com.example.user.contentprovider.manager.PermissionManager;
import com.example.user.contentprovider.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements PermissionManager.IPermissionManager,
        ContactManager.IContactManager {


    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 10;
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    PermissionManager permissionManager;
    private ContactManager contactManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionManager = new PermissionManager(this);
        contactManager = new ContactManager(this);

        permissionManager.checkPermission();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        permissionManager.checkResult(requestCode, permissions, grantResults);

    }


    @Override
    public void onPermissionResult(boolean isGranted) {
        if (isGranted) {
            contactManager.getContacts();
        }
    }

    @Override
    public void onContactsReceived(List<Contact> contactsList) {

        Toast.makeText(this, contactsList.toString(), Toast.LENGTH_SHORT).show();
    }
}