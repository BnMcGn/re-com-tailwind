/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./run/resources/public/compiled_dev/**/*.js'],
  theme: {
      extend: {
          keyframes: {
              stripekey: {
                  from: {
                      'background-position': '40px 0',
                  },
                  to: {
                      'background-position': '0 0',
                  },
              }},
          animation: {
              stripes: 'stripekey 2s linear infinite'
          },
      }
  },
  plugins: [],
}
