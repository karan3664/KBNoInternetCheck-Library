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
	
Step 3. Add Code in MainActivity Class

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}
