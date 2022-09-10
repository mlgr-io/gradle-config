<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![License: GPL v3][license-shield]][license-url]
<!-- [![Javadoc][javadoc-shield]][javadoc-url] -->
<!-- [![MavenCentral][maven-shield]][maven-url] -->




<!-- PROJECT LOGO -->
<br />
<div align="center">
  <!-- a href="https://github.com/mlgr-io/gradle-config">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a //-->

<h3 align="center">Common configuration Gradle plugin</h3>

  <p align="center">
    A Gradle plugin for sharing versioning and configuration across independent projects.
    <!-- br />
    <a href="https://github.com/mlgr-io/gradle-config"><strong>Explore the docs »</strong></a //-->
    <br />
    <br />
    <a href="https://github.com/mlgr-io/gradle-config/issues">Report Bug</a>
    ·
    <a href="https://github.com/mlgr-io/gradle-config/issues">Request Feature</a>
    ·
    <a href="CHANGELOG.md">Changelog</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This Gradle plugin injects some basic configuration (including dependencies and plugins) into all of your (unrelated to
each other) projects from a shared, single point of declaration.

It was invented to help us get new project initialized faster and keep track of versions at a single place for
all of our projects. It does also include some GitHub action blueprints.

### Versioning strategy

This library uses [Semantic Versioning 2.0](https://semver.org) and generates its Changelog from
[Conventional Commit](https://www.conventionalcommits.org/en/v1.0.0/) messages.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

We choose to support the lowest actively supported Java version at the time of writing, that is, Java 11 (this may be
subject to change in future releases).

### Usage

The config given in this repository already includes `kotlin` and the `org.jetbrains.kotlin:kotlin-bom` artifact in the
latest version; so a minimal `build.gradle.kts` would look like:
```kotlin
// Complete [sic!] working example of build.gradle.kts

repositories {
    mavenCentral()
}

plugins {
    id("io.mailguru.gradle-config") version "1.0.1"
}
```

You may, of course, override the configuration of the injected dependencies and plugins on your own, e.g.:
```kotlin
// Complete [sic!] working example of build.gradle.kts

repositories {
    mavenCentral()
}

plugins {
    id("io.mailguru.gradle-config") version "1.0.1"
}

detekt {
    // Adds debug output during task execution. `false` by default.
    debug = true
}
```

The plugin will also add some output of the applied configuration to your Gradle tasks.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are welcome; please stick to the
[GitHub Fork & Pull Request Workflow](https://gist.github.com/james-priest/74188772ef2a6f8d7132d0b9dc065f9c). \
We will then review your changes and accept your PR if applicable.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the **GNU General Public License v3.0**. See [LICENSE.md](LICENSE.md) for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Project Link: [https://github.com/mlgr-io/gradle-config](https://github.com/mlgr-io/gradle-config)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
<!-- [javadoc-url]: https://javadoc.io/doc/io.mailguru/api-core -->
<!-- [javadoc-shield]: https://javadoc.io/badge2/io.mailguru/api-core/javadoc.svg?style=for-the-badge&color=yellow -->
<!-- [maven-url]: https://search.maven.org/artifact/io.mailguru/api-core -->
<!-- [maven-shield]: https://img.shields.io/maven-central/v/io.mailguru/api-core?style=for-the-badge -->
[contributors-shield]: https://img.shields.io/github/contributors/mlgr-io/gradle-config.svg?style=for-the-badge
[contributors-url]: https://github.com/mlgr-io/gradle-config/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mlgr-io/gradle-config.svg?style=for-the-badge
[forks-url]: https://github.com/mlgr-io/gradle-config/network/members
[stars-shield]: https://img.shields.io/github/stars/mlgr-io/gradle-config.svg?style=for-the-badge
[stars-url]: https://github.com/mlgr-io/gradle-config/stargazers
[issues-shield]: https://img.shields.io/github/issues/mlgr-io/gradle-config.svg?style=for-the-badge
[issues-url]: https://github.com/mlgr-io/gradle-config/issues
[license-shield]: https://img.shields.io/github/license/mlgr-io/gradle-config.svg?style=for-the-badge
[license-url]: https://github.com/mlgr-io/gradle-config/blob/master/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com
