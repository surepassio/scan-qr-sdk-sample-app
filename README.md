# Scan QR SDK

Welcome to **Scan QR SDK**, your premier solution for seamless QR code scanning and validation, with a special focus on Aadhaar QR codes. This guide will walk you through the steps to integrate our library into your Android application effortlessly.

## Sample App

Explore our [Scan QR SDK Sample App](https://github.com/surepassio/scan-qr-sdk-sample-app) to see the library in action and get a hands-on experience.

## Integration Steps

### 1. API Wrapper

To begin, create an API wrapper to interface with our `upload-qr` API. Detailed documentation for this API is available [here](https://docs.surepass.io/#0dd9cad1-323d-4ac3-a5e1-91e3bb548c66).
You will need an Authorization Token to use this API. Please contact your account manager to obtain the token.

### 2. Include the Library

#### Step 2.1: Add Dependencies

In your `app-level build.gradle` file, add the following dependency:

```groovy
minSdkVersion 26 // Minimum SDK version required

dependencies {
    implementation 'io.surepass.sdk:scan-qr-android-sdk:1.0.0'
}
```

#### Step 2.2: Configure Repositories

Update your `settings.gradle` file with the following configuration:

```groovy
pluginManagement {
    repositories {
        google()
        mavenCentral()
        jcenter()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        jcenter()
        mavenCentral()
        // Enter your GitHub username and personal access token
        maven {
            url = "https://maven.pkg.github.com/surepassio/scan-qr-sdk-sample-app"
            credentials {
                username = "USER_NAME"
                password = "PAT_TOKEN" // https://docs.github.com/en/github/authenticating-to-github/keeping-your-account-and-data-secure/creating-a-personal-access-token
                // Ensure the token has read package permissions
            }
        }
    }
}

```
### 3. Implement the SDK

In the activity or application where you want to integrate the SDK, use the following code:

```kotlin
import io.surepass.scanqr.api.InitScan
import io.surepass.scanqr.interfaces.QRCodeCallback

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetStarted.setOnClickListener {
            // Initiate QR scan and handle the result in the callback
            InitScan.startQRScan(this, object : QRCodeCallback {
                override fun onQRCodeScanned(result: String) {
                    Log.d("QRScanner", "Scanned QR Code: $result")
                    // Implement your API wrapper here to process Aadhaar QR details
                }
            })
        }
    }
}
```

### 4. Handle the Scanned QR Code

Upon integration, the SDK will open the camera to scan QR codes. The scanned QR details will be available in the `onQRCodeScanned` callback. Implement your API wrapper in this callback to handle Aadhaar QR details.

```kotlin

InitScan.startQRScan(this, object : QRCodeCallback {
    override fun onQRCodeScanned(result: String) {
        Log.d("QRScanner", "Scanned QR Code: $result")
        // Implement your API wrapper here to process Aadhaar QR details
    }
})

```

### 5. Successful Integration

After successfully integrating the library and implementing the API wrapper, your Android application will be capable of scanning QR codes with ease.

<hr/>

For support or contributions, feel free to reach out for integration support at techsupport@surepass.io.
