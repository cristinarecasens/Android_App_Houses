# 🏠 Idealista Lite — Aplicació d'Immobles

> **Nota:** Aquest repositori conté únicament el codi font (Kotlin + XML) com a mostra del projecte. No inclou fitxers de configuració de Gradle ni dependències, per tant no és clonable directament.

Aplicació Android de cerca i gestió d'immobles en poblacions catalanes. Permet navegar per un catàleg de propietats, veure detalls amb mapa de localització i afegir nous immobles.

## Pantalles disponibles

| Splash | Registre | Pantalla principal |
|:---:|:---:|:---:|
| Pantalla de càrrega | Formulari de registre | Carrousel de ciutats i immobles |

| Llista | Detall | Formulari |
|:---:|:---:|:---:|
| Grid de propietats | Info + Google Maps | Afegir nou immoble |

<h2>Demo</h2>
<p>Check out the app here: <a href="https://appetize.io/app/b_gtrhhib3w3ywy5silcevllrr7m">Android Emulator</a></p>

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

## Estructura del codi

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

## Especificacions tècniques

| Propietat | Valor |
|---|---|
| Min SDK | 29 (Android 10) |
| Target SDK | 34 (Android 14) |
| Kotlin | 1.9.24 |
| Java | 11 |

