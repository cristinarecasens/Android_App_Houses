# 🏠  Real Estate Application

> **Note:** This repository only contains the source code (Kotlin + XML) as a project sample. It does not include Gradle configuration files or dependencies, therefore it cannot be cloned and run directly.

Android application for searching and managing real estate properties in Catalan towns. It allows browsing a catalog of properties, viewing details with a location map, and adding new properties.

## Available Screens

| Splash | Register | Main Screen |
|:---:|:---:|:---:|
| Loading screen | Registration form | Cities and properties carousel |

| List | Detail | Form |
|:---:|:---:|:---:|
| Property grid | Info + Google Maps | Add new property |

<h2>Demo</h2>
<p>Check out the app here: <a href="https://appetize.io/app/b_gtrhhib3w3ywy5silcevllrr7m">Android Emulator</a></p>

## Features

- **User registration** with validation against Firebase Realtime Database
- **Persistent session** using SharedPreferences
- **Cities carousel**: Barcelona, Besalú, Cadaqués, Calonge, Girona and Palamós
- **Properties carousel** with automatic rotation (ViewFlipper)
- **Property listing** in RecyclerView with image and price
- **Property details** with CardView, address, price and Google Maps map with marker
- **Form** to add new properties (town, address, price, coordinates)
- **Bottom navigation** with 3 tabs: Home, Add and Gallery
- **Search filters**: Rent, Buy, New listings, Price drop

## Technologies

| Technology | Usage |
|---|---|
| **Kotlin** | Main programming language |
| **Firebase Realtime Database** | User storage |
| **Google Maps SDK** | Property location map |
| **Material Design 3** | UI components (BottomNavigationView, CardView) |
| **Gson** | JSON serialization |
| **AndroidX** | RecyclerView, ConstraintLayout, AppCompat |

## Code Structure

```
app/src/main/
├── java/com/example/uf2_activitatfinal_part1/
│   ├── SplashActivity.kt        # Initial loading screen
│   ├── RegistrerActivity.kt     # User registration
│   ├── MainActivity.kt          # Main screen with carousels
│   ├── ActivityLlista.kt        # Property list (RecyclerView)
│   ├── ActivityFormulari.kt     # Form to add properties
│   ├── InfoActivity.kt          # Property details with map
│   ├── Casa.kt                  # Property data model
│   ├── Usuari.kt                # User data model
│   ├── ArrayCases.kt            # Singleton with property list
│   └── RecyclerViewAdapter.kt   # RecyclerView adapter
├── res/
│   ├── layout/                  # XML layouts
│   ├── drawable/                # City and house images
│   └── values/                  # Strings, themes, colors
└── AndroidManifest.xml
```


## Sample Data

The app includes 6 preloaded properties in Palamós:

| Address | Price |
|---|---|
| Carrer Blau, 1 | 600.000 € |
| Avinguda Palamós, 6 | 450.000 € |
| Passeig del Sol, 14 | 250.000 € |
| Carrer Lila, 32 | 290.000 € |
| Carrer Blanc, 102 | 380.000 € |
| Avinguda del Mar, 10 | 190.000 € |

## Technical Specifications

| Property | Value |
|---|---|
| Min SDK | 29 (Android 10) |
| Target SDK | 34 (Android 14) |
| Kotlin | 1.9.24 |
| Java | 11 |

## 👤 Autoria
Projecte desenvolupat com a treball de DAM2 per a Cristina Recasens.




