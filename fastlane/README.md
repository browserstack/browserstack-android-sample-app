fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android upload_test
```
fastlane android upload_test
```
Uploads build to Browserstack's app automate and app live and runs all the tests on uploaded app.
