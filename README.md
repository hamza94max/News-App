# News APP
News application using the API from https://newsapi.org/ API News Is JSON API for live news and blog articles from the media. 
News Feed is a simple that gives you latest and best news from multiple sources so you no longer need to swap between apps to stay informed.


## Architecture
The architecture of this application relies and complies with the following points below:
- __Clean Architecture__,: into 3 layers ui, data, domain
- __Pattern Model-View-ViewModel (MVVM)__ which facilitates a separation of development of the graphical user interface.
- __Android architecture components__ which help to keep the application robust, testable, and maintainable.

![Capture](https://github.com/hamza94max/Football-League-App/assets/54688005/317d0417-bf8a-4fa9-895e-b13c24d1f374)


## ScreenShots

 <table>
  <tr>
    <th>Home Screen </th>
    <th>Favourites Screen</th>
    <th>Empty Screen</th>
  </tr>
  <tr>
    <td><img src="https://github.com/hamza94max/News-App/assets/54688005/9a172767-98d8-4c5c-979f-80d184b9ffa6" width="350"></td>
    <td><img src="https://github.com/hamza94max/News-App/assets/54688005/dc73ffdd-afc9-41ec-9d33-e3d35145143a" width="350"></td>
    <td><img src="https://github.com/hamza94max/News-App/assets/54688005/1f80458e-a4d8-4aeb-90d1-ca6c8c999d1c" width="350"></td>
  </tr>
 </table>


# Languages and Tools
* [Kotlin](https://kotlinlang.org/) - official programming language for Android development .
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - dependency injection library .
* [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - for asynchronous programming .
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - Access your app's SQLite database with in-app objects and compile-time checks.
* [detekt](https://github.com/detekt/detekt) - Static code analysis for Kotlin.

## API
The used api to get News :  https://newsapi.org/v2/
with endPoint `everything`


