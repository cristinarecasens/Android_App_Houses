# 🏠 Idealista Lite — Aplicació d'Immobles

Aplicació Android de cerca i gestió d'immobles en poblacions catalanes. Permet navegar per un catàleg de propietats, veure detalls amb mapa de localització i afegir nous immobles.

## Captures de pantalla

| Splash | Registre | Pantalla principal |
|:---:|:---:|:---:|
| Pantalla de càrrega | Formulari de registre | Carrousel de ciutats i immobles |

| Llista | Detall | Formulari |
|:---:|:---:|:---:|
| Grid de propietats | Info + Google Maps | Afegir nou immoble |

## Funcionalitats

- **Registre d'usuaris** amb validació contra Firebase Realtime Database
- **Sessió persistent** mitjançant SharedPreferences
- **Carrousel de ciutats**: Barcelona, Besalú, Cadaqués, Calonge, Girona i Palamós
- **Carrousel de propietats** amb rotació automàtica (ViewFlipper)
- **Llistat d'immobles** en RecyclerView amb imatge i preu
- **Detall de propietat** amb CardView, adreça, preu i mapa Google Maps amb marcador
- **Formulari** per afegir nous immobles (població, adreça, preu, coordenades)
- **Navegació inferior** amb 3 pestanyes: Inici, Afegir i Galeria
- **Filtres** de cerca: Lloguer, Compra, Novetats, Baixada de preu

## Tecnologies

| Tecnologia | Ús |
|---|---|
| **Kotlin** | Llenguatge principal |
| **Firebase Realtime Database** | Emmagatzematge d'usuaris |
| **Google Maps SDK** | Mapa de localització de propietats |
| **Material Design 3** | Components UI (BottomNavigationView, CardView) |
| **Gson** | Serialització JSON |
| **AndroidX** | RecyclerView, ConstraintLayout, AppCompat |

## Estructura del projecte

```
app/src/main/
├── java/com/example/uf2_activitatfinal_part1/
│   ├── SplashActivity.kt        # Pantalla de càrrega inicial
│   ├── RegistrerActivity.kt     # Registre d'usuaris
│   ├── MainActivity.kt          # Pantalla principal amb carrousels
│   ├── ActivityLlista.kt        # Llistat de propietats (RecyclerView)
│   ├── ActivityFormulari.kt     # Formulari per afegir immobles
│   ├── InfoActivity.kt          # Detall de propietat amb mapa
│   ├── Casa.kt                  # Model de dades d'immoble
│   ├── Usuari.kt                # Model de dades d'usuari
│   ├── ArrayCases.kt            # Singleton amb llistat de propietats
│   └── RecyclerViewAdapter.kt   # Adapter del RecyclerView
├── res/
│   ├── layout/                  # Layouts XML
│   ├── drawable/                # Imatges de ciutats i cases
│   └── values/                  # Strings, temes, colors
└── AndroidManifest.xml
```

## Requisits previs

- **Android Studio** Hedgehog o superior
- **JDK 11**
- **Android SDK 34** (API 34)
- **Dispositiu/Emulador** amb Android 10+ (API 29)
- Compte de **Google Cloud** amb Maps SDK activat
- Projecte de **Firebase** configurat

## Instal·lació

1. **Clona el repositori**
   ```bash
   git clone https://github.com/<el-teu-usuari>/UF2_ActivitatFinal_Part1.git
   cd UF2_ActivitatFinal_Part1
   ```

2. **Configura les API Keys**

   Afegeix la teva Google Maps API key a `local.properties`:
   ```properties
   MAPS_API_KEY=la_teva_api_key_aquí
   ```

3. **Configura Firebase**

   Col·loca el teu fitxer `google-services.json` (descarregat des de la consola de Firebase) a la carpeta `app/`.

4. **Obre el projecte** amb Android Studio i sincronitza Gradle.

5. **Executa** l'app en un emulador o dispositiu físic.

## Configuració Firebase

1. Crea un projecte a [Firebase Console](https://console.firebase.google.com/)
2. Afegeix una app Android amb el package `com.example.uf2_activitatfinal_part1`
3. Descarrega `google-services.json` i col·loca'l a `app/`
4. Activa **Realtime Database** al panell de Firebase

## Dades de mostra

L'app inclou 6 propietats precàrregades a Palamós:

| Adreça | Preu |
|---|---|
| Carrer Blau, 1 | 600.000 € |
| Avinguda Palamós, 6 | 450.000 € |
| Passeig del Sol, 14 | 250.000 € |
| Carrer Lila, 32 | 290.000 € |
| Carrer Blanc, 102 | 380.000 € |
| Avinguda del Mar, 10 | 190.000 € |

## Build

| Propietat | Valor |
|---|---|
| Min SDK | 29 (Android 10) |
| Target SDK | 34 (Android 14) |
| Kotlin | 1.9.24 |
| Gradle | 8.7.2 |
| Java | 11 |
