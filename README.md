# GithubBest
Android Application Showing the Top 100 Github Repositories

## Purpose:
 The purpose of this project is to create a Android application that is able to
 make an API call to display the top 100 Starred Repository with its top contributors
 using third party libraries.
 
## Screenshot:
![image](https://github.com/rc41186/GithubBest/blob/master/app/resources/screenshot/Screenshot_1576543527.png)

## Time Spent:
    ~ 4 Hours
     - 1 Hour setting up the UI
         - Padding Sizing
         - Margin Sizing
         - Layout Design
         - Databinding
         - Fragment Setup
         - RecyclerView Setup

     - 2 Hours setting up the backend
         - Retrofit
         - Model Declaration
         - Github Service Setup via Retofit
         - Debugging

    - 1 Hour
        - CI/CD Setup
        - Testing (Manual)
        - Documentation
        - Bug Fixes
        - An attempt UI/Unit Tests
        
## Known Issues:
    - Top Contributor needs to be handled better, should display text if API Call limit is reached

    
## Challenges:
    - Finding the right Github API call

    - Contributors API calls has a limit of 60 calls per hour - 403 there after an hour. (Tried to work around this with a mock response)

    - Mentally keeping in mind of the time factor (try not to do too much)

    - Environment Setup - Personal system didn't have the latest and greatest Android Studio and SDKs.

    - Technical Brain Farts - 9 months away from Android, had to go through some refreshers and library's latest versions.

## CI/CD:
    - https://app.bitrise.io/app/e8e2ca5d9c5a580a#/builds

## Third Party Libraries:
    - Retrofit
    - Databinding
    - Android Support Libraries

## Wish-List:
    - Progress Bar of some sort
    - Utilize more of Clean Architecture
    - UseCases
    - Coroutines or RxAndroid/RxKotlin
    - Dependency Injection
    - UI Tests
    - Unit Tests
    - More Time :)
