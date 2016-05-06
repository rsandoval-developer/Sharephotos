package com.ia.sharephotos.presentation.view;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.activities.LoginActivity;
import com.ia.sharephotos.presentation.view.menu.MenuFragment;
import com.ia.sharephotos.presentation.view.menu.MenuListener;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseActivity extends AppCompatActivity implements MenuListener {

    protected Toolbar mToolbar;
    protected boolean isEnableBack = false;
    protected String mTitle;

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private TextView mNameUser;
    private TextView mEmailUser;
    private ProfilePictureView mPhotoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mPhotoUser=(ProfilePictureView)findViewById(R.id.photo_user);
        mNameUser=(TextView)findViewById(R.id.name_user);
        mEmailUser=(TextView)findViewById(R.id.email_user);

        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.drawer_open, R.string.drawer_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(isEnableBack);
        getSupportActionBar().setHomeButtonEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ico_menu);

        setUpMenu();

        showProfile();
    }

    private void setUpMenu() {
        MenuFragment mMenuFragment = MenuFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_drawer, mMenuFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void closeDrawers() {
        mDrawer.closeDrawers();
    }

    private void showProfile() {
        Profile profile = ((Aplicacion) getApplication()).getProfileFacebook();
        if (profile != null) {
            final GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            try {
                                mPhotoUser.setProfileId(object.getString("id"));
                                mNameUser.setText(object.getString("first_name") + " " + object.getString("last_name"));
                                mEmailUser.setText(object.getString("email"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,first_name,last_name,email,gender");
            request.setParameters(parameters);
            request.executeAsync();
        }else{
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}