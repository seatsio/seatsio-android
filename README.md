# Seatsio Android component

[![](https://jitpack.io/v/seatsio/seatsio-android.svg)](https://jitpack.io/#seatsio/seatsio-android)

## Introduction

seatsio-android allows rendering seats.io seating charts or the event manager inside an Android application.

Android SDK version 24 and upwards is supported (which corresponds to Android 7 - Nougat)

## Installation

### Adding jitpack as a repository

First add jitpack as a repository in `build.gradle`:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

### Adding the seatsio-android dependency

Then you can refer to seatsio-android as a regular package:

```
dependencies {
  implementation 'com.github.seatsio:seatsio-android:9.3.0'
}
```

### Giving your app permission to access the internet

seatsio-android offers 2 custom views: `SeatingChartView` and `EventManagerView`. Those are WebViews, which need internet access. Make sure you add the following permission to `AndroidManifest.xml`

```xml
<manifest ...>

    <uses-permission android:name="android.permission.INTERNET" />

</manifest>
```

### Setting a targetCompatibility of at least 1.8

Your `build.gradle` also needs to specify a `targetCompatibility` of 1.8 or higher:

```
android {
    compileOptions {
        targetCompatibility 1.8
    }
}
```

## Examples

### Regular charts

All configuration parameters are documented at https://docs.seats.io/docs/renderer-embed-a-floor-plan

#### Minimal

```java
// this code should be inside an Activity
@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  SeatingChartConfig config = new SeatingChartConfig()
    .setPublicKey("<yourPublicKey>")
    .setEvent("<yourEventKey>");
      
  setContentView(new SeatingChartView(Region.EU, config, getApplicationContext()));
}
```

#### Simple pricing

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setPublicKey("<yourPublicKey>")
  .setEvent("<yourEventKey>");
  .setPricing(
          new PricingForCategory("Ground Floor", new SimplePricing(34)),
          new PricingForCategory("Balcony", new SimplePricing(50))
  )
  .setPriceFormatter(price -> price + "€");
  
setContentView(new SeatingChartView(Region.EU, config, getApplicationContext()));
```

#### Multi-level pricing (ticket types)

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setPublicKey("<yourPublicKey>")
  .setEvent("<yourEventKey>");
  .setPricing(
    new PricingForCategory("Ground Floor",
      new TicketTypesPricing(
        new TicketTypePricing(40, "Child"),
        new TicketTypePricing(50, "Adult")
      )),
    new PricingForCategory("Balcony",
      new TicketTypesPricing(
        new TicketTypePricing(60, "Child"),
        new TicketTypePricing(70, "Adult")
   )))
  .setPriceFormatter(price -> price + "€");
  
setContentView(new SeatingChartView(Region.EU, config, getApplicationContext()));
```

#### Creating a session to hold seats

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setPublicKey("<yourPublicKey>")
  .setEvent("<yourEventKey>")
  .setSession(START)
  .setOnChartRendered((chart) -> {
    chart.getHoldToken(holdToken -> {
      // do something with the hold token
    })
  });
SeatingChartView chart = new SeatingChartView(Region.EU, config, getApplicationContext())
        
setContentView(chart);
```

#### Handling object selections and deselections

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setPublicKey("<yourPublicKey>")
  .setEvent("<yourEventKey>")
  .setOnObjectSelected((object, ticketType) -> /* do something */)
  .setOnObjectDeselected((object, ticketType) -> /* do something */);

setContentView(new SeatingChartView(Region.EU, config, getApplicationContext()));
```

#### chart.listSelectedObjects()

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setPublicKey("<yourPublicKey>")
  .setEvent("<yourEventKey>")
  .setOnChartRendered((chart) -> {
    chart.listSelectedObjects(objects -> {
      // do something with the list of objects
    })
  });
SeatingChartView chart = new SeatingChartView(Region.EU, config, getApplicationContext())
        
setContentView(chart);
```

#### chart.getReportBySelectability()

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setPublicKey("<yourPublicKey>")
  .setEvent("<yourEventKey>")
  .setOnChartRendered((chart) -> {
    chart.getReportBySelectability(report -> {
      // do something with the report
    })
  });
SeatingChartView chart = new SeatingChartView(Region.EU, config, getApplicationContext())
        
setContentView(chart);
```

#### Methods on seats (and other selectable objects)

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setPublicKey("<yourPublicKey>")
  .setEvent("<yourEventKey>")
  .setSession(START)
  .setOnChartRendered((chart) -> {
    chart.selectObject("K-3"); // or chart.deselectObject("K-3"), chart.pulseObject("K-3"), ...
    chart.isObjectInChannel("K-3", "NO_CHANNEL", result -> Log.i("aTag", "In channel NO_CHANNEL? " + result));
  });
SeatingChartView chart = new SeatingChartView(Region.EU, config, getApplicationContext())
        
setContentView(chart);
```

#### Showing object labels

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setPublicKey("<yourPublicKey>")
  .setEvent("<yourEventKey>")
  .setObjectLabel("object => object.labels.own"); // must be a valid Javascript function

setContentView(new SeatingChartView(Region.EU, config, getApplicationContext()));
```

### Event manager

```java
// this code should be inside an Activity
@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  EventManagerConfig config = new EventManagerConfig()
    .setSecretKey("<yourSecretKey>")
    .setEvent("<yourEventKey>")
    .setMode(MANAGE_OBJECT_STATUSES)
    .setLanguage("nl");
  
  setContentView(new EventManagerView(Region.EU, config, getApplicationContext()));
}
```

Documentation for the event manager is available at https://docs.seats.io/docs/event-manager
