package com.ia.sharephotos.presentation.view.fragments.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.fragments.login.Interfaces.IGoogle;
import com.ia.sharephotos.presentation.view.fragments.login.Interfaces.IGoogleView;

/**
 * Created by ismael on 06/05/16.
 */
public class AOuth implements IGoogle {

    private final Context mContext;
    private IGoogleView mIGoogleView;
    private static final int RC_SIGN_IN = 9001;
    private ProgressDialog mProgressDialog;
    private GoogleApiClient mGoogleApiClient;


    public AOuth(Context context, IGoogleView iGoogleView) {
        mContext = context;
        mIGoogleView = iGoogleView;

    }

    @Override
    public void onInitAOuth(SignInButton signInButton, GoogleSignInOptions gso, GoogleApiClient googleApiClient) {

        mGoogleApiClient = googleApiClient;
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setScopes(gso.getScopeArray());


    }

    @Override
    public void onStartAOuth() {
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            mIGoogleView.onGetProfileAOuth(result);
        }
    }

    @Override
    public void onSignInAOth() {
        mIGoogleView.onSignInAOth();
    }

    @Override
    public void onSignOutAOth() {

    }

    @Override
    public void onRevokeAccess() {

    }


    private void handleSignInResult(GoogleSignInResult result) {
        mIGoogleView.onGetProfileAOuth(result);

    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setMessage(mContext.getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }
}
