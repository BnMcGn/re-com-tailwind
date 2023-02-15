<!--  [![CI](https://github.com/day8/re-com/workflows/ci/badge.svg)](https://github.com/day8/re-com/actions?workflow=ci)
[![CD](https://github.com/day8/re-com/workflows/cd/badge.svg)](https://github.com/day8/re-com/actions?workflow=cd)
[![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/day8/re-com?style=for-the-badge)](https://github.com/day8/re-com/tags) 
[![Clojars Project](https://img.shields.io/clojars/v/re-com.svg?style=for-the-badge&logo=clojure&logoColor=fff)](https://clojars.org/re-com)
[![GitHub issues](https://img.shields.io/github/issues-raw/day8/re-com?style=for-the-badge&logo=github)](https://github.com/day8/re-com/issues)
[![GitHub pull requests](https://img.shields.io/github/issues-pr/day8/re-com?style=for-the-badge&logo=github)](https://github.com/day8/re-com/pulls)
[![License](https://img.shields.io/github/license/day8/re-com.svg?style=for-the-badge)](license.txt)
-->

# re-com-tailwind

An extension of the [Re-Com](https://github.com/day8/re-com) UI component library that is meant for use with [TailwindCSS](https://tailwindcss.com/). Re-com-tailwind does not rely on Bootstrap.

## State of the Project

- All dependencies from bootstrap.css removed
- Not completely converted to tailwind, ALPHA, mvp, etc.
- Still dependent on [various] css files

## Basic Usage

- look at re-com 
- might use [build system]




[Reagent](http://reagent-project.github.io). 

[Bootstrap](http://getbootstrap.com/)  [Material Design Icons](http://zavoloklom.github.io/material-design-iconic-font/icons.html).


## Demo


2. Compiling And Running The Demo
   
   ```shell
   lein watch
   ```
   
   This will run the demo, by doing:
     - a clean
     - a compile
   
   Wait until `[:demo] Build completed.` is displayed in the console indicating
   the dev HTTP server is ready.
    
   Now you can open [`http://localhost:3449/`](http://localhost:3449/) in your
   browser.



## Using re-com

re-com is available from clojars. Add it to your project.clj dependencies:

[![Clojars Project](https://img.shields.io/clojars/v/re-com.svg)](https://clojars.org/re-com)

You should now be able to require the `re-com.core` namespace, which exposes all of the API functions documented in the `re-demo` example app.

You'll then need to include these asset folders in your app:
https://github.com/day8/re-com/tree/master/run/resources/public/assets

As far as your `index.html` is concerned, take inspiration from here:
https://github.com/day8/re-com/tree/master/run/resources/public

In particular, you'll need bootstrap (assumedly via a CDN):
```html
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.css">
```

And a reference to these two CSS files (make sure `re-com.css` appears after `bootstrap.css`):

```html
<link rel="stylesheet" href="assets/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="assets/css/re-com.css">
```

And a reference to the Roboto fonts (but this can be overridden relatively easily):

```html
<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic" rel="stylesheet" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300' rel='stylesheet' type='text/css'>
```




### License

Copyright © 2015-2021 Michael Thompson
Copyright © 2022-2023 Ben McGunigle

Distributed under The MIT License (MIT) - See LICENSE.txt

