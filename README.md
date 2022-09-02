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
  <!-- a href="https://github.com/mlgr-io/kotlin-skeleton">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a //-->

<h3 align="center">Kotlin project skeleton</h3>

  <p align="center">
    Example project for a plain Kotlin project with a multi-file gradle config, including common dependencies. 
    <!-- br />
    <a href="https://github.com/mlgr-io/kotlin-skeleton"><strong>Explore the docs »</strong></a //-->
    <br />
    <br />
    <!-- a href="https://github.com/mlgr-io/kotlin-skeleton">View Demo</a>
    · //-->
    <a href="https://github.com/mlgr-io/kotlin-skeleton/issues">Report Bug</a>
    ·
    <a href="https://github.com/mlgr-io/kotlin-skeleton/issues">Request Feature</a>
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

This project was meant to help us get new project initialized faster. It includes some commonly used plugins and
dependencies and a simple CI/CD workflow for GitHub.

You may abstract the [list of included plugins](01-versions.gradle.kts#L16) and
[other dependencies](02-configuration.gradle.kts#L23) right from the files.

### Versioning strategy

This project will be tagged as any of the dependencies change. We will raise the **minor** version, if any of the
included dependencies change their minor version and we will raise the **major** version, if any of the
included dependencies change their major version.

Any other updates to this project itself (documentation etc.) will **not** result in a tagged release.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

We choose to support the lowest actively supported Java version at the time of writing, that is, Java 11 (this may be
subject to change in future major releases).

### Installation

Since this project isn't going to be released at maven central (because that wouldn't make any sense), you may clone
the latest `develop` branch of this repository, drop the link to this repository and start your work from there: 
   ```sh
   git clone https://github.com/mlgr-io/kotlin-skeleton.git your-desired-project-folder
   cd your-desired-project-folder
   git remote rm origin
   ```

On the other hand, if you want to use the splitted gradle config, you may copy the [build.gradle.kts](build.gradle.kts)
into your own project and replace the file references by absolute URLs, that is: Replace
```kotlin
apply(from = "01-versions.gradle.kts")
```
by
```kotlin
apply(from = "https://raw.githubusercontent.com/mlgr-io/kotlin-skeleton/0.1/01-versions.gradle.kts")
```
and
```kotlin
apply(from = "02-configuration.gradle.kts")
```
by
```kotlin
apply(from = "https://raw.githubusercontent.com/mlgr-io/kotlin-skeleton/0.1/02-configuration.gradle.kts")
```
respectively.
**Please make sure to NOT link to develop, as these files may include undetected changes.**


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the **GNU General Public License v3.0**. See [LICENSE.md](LICENSE.md) for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Project Link: [https://github.com/mlgr-io/kotlin-skeleton](https://github.com/mlgr-io/kotlin-skeleton)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
<!-- [javadoc-url]: https://javadoc.io/doc/io.mailguru/api-core -->
<!-- [javadoc-shield]: https://javadoc.io/badge2/io.mailguru/api-core/javadoc.svg?style=for-the-badge&color=yellow -->
<!-- [maven-url]: https://search.maven.org/artifact/io.mailguru/api-core -->
<!-- [maven-shield]: https://img.shields.io/maven-central/v/io.mailguru/api-core?style=for-the-badge -->
[contributors-shield]: https://img.shields.io/github/contributors/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[contributors-url]: https://github.com/mlgr-io/kotlin-skeleton/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[forks-url]: https://github.com/mlgr-io/kotlin-skeleton/network/members
[stars-shield]: https://img.shields.io/github/stars/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[stars-url]: https://github.com/mlgr-io/kotlin-skeleton/stargazers
[issues-shield]: https://img.shields.io/github/issues/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[issues-url]: https://github.com/mlgr-io/kotlin-skeleton/issues
[license-shield]: https://img.shields.io/github/license/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[license-url]: https://github.com/mlgr-io/kotlin-skeleton/blob/master/LICENSE.md
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
