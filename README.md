<!--  [![CI](https://github.com/day8/re-com/workflows/ci/badge.svg)](https://github.com/day8/re-com/actions?workflow=ci)
[![CD](https://github.com/day8/re-com/workflows/cd/badge.svg)](https://github.com/day8/re-com/actions?workflow=cd)
[![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/day8/re-com?style=for-the-badge)](https://github.com/day8/re-com/tags) 
[![Clojars Project](https://img.shields.io/clojars/v/re-com.svg?style=for-the-badge&logo=clojure&logoColor=fff)](https://clojars.org/re-com)
[![GitHub issues](https://img.shields.io/github/issues-raw/day8/re-com?style=for-the-badge&logo=github)](https://github.com/day8/re-com/issues)
[![GitHub pull requests](https://img.shields.io/github/issues-pr/day8/re-com?style=for-the-badge&logo=github)](https://github.com/day8/re-com/pulls)
[![License](https://img.shields.io/github/license/day8/re-com.svg?style=for-the-badge)](license.txt)
-->

# re-com-tailwind

An extension of the [re-com](https://github.com/day8/re-com) UI component library that is meant for use with [TailwindCSS](https://tailwindcss.com/).

## State of the Project

re-com-tailwind is in its minimally viable infancy. Right now it consists of re-com with the bootstrap dependencies removed. Many of the CSS values have not been converted to tailwind style classes. There are still dependencies on other CSS files. CSS Purity has not been attained.

If you would like to help out, please see the [issues](https://github.com/BnMcGn/re-com-tailwind/issues) page.

### Limitations

- It's probably a bad idea to use re-com-tailwind and regular re-com components at the same time, because re-com-tailwind tampers with the CSS structures in re-com.


## Demo

   Run this in the re-com-tailwind directory:
   
   ```shell
   lein watch
   ```
   
   Wait until `[:demo] Build completed.` is displayed, then visit [`http://localhost:3449/`](http://localhost:3449/) in your browser.

   For comparison, the [original re-com demo](https://re-com.day8.com.au/)



## Using re-com-tailwind

re-com-tailwind is available from clojars. Add it to your project.clj dependencies:

[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.bnmcgn/re-com-tailwind.svg)](https://clojars.org/org.clojars.bnmcgn/re-com-tailwind)

The re-com-tailwind components are, at this point, components from re-com with custom CSS settings. However, it is probably best to require them from the `re-com-tailwind.core` namespace, in case of future customization.

Functionality and documentation for re-com-tailwind components should be identical to that of [re-com](https://re-com.day8.com.au/).

You'll need to include these asset folders in your app:
https://github.com/BnMcGn/re-com-tailwind/tree/master/run/resources/public/assets

Your html file will need a reference to these two CSS files:

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

