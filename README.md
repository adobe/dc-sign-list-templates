# aas-list-templates

## Introduction

This Java-based command-line tool provides a simple method to list all the library templates within an [Adobe Acrobat Sign](https://www.adobe.com/sign.html) account.

## Set-Up Instructions

+ Download the latest release of the `aas-list-templates-<version>.jar` from the [Releases](https://git.corp.adobe.com/sign-acs/aas-list-templates/releases) page
+ [Download Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html), if you don't already have it installed on your machine
+ [IP Addresses to add to your allow list](https://helpx.adobe.com/sign/system-requirements.html#IPs), if needed

As the tool makes use of the [Adobe Sign REST API](https://secure.adobesign.com/public/docs/restapi/v6), it is necessary to [provide an integration key](https://helpx.adobe.com/sign/kb/how-to-create-an-integration-key.html) for your account.

To do this, follow the steps below:

1. Log in to your Acrobat Sign account (as an Account Administrator)
2. Click **Account** from the menu
3. Type "Access tokens" in the search field on the left side of the screen
4. Press the "+" icon on the right side
5. Create a key with the scopes needed (`user_read` and `library_read` is required for your account)
6. Double-click the key you just created and copy the FULL text (it goes off-screen to the right so make sure you get it all)
7. Store the `Integration Key` for later use

## Usage

+ Open a command prompt in the directory where you have the JAR file downloaded
+ Execute the following command, replacing:
  + `<version>` with the appropriate value for the release, such as `1.0.0`
  + `<integrationKey>` with your saved value from above
  + `[--sandbox]` optional flag if the integration key is for a Sandbox account

```sh
java -jar aas-list-templates-<version>.jar <integrationKey> [--sandbox]
```

Assuming you have specified the required parameters correctly, then you should see output similar to that below:

![Sample Output](/images/example-usage.png)

Note that the output is deliberately concise to support redirecting output to a CSV file which can then be opened in programs such as Microsoft Excel.

```sh
java -jar aas-list-templates-<version>.jar <integrationKey> > output.csv
```

## Building

If you would like to build a release package locally, you should have the following software installed:

+ OS: Linux, macOS, Windows
+ Java JDK: version 1.8 or above
+ Apache Maven

The tool makes use of the [Adobe Sign Java SDK](https://opensource.adobe.com/acrobat-sign/sdks/java.html), so you will first need to clone the [acrobat-sign repository](https://github.com/adobe/acrobat-sign) and install the package into your Maven repository by issuing the following commands:

```sh
cd <location-of-cloned-acrobat-sign-repo>/sdks/AcrobatSign_JAVA_SDK
mvn clean install
```

Once this has completed, clone this repository and build the package by issuing:

```sh
cd <location-of-cloned-tool-repo>
mvn clean package
```

## Contributing
Contributions are welcomed! Read the [Contributing Guide](CODE_OF_CONDUCT.md) for more information.

## Licensing
This project is licensed under the Apache V2 License. See [LICENSE](LICENSE) for more information.