# KBNoInternetCheck-Library
Live internet check via KBNoInternetCheck.



Gradle Dependency

Step 1. Add the JitPack repository to your build file Add it in your root build.gradle at the end of repositories:

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
            android:name="com.karan_brahmaxatriya.kbnetwork.App" >
        ...
    </application>
</manifest>
If you do override the Application class, change it to extend KBNoInternetCheckApplication (if possible) as follows:

public class MyApplication extends App { ... } 

Use

In youre activity/fragment get status like below

KBNetworkCheck.setConnectivityListener(new OnChangeConnectivityListener() {
    @Override
    public void onChanged(boolean status) {
        Toast.makeText(MainActivity.this, "" + status, Toast.LENGTH_SHORT).show();
    }
});
