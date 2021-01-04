# KBNoInternetCheck-Library
Live internet check via KBNoInternetCheck.



How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2. Add the dependency

dependencies {
	        implementation 'com.github.karan3664:KBNoInternetCheck-Library:0.1.0'
	}
	
To-do

Enable KBNoInternetCheck

If you do not override the Application class, edit your manifest file to set android:name in the tag as follows:


<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.myapp">
    <application
            android:name="org.sumon.eagleeye.App" >
        ...
    </application>
</manifest>

Use

In youre activity/fragment get status like below

 KBNetworkCheck.setConnectivityListener(new OnChangeConnectivityListener() {
            @Override
            public void onChanged(boolean status) {
                TextView t = findViewById(R.id.textView);
                if (status == true) {
                    t.setText("Internet is Available");
                } else {
                    t.setText("Internet is Not Available");
                }
            }
        });
