<h1 align="center">🌀 SwiftSpinProgress</h1>

<p align="center">
  <em>A lightweight, customizable iOS-style circular progress indicator for Android built with Jetpack Compose.</em>
</p>

<p align="center">
  <a href="https://search.maven.org/artifact/io.github.team2681/swiftspinprogress"><img src="https://img.shields.io/maven-central/v/io.github.team2681/swiftspinprogress?style=for-the-badge&color=brightgreen" alt="Maven Central"></a>
  <a href="https://github.com/anilkumar2681/SwiftSpinProgress/blob/main/LICENSE"><img src="https://img.shields.io/github/license/anilkumar2681/SwiftSpinProgress?style=for-the-badge" alt="License"></a>
  <a href="https://github.com/anilkumar2681/SwiftSpinProgress/stargazers"><img src="https://img.shields.io/github/stars/anilkumar2681/SwiftSpinProgress?style=for-the-badge&color=yellow" alt="Stars"></a>
</p>

---

## ✨ Overview

**SwiftSpinProgress** is a modern, Jetpack Compose–based loading indicator inspired by iOS spinners.  
It offers smooth animations, easy customization, and a clean Material look — perfect for any Android app.

---

## 🎨 Features

- 🧩 **Composable-first** — plug directly into your Compose UI  
- ⚡ **Lightweight** — minimal setup and no external dependencies  
- 💫 **Smooth animations** with adjustable duration  
- 🎨 **Fully customizable** colors, shapes, and item counts  
- 🌗 **Dark/Light mode ready**

---

## 🖼️ Preview

<table> <tr> 
<th style="text-align:center;">Light State</th>
<th style="text-align:center;">Dark State</th>
</tr>
<tr> 
<td><img src="images/light.jpg" alt="Loading State" width="202"/></td> 
<td><img src="images/dark.jpg" alt="Expanded State" width="202"/></td> 
<td><img src="images/lightG.gif" alt="Collapsed State" width="202"/></td>
<td><img src="images/darkG.gif" alt="Collapsed State" width="202"/></td>
</tr> </table>

> Add preview GIFs or screenshots here.

---

## 📦 Installation

Add this dependency to your **module-level** `build.gradle` file:

```kotlin
dependencies {
    implementation("io.github.team2681:swiftspinprogress:1.0.0")
}
