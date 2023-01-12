# Seats.io Android component

[![Maven Central](https://img.shields.io/maven-central/v/io.seats/seatsio-android)](https://central.sonatype.dev/namespace/io.seats)
[![Build Status](https://img.shields.io/github/actions/workflow/status/seatsio/seatsio-android/build.yml)](https://github.com/seatsio/seatsio-android/actions/workflows/build.yml)

## Introduction

seatsio-android allows rendering seats.io seating charts or the event manager inside an Android application.

Android SDK version 29 and upwards is supported (which corresponds to Android 10)

## Installation

### Adding the seatsio-android dependency

seatsio-android is available in the Maven Central repository:

```
// build.gradle
dependencies {
  compile 'io.seats:seatsio-android:12.1.0'
}

// pom.xml
<dependency>
  <groupId>io.seats</groupId>
  <artifactId>seatsio-android</artifactId>
  <version>12.1.0</version>
</dependency>
```

Note that v12.0.0 is the first version that's hosted on Maven Central instead of on JitPack.

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
    .setWorkspaceKey("<yourPublicWorkspaceKey>")
    .setEvent("<yourEventKey>");
      
  setContentView(new SeatingChartView(Region.EU, config, getApplicationContext()));
}
```

#### Simple pricing

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
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
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
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
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
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
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
  .setEvent("<yourEventKey>")
  .setOnObjectSelected((object, ticketType) -> /* do something */)
  .setOnObjectDeselected((object, ticketType) -> /* do something */);

setContentView(new SeatingChartView(Region.EU, config, getApplicationContext()));
```

#### chart.listSelectedObjects()

```java
SeatingChartConfig config = new SeatingChartConfig()
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
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
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
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
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
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
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
  .setEvent("<yourEventKey>")
  .setObjectLabel("object => object.labels.own"); // must be a valid Javascript function

setContentView(new SeatingChartView(Region.EU, config, getApplicationContext()));
```

#### Zooming to sections

```java
AtomicBoolean rendered = new AtomicBoolean(false);
SeatingChartConfig config = new SeatingChartConfig()
  .setWorkspaceKey("<yourPublicWorkspaceKey>")
  .setEvent("<yourEventKey>")
  .setOnChartRendered((chart) -> rendered.set(true))
});
SeatingChartView chart = new SeatingChartView(Region.EU, config, getApplicationContext());
setContentView(chart);

final Button button = findViewById(R.id.go_to_section_button);
button.setOnClickListener((View v) -> {
  if (rendered.get()) {
    chart.zoomToSection("foo");
  }
});
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
