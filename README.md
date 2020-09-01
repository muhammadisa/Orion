

<h1 align="center">Welcome to Orion 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
  <img alt="documentation: yes" src="https://img.shields.io/badge/Documentation-Yes-green.svg" />
  <img alt="maintained: yes" src="https://img.shields.io/badge/Maintained-Yes-green.svg" />
</p>



> Short introduction, this is very simple tool for navigate between activities using deep link

## Install

For installation just add this code in your app build.gradle file

```groovy
implementation 'com.github.muhammadisa:orion:1.0.0'
```

## Contribute?

Read the terms https://github.com/muhammadisa/orion/blob/master/CONTRIBUTING.md

## Need Example?

Just click this link https://github.com/muhammadisa/orion/tree/master/example/src/main/java/com/xoxoer/example

## Simple Usage

1. ##### add this new string inside your strings.xml

   ```xml
   <string name="app_domain">yourapp</string>
   ```

2. **set link for your activity inside AndroidManifest.xml**

   ```xml
   <activity android:name=".YourDesiredActivity">
       <intent-filter>
           <action android:name="android.intent.action.VIEW" />
   
           <category android:name="android.intent.category.BROWSABLE" />
           <category android:name="android.intent.category.DEFAULT" />
   
           <data
                 android:host="your.desired.activity"
                 android:scheme="@string/app_domain" />
       </intent-filter>
   </activity>
   ```

3. **create Route class**

   ```kotlin
   object InitialRouteName {
       // replace this with your initial route name
       const val FIRST = "first"
       const val SECOND = "second"
       const val THIRD = "third"
   }
   
   class Route internal constructor(
       context: Context,
       private val initial: String
   ) : Orion(), OrionContract {
   
       init {
           super.init(context)
       }
   
       // get string from string resource for app domain
       override val appDomain: String = context.getString(R.string.app_domain)
   
       override val routes: Map<String, Uri> = mapOf(
           // deep link format : appdomain://your.desired.activity
           // exmaple
           FIRST to Uri.parse("$appDomain://first.act"),
           SECOND to Uri.parse("$appDomain://second.act"),
           THIRD to Uri.parse("$appDomain://third.act")
       )
   
       fun navigate() {
           super.navigate(routes[initial] ?: error(""))
       }
   
       fun navigate(extraKey: String, extra: Any) {
           val uri = routes[initial] ?: error("")
           super.navigate(uri, extraKey, extra)
       }
   
       fun navigateNoHistory() {
           super.navigateNoHistory(routes[initial] ?: error(""))
       }
   
   }
   ```

4. **final usage**

   ```kotlin
   class MainActivity : AppCompatActivity() {
   
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)
   
           button_first.setOnClickListener {
               // normal navigate
               Route(it.context, FIRST).navigate()
           }
   
           button_second.setOnClickListener {
               // navigate with extra data parcelable
               Route(it.context, SECOND).navigate("MESSAGE", Message(
                   "MainActivity",
                   "Hello, navigating with deeplink and orion"
               ))
           }
   
           button_third.setOnClickListener {
               // navigate without back to previous activity
               Route(it.context, THIRD).navigateNoHistory()
           }
   
       }
   
   }
   ```

   

## Author

👤 **Muhammad Isa Wijaya Kusuma**

* Github: [@muhammadisa](https://github.com/muhammadisa)

## Show your support

Give a ⭐️ if this project helped you!

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_

