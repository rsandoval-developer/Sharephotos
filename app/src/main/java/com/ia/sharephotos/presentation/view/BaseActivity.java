package com.ia.sharephotos.presentation.view;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.menu.MenuFragment;
import com.ia.sharephotos.presentation.view.menu.MenuListener;

public class BaseActivity extends AppCompatActivity implements MenuListener {

    protected Toolbar mToolbar;
    protected boolean isEnableBack = false;
    protected String mTitle;

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(isEnableBack);
        mToolbar.setNavigationIcon(R.drawable.ico_menu);

        setUpMenu();
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
}