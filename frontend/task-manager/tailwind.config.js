/** @type {import('tailwindcss').Config} */
const defaultTheme = require('tailwindcss/defaultTheme')
const colors = require('tailwindcss/colors')

export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        sans: ['"Poppins"', ...defaultTheme.fontFamily.sans]
      }
    },
    colors: {
      primaryColor: '#1E1D27',
      secondaryColor: '#C1FB47',
      white: colors.white,
      black: colors.black,
      green: colors.green,
      red: colors.red
    },
    screens: {
      'mobile': {'max': '576px'},
      'laptop': {'max': '1920px'},
      'desktop': {'max':'2440px'},
    },
  },
  plugins: [],
}