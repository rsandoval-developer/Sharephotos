package com.ia.sharephotos.presentation.view.fragments.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.Aplicacion;
import com.ia.sharephotos.presentation.view.BaseFragment;
import com.ia.sharephotos.presentation.view.activities.HomeActivity;
import com.ia.sharephotos.presentation.view.fragments.login.Interfaces.IFacebookView;
import com.ia.sharephotos.presentation.view.fragments.login.Interfaces.IGoogleView;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements GoogleApiClient.OnConnectionFailedListener, IFacebookView, IGoogleView,  View.OnClickListener {

    private ImageView mFondoLogin;
    private LoginButton loginButton;
    private Facebook facebook;
    private AOuth mAOuth;
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;

    public static LoginFragment newInstance() {
        return  new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        facebook = new Facebook(getActivity(), this);
        mAOuth =new AOuth(getActivity(),this);
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        mFondoLogin=(ImageView)view.findViewById(R.id.fondo);

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        facebook.onInitFacebook(loginButton);

        view.findViewById(R.id.sign_in_button).setOnClickListener(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .enableAutoManage(getActivity() /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        SignInButton signInButton = (SignInButton) view.findViewById(R.id.sign_in_button);


        mAOuth.onInitAOuth(signInButton,gso,mGoogleApiClient);

        setImageContentLogin();

        return view;
    }

    private void setImageContentLogin(){
        Glide.with(getActivity()).load(R.drawable.fondo_login)
                .bitmapTransform(new BlurTransformation(getActivity(),25), new CropSquareTransformation(getActivity()))
                .into(mFondoLogin);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAOuth.onStartAOuth();
    }

    @Override
    public void onResume() {
        super.onResume();
        facebook.onResumeFacebook();
    }

    @Override
    public void onPause() {
        super.onPause();
        facebook.onPauseFacebook();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        facebook.onDestroyFacebook();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = data;
        facebook.onActivityResult(requestCode, resultCode, data);
        mAOuth.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onErrorLoginFacebook(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGetProfileFacebook(Profile profile) {
        boolean enableButtons = AccessToken.getCurrentAccessToken() != null;
        if (enableButtons && profile != null) {

            //TODO: GUARDAR EN LA APLICACION EL PERFIL DE USUARIO
            ((Aplicacion) getActivity().getApplication()).setProfileFacebook(profile);

            nextActivity();
        }
    }

    @Override
    public void onErrorLoginAOuth(String error) {

    }

    @Override
    public void onGetProfileAOuth(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            ((Aplicacion) getActivity().getApplication()).setGoogleSignInAccount(acct);
            nextActivity();
        } else {
            // Signed out, show unauthenticated UI.
        }
    }

    @Override
    public void onSignInAOth() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onSignOutAOth() {

    }

    @Override
    public void onRevokeAccess() {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                mAOuth.onSignInAOth();
                break;

        }
    }

    private void nextActivity(){
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }
}
